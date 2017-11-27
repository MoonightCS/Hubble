package bodya.popov.ru.hubble.app.async;

import android.support.annotation.NonNull;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.lang.reflect.Modifier;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/**
 * @author Popov Bogdan
 */

public class SingleAsyncExecution<T> implements WorkerHandlerThread.WorkerCallback<T> {

    private static final String TAG = "SingleAsyncExecution";

    private WorkerHandlerThread<T> mWorkerHandlerThread;
    private final Callable<? extends T> mCallable;
    private WeakReference<Callback<T>> mWeakCallback;
    private Executor mMainThreadExecutor = new MainThreadExecutor();


    @NonNull
    public static <T> SingleAsyncExecution<T> fromCallable(Callable<? extends T> callable) {
        if (callable == null) {
            throw new IllegalStateException("Callable cannot be null");
        }
        return new SingleAsyncExecution<>(callable);
    }

    private SingleAsyncExecution(@NonNull Callable<? extends T> callable) {
        this.mCallable = callable;
        mWorkerHandlerThread = new WorkerHandlerThread<>();
        mWorkerHandlerThread.setListener(this);
    }

    @NonNull
    public SingleAsyncExecution<T> withCallback(@NonNull Callback<T> callback) {
        if (callback.getClass().isMemberClass() && !Modifier.isStatic(callback.getClass().getModifiers())) {
            throw new IllegalArgumentException(
                    "No anonymous class here: " + callback);
        }
        this.mWeakCallback = new WeakReference<>(callback);
        return this;
    }

    public FutureTask<T> execute() {
        return submit(mCallable);
    }

    @Override
    public void onLoadFinished(@NonNull FutureTask<T> task) {
        if (task.isCanceled()) {
            return;
        }
        T result = task.getResult();
        Exception exception = task.getException();
        if (result != null && exception == null) {
            postSuccess(result);
        } else if (exception != null) {
            postException(exception);
        }
        mWorkerHandlerThread.quit();
    }

    private FutureTask<T> submit(@NonNull Callable<? extends T> callable) {
        final FutureTask<T> futureTask = new FutureTask<>(callable);
        mWorkerHandlerThread.queueTask(futureTask);
        return futureTask;
    }

    private <V> void postSuccess(final T result) {
        mMainThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "success on thread: " + Thread.currentThread());
                Callback<T> callback = mWeakCallback.get();
                if (callback != null) {
                    callback.onSuccess(result);
                }
            }
        });
    }

    private void postException(final Exception exception) {
        mMainThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "exception on thread: " + Thread.currentThread());
                Callback callback = mWeakCallback.get();
                if (callback != null) {
                    callback.onException(exception);
                }
            }
        });
    }

    public interface Callback<T> {
        void onSuccess(@NonNull T result);

        void onException(Exception e);
    }
}
