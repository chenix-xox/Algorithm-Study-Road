package extra;

import static extra.交替打印数字.lock;

/**
 * @author chenix
 * @date 2024.08.30 01:14
 * @description
 */
public class 交替打印数字 {
    static int i = 0;
    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Task()).start();
        Thread.sleep(100);
        new Thread(new Task()).start();
    }
}

class Task implements Runnable{

    @Override
    public void run() {
        while (交替打印数字.i < 100){
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + ":" + 交替打印数字.i++);

                // 唤醒等待此对象的线程
                lock.notifyAll();

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}