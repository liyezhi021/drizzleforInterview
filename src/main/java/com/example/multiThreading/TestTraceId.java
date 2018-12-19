package com.example.multiThreading;

import com.example.configuration.ThreadPoolTraceLog;
import com.example.constants.Constants;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;

@Service
public class TestTraceId {

    @Autowired
    private ThreadPoolTraceLog threadPoolTraceLog;

    public String test1(){
        Executor executor = threadPoolTraceLog.getAsyncExecutor();
        for(int i=0; i<20; i++){
            executor.execute(new Task());
        }
        return "success";
    }

    public class Task implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println("currentThreadId->"+ Thread.currentThread().getName()
                        +" ...MDC traceId->" +MDC.get(Constants.LOG_TRACE_ID));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
