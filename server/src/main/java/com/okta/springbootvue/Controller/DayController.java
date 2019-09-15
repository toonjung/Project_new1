package com.okta.springbootvue.Controller;

import com.okta.springbootvue.Entity.Day;
import com.okta.springbootvue.Repository.DayRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class DayController {

    @Autowired
    private final DayRepository dayRepository;
    
    public DayController(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    @GetMapping("/day")
    public Collection<Day> days() {
        return dayRepository.findAll().stream().collect(Collectors.toList());
    }

}
