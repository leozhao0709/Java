package com.lzhao.task.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Async
    public void asyncFunc() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("asyncFunc...");
    }

    @Scheduled(cron = "0-4 * * * * MON-SAT")
    public void cronTask() {
        System.out.println("cron job start...");
    }
}
