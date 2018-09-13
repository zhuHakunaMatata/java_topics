package studyconcurrent.java7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by kyle on 2018/9/12.
 */
public class ForkJoinSimpleDemo {
    public static void main(String[] args) {

        //并行多核心
        //并发 ； 一同参与
        System.out.println(ForkJoinPool.getCommonPoolParallelism());
        System.out.println(Runtime.getRuntime().availableProcessors());

        // 与线程池的 Executor 类似
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        forkJoinPool.invoke(new RecursiveAction() {
            @Override
            protected void compute() {
                System.out.println("-------" + Thread.currentThread().getName()+"---------");
            }
        });

        //
        forkJoinPool.shutdown();

    }
}
