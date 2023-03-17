package com.example.grafanaprometheus.schedule;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ScheduleTask {

    @Value("${app.job.scheduler-job.name}")
    private String jobName;

    private final Counter appCounter;

    public ScheduleTask(MeterRegistry meterRegistry) {
        appCounter = meterRegistry.counter("app_counter");
    }

    @Scheduled(fixedDelayString = "${app.job.scheduler-job.fixed-delay.millis}")
    public void scheduleFixedRateTask() {
        appCounter.increment();
        log.info("Job Ran : {} INFO", jobName);
        log.error("Job Ran : {} ERROR", jobName);
    }
}
