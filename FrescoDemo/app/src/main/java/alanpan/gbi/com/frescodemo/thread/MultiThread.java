package alanpan.gbi.com.frescodemo.thread;

import java.util.concurrent.Executors;
/**
 * Created by alan.pan on 2016/10/17.
 */
public class MultiThread {

    public void init(){
        int threadSize = 5;
        ExecutorService pool =  Executors.newFixedThreadPool(threadSize);
        for (int i = 0; i < threadSize; i++) {

            Callable callable = new MyCallAble("thread :"+i);
            Future future = pool.submit(callable);
            mFuture.add(future);
        }
    }


    class MyCallAble implements Callable<Object> {

        public MyCallAble(String content) {
        }

        @Override
        public Object call() throws Exception {
            return null;
        }
    }
    
}
