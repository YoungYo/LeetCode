package easy;

public class _1114_PrintinOrder{
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Thread t1 = new Thread(()-> {
            try {
                foo.first(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("first");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()-> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(()-> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}

class Foo {
    volatile boolean firstDone = false;
    volatile boolean secondDone = false;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstDone = true;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!firstDone);

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondDone = true;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!secondDone);

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
