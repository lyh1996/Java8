package JavaBase.thread;

import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore
 *
 * @author zhouq
 * @email zhouqiao@gmail.com
 * @date 2018/10/14 22:51
 */
public class TestSemaphore extends Thread {
    public static void main(String[] args) {
        int i = 0;
        while (i < 500) {
            i++;
            new TestSemaphore().start();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 控制某资源同时被访问的个数的类 控制同一时间最后只能有50个访问
     */
    static Semaphore semaphore = new Semaphore(50);
    static int timeout = 500;

    @Override
    public void run() {
        try {
            Object connec = getConnection();
            System.out.println("获得一个连接" + connec);
            Thread.sleep(300);
            releaseConnection(connec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void releaseConnection(Object connec) {
        /* 释放许可 */
        semaphore.release();
        System.out.println("释放一个连接" + connec);
    }

    public Object getConnection() {
        try {/* 获取许可 */
            boolean getAccquire = semaphore.tryAcquire(timeout, TimeUnit.MILLISECONDS);
            if (getAccquire) {
                return UUID.randomUUID().toString();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("timeout");
    }

}