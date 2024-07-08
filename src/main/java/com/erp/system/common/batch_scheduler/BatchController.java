package com.erp.system.common.batch_scheduler;

import com.erp.system.common.annotation.Component;
import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Component
public class BatchController {
    private final BatchScheduler scheduler;

    /**
     * BatchController 생성자.
     * @param scheduler 스케줄링 작업을 관리할 BatchScheduler의 인스턴스
     */
    public BatchController(BatchScheduler scheduler) {
        this.scheduler = scheduler;
    }

    /**
     * 지정된 서비스의 메소드를 정기적으로 스케줄링함.
     * 이 메소드를 사용하여 주어진 작업을 특정 주기와 초기 지연 시간으로 반복 실행하도록 스케줄링할 수 있음.
     *
     * @param jobId 작업의 고유 ID
     * @param taskService 실행할 서비스 로직을 포함하는 Runnable
     * @param initialDelay 첫 실행까지의 지연 시간(단위에 따라 다름)
     * @param period 실행 주기(단위에 따라 다름)
     * @param unit 시간 단위, 예를 들어 TimeUnit.SECONDS
     */
    public void scheduleServiceTask(String jobId, Runnable taskService, long initialDelay, long period, TimeUnit unit) {
        scheduler.scheduleJob(jobId, taskService, initialDelay, period, unit);
    }

    /**
     * 이미 스케줄된 작업을 취소함.
     * 이 메소드를 호출하면 지정된 작업 ID에 해당하는 스케줄된 작업이 취소되고 더 이상 실행되지 않음.
     *
     * @param jobId 취소할 작업의 고유 ID
     */
    public void cancelJob(String jobId) {
        scheduler.cancelJob(jobId);
    }

    /**
     * 모든 스케줄링된 작업을 중지하고 스케줄러를 정지함.
     */
    public void stopScheduler() {
        scheduler.stop();
    }

    /**
     * 현재 스케줄러에 등록된 모든 작업의 상태를 출력함.
     * @return 현재 등록된 작업 목록의 문자열 표현
     */
    public String listScheduledJobs() {
        return scheduler.listScheduledJobs();
    }
}