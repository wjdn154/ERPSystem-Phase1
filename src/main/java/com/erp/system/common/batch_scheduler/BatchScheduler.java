package com.erp.system.common.batch_scheduler;

import com.erp.system.common.annotation.Component;

import java.util.Map;
import java.util.concurrent.*;
import java.util.StringJoiner;


@Component
public class BatchScheduler {
    private ScheduledExecutorService scheduler;
    private final ConcurrentMap<String, ScheduledFuture<?>> jobs = new ConcurrentHashMap<>();

    /**
     * 스케줄러를 초기화함
     */
    public BatchScheduler() {
        this.scheduler = Executors.newScheduledThreadPool(10);
    }

    /**
     * 주기적으로 작업을 스케줄링함
     * @param jobId 작업의 고유 ID
     * @param task 실행할 작업
     * @param initialDelay 초기 지연 시간
     * @param period 반복 주기
     * @param timeUnit 시간 단위
     * @throws IllegalStateException 이미 등록된 스케줄 ID인 경우
     */
    public void scheduleJob(String jobId, Runnable task, long initialDelay, long period, TimeUnit timeUnit) throws IllegalStateException {
        if (jobs.containsKey(jobId)) {
            throw new IllegalStateException("이미 등록된 스케줄 ID입니다: " + jobId);
        }
        ScheduledFuture<?> scheduledTask = scheduler.scheduleAtFixedRate(task, initialDelay, period, timeUnit);
        jobs.put(jobId, scheduledTask);
        System.out.println("작업이 예약되었습니다: " + jobId + ", 주기: " + period + " " + timeUnit.toString().toLowerCase());
    }

    /**
     * 지정된 작업을 취소함
     * @param jobId 취소할 작업의 ID
     */
    public void cancelJob(String jobId) {
        ScheduledFuture<?> job = jobs.get(jobId);
        if (job != null) {
            job.cancel(false);
            jobs.remove(jobId);
            System.out.println("작업이 취소되었습니다: " + jobId);
        }
    }

    /**
     * 모든 작업을 종료하고 스케줄러를 정지함
     */
    public void stop() {
        // 모든 작업을 취소하고 제거함
        for (Map.Entry<String, ScheduledFuture<?>> entry : jobs.entrySet()) {
            entry.getValue().cancel(false);
        }
        jobs.clear();

        scheduler.shutdownNow();
        try {
            if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                System.err.println("스케줄러가 정상적으로 종료되지 않았습니다.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 스케줄러에 등록된 모든 작업의 상태를 문자열 형태로 반환함
     * @return 현재 등록된 작업 목록의 문자열 표현
     */
    public String listScheduledJobs() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (Map.Entry<String, ScheduledFuture<?>> entry : jobs.entrySet()) {
            String status = entry.getValue().isCancelled() ? "취소됨" : "예약됨";
            joiner.add(String.format("작업 ID: %s, 상태: %s", entry.getKey(), status));
        }
        return joiner.toString();
    }
}