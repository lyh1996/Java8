/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-04-17 14:55
 */
package DelayTask;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author LYH
 * @date 2020/04/17 14:55
 */
public class DelayTest {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue delayQueue = new DelayQueue();
        // 添加延迟任务
        delayQueue.put(new DelayElement(1000));
        delayQueue.put(new DelayElement(3000));
        delayQueue.put(new DelayElement(5000));
        System.out.println("开始时间：" + DateFormat.getDateTimeInstance().format(new Date()));
        while (!delayQueue.isEmpty()) {
            // 执行延迟任务
            System.out.println(delayQueue.take());
        }
        System.out.println("结束时间：" + DateFormat.getDateTimeInstance().format(new Date()));
    }

    static class DelayElement implements Delayed {
        // 延迟截止时间（单面：毫秒）
        long delayTime = System.currentTimeMillis();

        public DelayElement(long delayTime) {
            this.delayTime = (this.delayTime + delayTime);
        }

        @Override
        // 获取剩余时间
        public long getDelay(TimeUnit unit) {
            return unit.convert(delayTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        // 队列里元素的排序依据
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
                return 1;
            } else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
                return -1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return DateFormat.getDateTimeInstance().format(new Date(delayTime));
        }
    }
}