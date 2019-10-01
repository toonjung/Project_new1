package com.okta.springbootvue.Controller;

import com.okta.springbootvue.Entity.PeriodTime;
import com.okta.springbootvue.Repository.PeriodTimeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PeriodTimeController {

    @Autowired
    private final PeriodTimeRepository periodTimeRepository;
    
    public PeriodTimeController(PeriodTimeRepository periodTimeRepository) {
        this.periodTimeRepository = periodTimeRepository;
    }

    @GetMapping("/PeriodTime")
    public Collection<PeriodTime> periodTime() {
        return periodTimeRepository.findAll().stream().collect(Collectors.toList());
    }

}
