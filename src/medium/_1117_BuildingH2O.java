package medium;

import java.util.concurrent.Semaphore;

public class _1117_BuildingH2O {
    public static void main(String[] args) {
        H2O h2o = new H2O();
        int n = 4;
        for (int i = 0; i < 2 * n; i++) {
            Thread hydrogen = new Thread(() -> {
                try {
                    h2o.hydrogen(() -> System.out.print('H'));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            hydrogen.start();
        }
        for (int i = 0; i < n; i++) {
            Thread oxygen = new Thread(() -> {
                try {
                    h2o.oxygen(() -> System.out.print('O'));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            oxygen.start();
        }
    }
}

/** 利用信号量实现 */
class H2O {
    Semaphore H = new Semaphore(2, true);
    Semaphore O = new Semaphore(0, true);
    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        H.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        O.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        O.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
		H.release(2);
    }
}
