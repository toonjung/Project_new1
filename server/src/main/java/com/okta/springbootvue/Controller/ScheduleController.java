package com.okta.springbootvue.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;

import com.okta.springbootvue.Entity.Day;
import com.okta.springbootvue.Entity.Duration;
import com.okta.springbootvue.Entity.Employee;
import com.okta.springbootvue.Entity.Room;
import com.okta.springbootvue.Entity.Schedule;
import com.okta.springbootvue.Repository.DayRepository;
import com.okta.springbootvue.Repository.DurationRepository;
import com.okta.springbootvue.Repository.EmployeeRepository;
import com.okta.springbootvue.Repository.RoomRepository;
import com.okta.springbootvue.Repository.ScheduleRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ScheduleController {
    @Autowired
    private final ScheduleRepository scheduleRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DayRepository dayRepository;
    @Autowired
    private DurationRepository durationRepository;
    @Autowired
    private RoomRepository roomRepository;


    ScheduleController(ScheduleRepository scheduleRepository) { //name controller:name reoository
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping("/schedule")
    public Collection<Schedule> Schedules() {
        return scheduleRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/schedule/{employee_id}/{day_id}/{duration_id}/{room_id}")
    public Schedule newSchedule(Schedule newSchedule,
    @PathVariable long employee_id,
    @PathVariable long day_id,
    @PathVariable long duration_id,
    @PathVariable long room_id){
    //VideoRental newVideoRental = new VideoRental();

    Day  day= dayRepository.findById(day_id);
    Duration duration = durationRepository.findById(duration_id);
    Room room = roomRepository.findById(room_id);
    Employee employee = employeeRepository.findById(employee_id);
    

    newSchedule.setDay(day);
    newSchedule.setDuration(duration);
    newSchedule.setRoom(room);
    newSchedule.setEmployee(employee);
    

    return scheduleRepository.save(newSchedule); //บันทึก Objcet ชื่อ VideoRental
    
    }
}