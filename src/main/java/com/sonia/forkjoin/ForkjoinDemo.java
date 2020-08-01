package com.sonia.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkjoinDemo extends RecursiveTask<Long> {
    private Long start;
    private Long end;

    //临界值
    private Long temp = 10000L;

    public ForkjoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    protected Long compute() {
        if ((end-start) < temp) {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else{
            long middle = (end-start)/2+start;
            ForkjoinDemo task1 = new ForkjoinDemo(start, middle);
            task1.fork();//拆分任务， 把任务压入线程队列
            ForkjoinDemo task2 = new ForkjoinDemo(middle + 1, end);
            task2.fork();//拆分任务， 把任务压入线程队列
            return  task1.join()+task2.join();
        }
    }
}
