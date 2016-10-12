package alanpan.gbi.com.frescodemo.thread;

import android.support.annotation.NonNull;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by alan.pan on 2016/10/12.
 */
public class ThreadTest {


    public void initTest(){
        ReadWriteLock readWriteLock = new ReadWriteLock() {
            @NonNull
            @Override
            public Lock readLock() {
                return null;
            }

            @NonNull
            @Override
            public Lock writeLock() {
                return null;
            }
        };

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
    }
}
