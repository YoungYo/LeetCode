package medium;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _1226_TheDiningPhilosophers {
    static class PickLeftFork implements Runnable{
        int i;
        public PickLeftFork(int i){
            this.i = i;
        }
        @Override
        public void run() {
            System.out.printf("Philosopher%d pick left fork%d.\n", i, i);
        }
    }
    static class PickRightFork implements Runnable{
        int i;
        public PickRightFork(int i){
            this.i = i;
        }
        @Override
        public void run() {
            System.out.printf("Philosopher%d pick right fork%d.\n", i, (i + 4) % 5);
        }
    }
    static class Eat implements Runnable{
        int i;
        public Eat(int i){
            this.i = i;
        }
        @Override
        public void run() {
            System.out.printf("Philosopher%d eat.\n", i);
        }
    }
    static class PutLeftFork implements Runnable{
        int i;
        public PutLeftFork(int i){
            this.i = i;
        }
        @Override
        public void run() {
            System.out.printf("Philosopher%d put left fork%d.\n", i, i);
        }
    }
    static class PutRightFork implements Runnable{
        int i;
        public PutRightFork(int i){
            this.i = i;
        }
        @Override
        public void run() {
            System.out.printf("Philosopher%d put right fork%d.\n", i, (i + 4) % 5);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        DiningPhilosophers1 dp = new DiningPhilosophers1();
        int n = 50;
        final int i0 = 0;
        Thread t0 = new Thread(() -> {
            try {
                for (int i = 0; i < n; i++) {
                    dp.wantsToEat(i0, new PickLeftFork(i0), new PickRightFork(i0),
                            new Eat(i0), new PutLeftFork(i0), new PutRightFork(i0));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        final int i1 = 1;
        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < n; i++) {
                    dp.wantsToEat(i1, new PickLeftFork(i1), new PickRightFork(i1),
                            new Eat(i1), new PutLeftFork(i1), new PutRightFork(i1));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        final int i2 = 2;
        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < n; i++) {
                    dp.wantsToEat(i2, new PickLeftFork(i2), new PickRightFork(i2),
                            new Eat(i2), new PutLeftFork(i2), new PutRightFork(i2));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        final int i3 = 3;
        Thread t3 = new Thread(() -> {
            try {
                for (int i = 0; i < n; i++) {
                    dp.wantsToEat(i3, new PickLeftFork(i3), new PickRightFork(i3),
                            new Eat(i3), new PutLeftFork(i3), new PutRightFork(i3));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        final int i4 = 4;
        Thread t4 = new Thread(() -> {
            try {
                for (int i = 0; i < n; i++) {
                    dp.wantsToEat(i4, new PickLeftFork(i4), new PickRightFork(i4),
                            new Eat(i4), new PutLeftFork(i4), new PutRightFork(i4));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t0.join();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
//        for (int i: dp.eatres ) {
//            System.out.printf("%d, ", i);
//        }
    }
}

class DiningPhilosophers1 {
    private Lock[] locks = {new ReentrantLock(), new ReentrantLock(), new ReentrantLock(), new ReentrantLock(), new ReentrantLock()};
    private Semaphore sem = new Semaphore(3);

    public DiningPhilosophers1() {
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        sem.acquire();
        locks[philosopher].lock();
        locks[(philosopher + 4) % 5].lock();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        locks[philosopher].unlock();
        locks[(philosopher + 4) % 5].unlock();
        sem.release();
    }
}

class DiningPhilosophers {

    private Semaphore[] sems = new Semaphore[5];
//    public int[] eatres = new int[5];

    public DiningPhilosophers() {
        for (int i = 0; i < sems.length; i++) {
            sems[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

//        System.out.printf("Philosopher%d want to eat\n", philosopher);
        while (true) {
//            System.out.printf("Philosopher%d is trying to pick fork%d and fork%d\n", philosopher, philosopher, (philosopher + 4) % 5);
            if (sems[philosopher].tryAcquire()){
                if (sems[(philosopher + 4) % 5].tryAcquire()){
                    break;
                }else {
                    sems[philosopher].release();
                }
            }
        }
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
//        eatres[philosopher]++;
        putLeftFork.run();
        putRightFork.run();
        sems[philosopher].release();
        sems[(philosopher + 4) % 5].release();
    }
}
