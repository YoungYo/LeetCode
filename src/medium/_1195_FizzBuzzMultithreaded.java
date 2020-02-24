package medium;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class _1195_FizzBuzzMultithreaded {
    public static void main(String[] args) {
        FizzBuzz3 fb = new FizzBuzz3(30);
        IntConsumer ic = x -> System.out.print(x);
        Thread t1 = new Thread(() -> {
            try {
                fb.fizz(() -> System.out.print("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fb.buzz(() -> System.out.print("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                fb.fizzbuzz(() -> System.out.print("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t4 = new Thread(() -> {
            try {
                fb.number(ic);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

/** 利用管程实现（Lock + Condition） */
class FizzBuzz2 {
    private int n;
    private int count = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition print = lock.newCondition();

    public FizzBuzz2(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0){
                lock.lock();
                try {
                    while (i > count)
                        print.await();
                    printFizz.run();
                    if (i < n){
                        System.out.print(", ");
                    }else {
                        System.out.print(".");
                    }
                    count = i + 1;
                    print.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0){
                lock.lock();
                try {
                    while (i > count)
                        print.await();
                    printBuzz.run();
                    if (i < n){
                        System.out.print(", ");
                    }else {
                        System.out.print(".");
                    }
                    count = i + 1;
                    print.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0){
                lock.lock();
                try {
                    while (i > count)
                        print.await();
                    printFizzBuzz.run();
                    if (i < n){
                        System.out.print(", ");
                    }else {
                        System.out.print(".");
                    }
                    count = i + 1;
                    print.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0){
                lock.lock();
                try {
                    while (i > count)
                        print.await();
                    printNumber.accept(i);
                    if (i < n){
                        System.out.print(", ");
                    }else {
                        System.out.print(".");
                    }
                    count = i + 1;
                    print.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}

/** 利用管程实现（synchronized + wait() + notifyAll()） */
class FizzBuzz1 {
    private int n;
    private int count = 1;

    public FizzBuzz1(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0){
                synchronized (this) {
                    while (i > count)
                        wait();
                    printFizz.run();
                    if (i < n){
                        System.out.print(", ");
                    }else {
                        System.out.print(".");
                    }
                    count = i + 1;
                    notifyAll();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0){
                synchronized (this) {
                    while (i > count)
                        wait();
                    printBuzz.run();
                    if (i < n){
                        System.out.print(", ");
                    }else {
                        System.out.print(".");
                    }
                    count = i + 1;
                    notifyAll();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0){
                synchronized (this) {
                    while (i > count)
                        wait();
                    printFizzBuzz.run();
                    if (i < n){
                        System.out.print(", ");
                    }else {
                        System.out.print(".");
                    }
                    count = i + 1;
                    notifyAll();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0){
                synchronized (this) {
                    while (i > count)
                        wait();
                    printNumber.accept(i);
                    if (i < n){
                        System.out.print(", ");
                    }else {
                        System.out.print(".");
                    }
                    count = i + 1;
                    notifyAll();
                }
            }
        }
    }
}

/** 利用信号量实现 */
class FizzBuzz {
    private int n;
    Semaphore sem = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0){
                while (!sem.tryAcquire(i));
                printFizz.run();
                if (i < n){
                    System.out.print(", ");
                }else {
                    System.out.print(".");
                }
                sem.release(i + 1);
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0){
                while (!sem.tryAcquire(i));
                printBuzz.run();
                if (i < n){
                    System.out.print(", ");
                }else {
                    System.out.print(".");
                }
                sem.release(i + 1);
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0){
                while (!sem.tryAcquire(i));
                printFizzBuzz.run();
                if (i < n){
                    System.out.print(", ");
                }else {
                    System.out.print(".");
                }
                sem.release(i + 1);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0){
                while (!sem.tryAcquire(i));
                printNumber.accept(i);
                if (i < n){
                    System.out.print(", ");
                }else {
                    System.out.print(".");
                }
                sem.release(i + 1);
            }
        }
    }
}

/** 利用信号量实现的另一种方式 */
class FizzBuzz3 {
    private int n;
    private int k = 1;

    private Semaphore fizz = new Semaphore(0);
    private Semaphore buzz = new Semaphore(0);
    private Semaphore fizzbuzz = new Semaphore(0);
    private Semaphore number = new Semaphore(1);

    public FizzBuzz3(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true){
            fizz.acquire();
            if (k > n){
                buzz.release();
                fizzbuzz.release();
                number.release();
                break;
            }
            printFizz.run();
            k++;
            if (k % 15 == 0){
                fizzbuzz.release();
            }else if (k % 3 == 0){
                fizz.release();
            }else if (k % 5 == 0){
                buzz.release();
            }else {
                number.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true){
            buzz.acquire();
            if (k > n){
                fizz.release();
                fizzbuzz.release();
                number.release();
                break;
            }
            printBuzz.run();
            k++;
            if (k % 15 == 0){
                fizzbuzz.release();
            }else if (k % 3 == 0){
                fizz.release();
            }else if (k % 5 == 0){
                buzz.release();
            }else {
                number.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true){
            fizzbuzz.acquire();
            if (k > n){
                fizz.release();
                buzz.release();
                number.release();
                break;
            }
            printFizzBuzz.run();
            k++;
            if (k % 15 == 0){
                fizzbuzz.release();
            }else if (k % 3 == 0){
                fizz.release();
            }else if (k % 5 == 0){
                buzz.release();
            }else {
                number.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true){
            number.acquire();
            if (k > n){
                fizz.release();
                buzz.release();
                fizzbuzz.release();
                break;
            }
            printNumber.accept(k);
            k++;
            if (k % 15 == 0){
                fizzbuzz.release();
            }else if (k % 3 == 0){
                fizz.release();
            }else if (k % 5 == 0){
                buzz.release();
            }else {
                number.release();
            }
        }
    }
}
