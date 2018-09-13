package studyconcurrent.java5;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kyle on 2018/9/12.
 */
public class ExecutorDemo {


    public static void main(String[] args) {
        //Executor 执行器； 线程池（ThreadPoolExecutor）是他的实现；
        ExecutorService executorService  = Executors.newFixedThreadPool(2);

        //启动并执行 线程
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("-------------" +Thread.currentThread().getName() + " --------");
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("-------------" +Thread.currentThread().getName() + " --------");

            }
        });

        //关闭执行器
        executorService.shutdown();



    }



    public static void main1(String[] args) {
        //Executor 执行器； 线程池（ThreadPoolExecutor）是他的实现；
        Executor executor = Executors.newFixedThreadPool(2);

        //启动并执行 线程
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("-------------" +Thread.currentThread().getName() + " --------");
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("-------------" +Thread.currentThread().getName() + " --------");

            }
        });

        //关闭执行器
        //((ExecutorService) executor).shutdown();
        if(executor instanceof ExecutorService){
            ExecutorService executorService = ExecutorService.class.cast(executor);
            executorService.shutdown();
        }

    }
}
