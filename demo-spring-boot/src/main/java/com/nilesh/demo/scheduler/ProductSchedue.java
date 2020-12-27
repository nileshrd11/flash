package com.nilesh.demo.scheduler;

import java.util.concurrent.Delayed;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ProductSchedue {
	
	@Scheduled(fixedDelay = 1000)
	public void ScheduleTime() {
		System.out.println("Hello");
	}
}
