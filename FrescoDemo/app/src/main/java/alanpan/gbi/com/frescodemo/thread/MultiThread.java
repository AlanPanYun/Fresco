package alanpan.gbi.com.frescodemo.thread;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by alan.pan on 2016/10/17.
 */
public class MultiThread {

    @SuppressWarnings("UnCheck")
    public static void init() throws ExecutionException, InterruptedException {
        int threadSize = 5;
        ExecutorService pool = Executors.newFixedThreadPool(threadSize);

        List<Future> mFuture = new ArrayList<>();
        for (int i = 0; i < threadSize; i++) {

            Callable callable = new MyCallAble("thread :" + i);
//            Runnable mRunnable = new MyRunnable();
//            pool.submit(mRunnable);
            Future future = pool.submit(callable);
            mFuture.add(future);
        }

        pool.shutdown();

        for (Future f :
                mFuture) {
           Log.i("alan","time "+f.get().toString());
        }
    }


    static class MyCallAble implements Callable<Object> {

        private String mContnet;
        public MyCallAble(String content) {
            mContnet = content +"  thread   iji 8 s";
        }

        @Override
        public Object call() throws Exception {
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return mContnet;
        }
    }

    class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
