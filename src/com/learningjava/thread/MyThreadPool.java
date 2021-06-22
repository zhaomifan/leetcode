package com.learningjava.thread;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class MyThreadPool {
    private static ExecutorService executor = new ThreadPoolExecutor(1, 2,
            60L, TimeUnit.SECONDS,
            new ArrayBlockingQueue(10));

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Future<Integer> submit = executor.submit(new MyTask(1001));

        Future<Integer> submit1 = executor.submit(new MyTask(1002));
        Future<Integer> submit2 = executor.submit(new MyTask(1003));
        Future<Integer> submit3 = executor.submit(new MyTask(1004));
        submit.get(1, TimeUnit.SECONDS);
        System.out.println(submit.get());
        System.out.println(submit1.get());
        System.out.println(submit2.get());
        System.out.println(submit3.get());
    }
}

class MyTask implements Callable<Integer> {
    Integer id = null;

    public MyTask(Integer name) {
        this.id = name;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("goo");
        sleep(200);
        System.out.println("goo");
        return this.id;
    }
}
