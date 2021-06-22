package com.learningjava.thread;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test(10);

    }

    public static void test(int taskSize) throws ExecutionException, InterruptedException {
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            Callable c = new MyCallable(i + " ");
            // 执行任务并获取 Future 对象
            Future f = pool.submit(c);
            list.add(f);
        }
        // 关闭线程池
        pool.shutdown();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        // 获取所有并发任务的运行结果
        for (Future f : list) {
            // 从 Future 对象上获取任务的返回值，并输出到控制台
            System.out.println("res：" + f.get().toString());
        }
    }
}

class MyCallable implements Callable<String> {
    private  String name;

    public MyCallable(String threadName) {
        this.name = threadName;
    }

    @Override
    public String call() throws Exception {
        String tmp = this.name;
        this.name += " running";
        Thread.sleep(1000);
        return tmp + "is running.";
    }
}