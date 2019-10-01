package com.okta.springbootvue;

import java.util.stream.Stream;

import com.okta.springbootvue.Entity.Day;
import com.okta.springbootvue.Entity.Room;
import com.okta.springbootvue.Entity.PeriodTime;
import com.okta.springbootvue.Repository.DayRepository;
import com.okta.springbootvue.Repository.RoomRepository;
import com.okta.springbootvue.Repository.PeriodTimeRepository;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class SpringBootVueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVueApplication.class, args);
	}

	@Bean
    ApplicationRunner init(DayRepository dayRepository,PeriodTimeRepository periodTimeRepository ,
	RoomRepository roomRepository) {
		return args -> {
			
			Stream.of("Monday", "Thuesday", "Wendenday", "Thursday", "Friday").forEach(days-> {
				Day day = new Day();
			    day.setDay(days);
				dayRepository.save(day);
			});

			Stream.of("08.00-09.00", 
					"09.00-10.00",
					"10.00-11.00",
					"11.00-12.00",
					"12.00-13.00",
					"13.00-14.00", 
					"14.00-15.00",
					"15.00-16.00").forEach(periodTimes-> {
				
			PeriodTime periodTime = new PeriodTime();
			periodTime.setPeriodTime(periodTimes);
			periodTimeRepository.save(periodTime);
            });
            
            Stream.of("ห้องตรวจ1", "ห้องตรวจ2", "ห้องตรวจ3","ห้องตรวจ4","ห้องตรวจ5").forEach(rooms -> {
				Room room = new Room();
				room.setRoom(rooms);
				roomRepository.save(room);
			});

			dayRepository.findAll().forEach(System.out::println);
            periodTimeRepository.findAll().forEach(System.out::println);
			roomRepository.findAll().forEach(System.out::println);
			
		};    
	}

}
