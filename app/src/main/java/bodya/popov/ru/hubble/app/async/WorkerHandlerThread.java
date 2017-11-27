package bodya.popov.ru.hubble.app.async;

import android.os.HandlerThread;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author Popov Bogdan
 */

public class WorkerHandlerThread<T> extends HandlerThread {

    private static final String TAG = "WorkerHandlerThread";

    private DownloadCompletionService<FutureTask<T>> mCompletionService;
    private WeakReference<WorkerCallback<T>> mWorkerCallbackWeakReference = new WeakReference<>(null);
    private HelperThread mHelperThread;


    WorkerHandlerThread() {
        super(TAG);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        mCompletionService = new DownloadCompletionService<>(executorService);
        mHelperThread = new HelperThread(mCompletionService);
        mHelperThread.start();
    }

    @Override
    public boolean quit() {
        Log.e(TAG, "quit");
        mCompletionService.shutdown();
        mHelperThread.interrupt();
        return super.quit();
    }

    void setListener(WorkerCallback<T> callback) {
        mWorkerCallbackWeakReference = new WeakReference<>(callback);
    }

    void queueTask(final FutureTask<T> futureTask) {
        Log.e(TAG, "futureTask added to the queue: " + futureTask);
        mCompletionService.submit(new Callable<FutureTask<T>>() {
            @Override
            public FutureTask<T> call() throws Exception {
                T result;
                try {
                    Log.e(TAG, "executing task on thread: " + Thread.currentThread());
                    result = futureTask.getCallable().call();
                    futureTask.setResult(result);
                    return futureTask;
                } catch (Exception e) {
                    futureTask.setException(e);
                    return futureTask;
                }
            }
        });
    }

    private class HelperThread extends Thread {
        private DownloadCompletionService<FutureTask<T>> service;

        HelperThread(DownloadCompletionService<FutureTask<T>> service) {
            super("HelperThread");
            this.service = service;
        }

        @Override
        public void run() {
            super.run();
            try {
                Log.e(TAG, "workerThreadHelper run on thread: " + Thread.currentThread());
                while (!service.isTerminated() && !isInterrupted()) {
                    Future<FutureTask<T>> future = service.poll(1, TimeUnit.SECONDS);
                    if (future != null) {
                        WorkerCallback<T> callback = mWorkerCallbackWeakReference.get();
                        if (callback != null) {
                            callback.onLoadFinished(future.get());
                        }
                        quit();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    interface WorkerCallback<T> {
        void onLoadFinished(FutureTask<T> task);
    }
}
