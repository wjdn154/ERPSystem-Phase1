package com.erp.system.common.batch_scheduler;

import com.erp.system.common.DependencyInjector;
import com.erp.system.common.ERPDataInitializer;
import com.erp.system.financial.controller.basic_information_management.PurchaseSalesSlipController;
import com.erp.system.financial.service.basic_information_management.PurchaseSalesSlipService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

class BatchSchedulerTest {
    private DependencyInjector injector;
    private BatchController batchController;

    @BeforeEach
    void setUp() {
        // DI 컨테이너 생성
        injector = DependencyInjector.getInstance();

        // BatchController 인스턴스 생성
        batchController = injector.getInstance(BatchController.class);

    }

    @Test
    void testBatchJobExecution() {
        // AtomicBoolean을 사용하여 서비스 메소드 호출 여부를 트래킹
        AtomicBoolean wasCalled = new AtomicBoolean(false);

        // 실제 서비스 메소드 대신 테스트를 위한 Runnable을 정의
        Runnable task = () -> wasCalled.set(true);

        // 주어진 서비스 메소드를 1초 간격으로 반복 실행하도록 스케줄
        batchController.scheduleServiceTask("task1", task, 0, 1, TimeUnit.SECONDS);

        // 스케줄러가 실행되어 테스트 태스크가 최소 한 번 호출될 시간을 확보
        try {
            Thread.sleep(5000); // 테스트 동안 5초간 대기
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 현재 스레드의 인터럽트 상태를 설정
        }

        System.out.println(batchController.listScheduledJobs());

        // 스케줄링된 작업을 취소
        batchController.cancelJob("task1");

        // 스케줄러를 정지하여 모든 스케줄된 작업을 종료
        batchController.stopScheduler();

        // AtomicBoolean의 값으로 메소드 호출 여부 확인
        assertTrue(wasCalled.get(), "테스트 메서드가 한 번 이상 호출되어야 합니다.");

        System.out.println("스케줄러가 중지되었습니다.");
    }
}