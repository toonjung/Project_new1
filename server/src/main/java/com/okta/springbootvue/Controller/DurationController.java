package com.okta.springbootvue.Controller;

import com.okta.springbootvue.Entity.Duration;
import com.okta.springbootvue.Repository.DurationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class DurationController {

    @Autowired
    private final DurationRepository durationRepository;
    
    public DurationController(DurationRepository durationRepository) {
        this.durationRepository = durationRepository;
    }

    @GetMapping("/duration")
    public Collection<Duration> durations() {
        return durationRepository.findAll().stream().collect(Collectors.toList());
    }

}
