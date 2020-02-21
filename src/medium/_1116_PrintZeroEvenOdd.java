package medium;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class _1116_PrintZeroEvenOdd {
    public static void main(String[] args) {
        ZeroEvenOdd1 zeo = new ZeroEvenOdd1(5);
        IntConsumer printNumber = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value);
            }
        };
        Thread t1 = new Thread(() -> {
            try {
                zeo.zero(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                zeo.even(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                zeo.odd(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}

//利用信号量实现
class ZeroEvenOdd1 {
    private int n;
    int k = 0;
    Semaphore zero = new Semaphore(1);
    Semaphore odd = new Semaphore(0);
    Semaphore even = new Semaphore(0);

    public ZeroEvenOdd1(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(true) {
            zero.acquire();
            k ++;
            if(k > n) {
                even.release();
                odd.release();
                break;
            }
            printNumber.accept(0);
            if(k % 2 == 1) {
                odd.release();
            } else {
                even.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(true) {
            even.acquire();
            if(k > n) {
                even.release();
                zero.release();
                break;
            }
            printNumber.accept(k);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(true) {
            odd.acquire();
            if(k > n) {
                zero.release();
                odd.release();
                break;
            }
            printNumber.accept(k);
            zero.release();
        }
    }
}

//利用管程实现
class ZeroEvenOdd {
    private int n;
    private volatile boolean needZero = true;
    private volatile boolean needOdd = false;
    private volatile boolean needEven = false;

    private final Lock lock = new ReentrantLock();

    // 条件变量：需要打印0
    private final Condition printZero = lock.newCondition();
    // 条件变量：需要打印奇数
    private final Condition printOdd = lock.newCondition();
    // 条件变量：需要打印偶数
    private final Condition printEven = lock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            lock.lock();
            try {
                while (!needZero)
                    printZero.await();
                printNumber.accept(0);
                needZero = false;
                if ((i & 1) == 1){
                    needOdd = true;
                    printOdd.signal();
                }else {
                    needEven = true;
                    printEven.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) {
                lock.lock();
                try {
                    while (!needEven){
                        printEven.await();
                    }
                    printNumber.accept(i);
                    needEven = false;
                    needZero = true;
                    printZero.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1){
                lock.lock();
                try {
                    while (!needOdd){
                        printOdd.await();
                    }
                    printNumber.accept(i);
                    needOdd = false;
                    needZero = true;
                    printZero.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
