package com.erp.system.common.batch_scheduler;

import com.erp.system.common.annotation.Component;

import java.util.concurrent.*;

@Component
public class BatchScheduler {
    private ScheduledExecutorService scheduler;
    private final ConcurrentMap<String, ScheduledFuture<?>> jobs = new ConcurrentHashMap<>();

    /**
     * 생성자에서는 스케줄러를 초기화함.
     */
    public BatchScheduler() {
        this.scheduler = Executors.newScheduledThreadPool(10);
    }

    /**
     * 지정된 작업을 주기적으로 스케줄링함.
     * @param jobId 작업의 고유 ID
     * @param task 실행할 작업
     * @param initialDelay 초기 지연 시간
     * @param period 반복 주기
     * @param timeUnit 시간 단위
     * @throws IllegalStateException 이미 등록된 스케줄 ID인 경우 예외 발생
     */
    public void scheduleJob(String jobId, Runnable task, long initialDelay, long period, TimeUnit timeUnit) {
        if (jobs.containsKey(jobId)) {
            throw new IllegalStateException("스케줄 ID가 이미 등록되어 있습니다: " + jobId);
        }
        ScheduledFuture<?> scheduledTask = scheduler.scheduleAtFixedRate(task, initialDelay, period, timeUnit);
        jobs.put(jobId, scheduledTask);
        System.out.println("작업 예약됨: " + jobId + ", 주기: " + period + " " + timeUnit.toString().toLowerCase());
    }

    /**
     * 지정된 작업을 취소함.
     * @param jobId 취소할 작업의 ID
     */
    public void cancelJob(String jobId) {
        ScheduledFuture<?> job = jobs.get(jobId);
        if (job != null) {
            job.cancel(false);
            jobs.remove(jobId);
            System.out.println("작업 취소됨: " + jobId);
        }
    }

    /**
     * 모든 작업을 종료하고 스케줄러를 정지함.
     */
    public void stop() {
        scheduler.shutdownNow();
        try {
            if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                System.err.println("스케줄러가 정상적으로 종료되지 않았습니다.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}