package medium;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _1115_PrintFooBarAlternately {
    public static void main(String[] args) throws InterruptedException {
        FooBar2 foobar = new FooBar2(5);
        Thread t1 = new Thread(()-> {
            try {
                foobar.foo(() -> {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.print("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()-> {
            try {
                foobar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}

class FooBar2 {
    private int n;
    private final CyclicBarrier fooBarrier = new CyclicBarrier(2);
    private final CyclicBarrier barBarrier = new CyclicBarrier(2);

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            try {
                fooBarrier.await();
                barBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            try {
                    fooBarrier.await(); //等待foo打印完毕
                    printBar.run();
                    barBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
class FooBar1 {
    private int n;
    private volatile boolean fooDone;
    private volatile boolean barDone;

    private final Lock lock = new ReentrantLock();

    // 条件变量：foo打印完毕
    private final Condition fooDoneCondition = lock.newCondition();
    // 条件变量：bar打印完毕
    private final Condition barDoneCondition = lock.newCondition();

    public FooBar1(int n) {
        this.n = n;
        fooDone = false;
        barDone = true;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                while (!barDone)
                    barDoneCondition.await(); //等待bar打印完毕
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooDone = true;
                barDone = false;
                fooDoneCondition.signalAll(); //打印foo后，通知其他线程可以打印bar
            }
        } finally {
            lock.unlock();
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                while (!fooDone)
                    fooDoneCondition.await(); //等待foo打印完毕
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                barDone = true;
                fooDone = false;
                barDoneCondition.signalAll(); //打印bar后，通知其他线程可以打印foo
            }
        } finally {
            lock.unlock();
        }
    }
}
class FooBar {
    private int n;
    private volatile boolean fooDone;
    private volatile boolean barDone;

    public FooBar(int n) {
        this.n = n;
        fooDone = false;
        barDone = true;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < n; i++) {
                while (!barDone)
                    wait();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooDone = true;
                barDone = false;
                notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < n; i++) {
                while (!fooDone)
                    wait();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                barDone = true;
                fooDone = false;
                notifyAll();
            }
        }
    }
}
