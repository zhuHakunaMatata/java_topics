package studyconcurrent.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by kyle on 2018/9/12.
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//1. CompletableFuture
        CompletableFuture<String> completbaleFuture = new CompletableFuture<String>();
        //set completebaleFuture.result with given value
        completbaleFuture.complete("hello");
        //get() value --- Future
        String result = completbaleFuture.get(); // waits until gotten value
        System.out.println(result);


//2. 异步执行, 阻塞等待
        // 异步执行
        CompletableFuture asyncCompletableFuture = CompletableFuture.runAsync(()->{
            System.out.println("----" + Thread.currentThread().getName() + " --------- ");
        });
        //阻塞等待
        asyncCompletableFuture.get();

//3.异步执行, 阻塞等待 ,, supplyAsync 有返回值
        CompletableFuture<String> supplyAsyncCompletableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println("----" + Thread.currentThread().getName() + " --------- ");
            //假设来自数据库查询，操作很耗时
            return "----" + Thread.currentThread().getName() + " --------- ";
        });
        //阻塞等待
        String result0 = supplyAsyncCompletableFuture.get();

        System.out.println("result == " + result0);


 //4. chainable    thenApply --- sync 操作
        CompletableFuture<String> supplyCompletableFuture = CompletableFuture.supplyAsync(()->{
            //System.out.println("----" + Thread.currentThread().getName() + " --------- ");
            //假设来自数据库查询，操作很耗时
            return " chain 1 " + "----" + Thread.currentThread().getName() + " --------- \n";
        }).thenApply(value -> {
            return " chain 2 " + "----" + Thread.currentThread().getName() + " --------- \n" + value ;
        }).thenApply(value ->{
            value = " chain 3" + "----" + Thread.currentThread().getName() + " --------- \n" + value ;
            System.out.println(value);
            return value;
        });


        /*
             chain 3----main ---------
             chain 2 ----main ---------
             chain 1 ----ForkJoinPool.commonPool-worker-1 ---------

             Starting .............

         */


//5. chainable   Async 操作
        CompletableFuture<String> supplyAsyncCompletableFuture1 = CompletableFuture.supplyAsync(()->{
            //System.out.println("----" + Thread.currentThread().getName() + " --------- ");
            //假设来自数据库查询，操作很耗时
            return " chain 1 " + "----" + Thread.currentThread().getName() + " --------- \n";
        }).thenApplyAsync(value -> {
            return " chain 2 " + "----" + Thread.currentThread().getName() + " --------- \n" + value ;
        }).thenApplyAsync(value ->{
            value = " chain 3" + "----" + Thread.currentThread().getName() + " --------- \n" + value ;
            System.out.println(value);
            return value;
        });

        /*
             Starting .............
                 chain 3----ForkJoinPool.commonPool-worker-1 ---------
                 chain 2 ----ForkJoinPool.commonPool-worker-1 ---------
                 chain 1 ----ForkJoinPool.commonPool-worker-1 ---------


                Process finished with exit code 0

         */

        System.out.println(" Starting ............. ");


    }
}
