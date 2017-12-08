package bodya.popov.ru.hubble.app.async;

import android.util.Log;

import java.util.concurrent.Callable;

/**
 * @author Popov Bogdan
 */

public class FutureTask<T> {

    private long mId;
    private boolean mIsCanceled;
    private boolean mIsDone;
    private final Callable<? extends T> mCallable;
    private T mResult;
    private Exception mException;

    FutureTask(Callable<? extends T> callable) {
        mCallable = callable;
    }

    Callable<? extends T> getCallable() {
        return mCallable;
    }

    public synchronized void cancel() {
        Log.e("FutureTask", "futureTask canceled");
        mIsCanceled = true;
    }

    public synchronized void done() {
        mIsDone = true;
    }

    public synchronized boolean isCanceled() {
        return mIsCanceled;
    }

    public synchronized boolean isDone() {
        return mIsDone;
    }

    public T getResult() {
        return mResult;
    }

    public Exception getException() {
        return mException;
    }

    public long getId() {
        return mId;
    }

    public void setResult(T result) {
        done();
        mResult = result;
    }

    public void setId(long id) {
        mId = id;
    }

    public void setException(Exception exception) {
        done();
        mException = exception;
    }


}
