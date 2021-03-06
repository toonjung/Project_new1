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
import com.okta.springbootvue.Entity.PeriodTime;
import com.okta.springbootvue.Entity.DoctorProfile;
import com.okta.springbootvue.Entity.Room;
import com.okta.springbootvue.Entity.Schedule;
import com.okta.springbootvue.Repository.DayRepository;
import com.okta.springbootvue.Repository.PeriodTimeRepository;
import com.okta.springbootvue.Repository.DoctorProfileRepository;
import com.okta.springbootvue.Repository.RoomRepository;
import com.okta.springbootvue.Repository.ScheduleRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ScheduleController {
    @Autowired
    private final ScheduleRepository scheduleRepository;
    @Autowired
    private DoctorProfileRepository doctorProfileRepository;
    @Autowired
    private DayRepository dayRepository;
    @Autowired
    private PeriodTimeRepository periodTimeRepository;
    @Autowired
    private RoomRepository roomRepository;


    ScheduleController(ScheduleRepository scheduleRepository) { //name controller:name reoository
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping("/schedule")
    public Collection<Schedule> Schedules() {
        return scheduleRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/schedule/{doctorProfile_id}/{room_id}/{day_id}/{periodTime_id}")
    public Schedule newSchedule(Schedule newSchedule,
    @PathVariable long doctorProfile_id,
    @PathVariable long room_id,
    @PathVariable long day_id,
    @PathVariable long periodTime_id){
    
    

    DoctorProfile doctorProfile = doctorProfileRepository.findById(doctorProfile_id);
    Room room = roomRepository.findById(room_id); 
    Day  day= dayRepository.findById(day_id);
    PeriodTime periodTime = periodTimeRepository.findById(periodTime_id);
    
    newSchedule.setDoctorProfile(doctorProfile);
    newSchedule.setRoom(room);
    newSchedule.setDay(day);
    newSchedule.setPeriodTime(periodTime);
    
    

    return scheduleRepository.save(newSchedule); //บันทึก Objcet ชื่อ VideoRental
    
    }
}