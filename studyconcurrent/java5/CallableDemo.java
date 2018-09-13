package studyconcurrent.java5;

import java.util.concurrent.*;

/**
 * Created by kyle on 2018/9/12.
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //执行器服务 ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return " new callable --- thread ";
            }
        });

        //阻塞等待
        while(true){
            if(future.isDone()){
                break;
            }
        }

        //阻塞获取数据
        String result = future.get();
        System.out.println(result);

        // 关闭ExecutorService:;
        //一般在
        executorService.shutdown();

    }
}
