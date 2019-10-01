package com.okta.springbootvue.Controller;

import com.okta.springbootvue.Entity.DoctorProfile;
import com.okta.springbootvue.Repository.DoctorProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class DoctorProfileController {

    @Autowired
    private final DoctorProfileRepository doctorProfileRepository;

    public DoctorProfileController(DoctorProfileRepository doctorProfileRepository) {
        this.doctorProfileRepository = doctorProfileRepository;
    }

    @GetMapping("/doctorProfile")
    public Collection<DoctorProfile> DoctorProfiles() {
        return doctorProfileRepository.findAll().stream().collect(Collectors.toList());
    }
 
    @GetMapping("/doctorProfile/{id}")
    public Optional<DoctorProfile> Patients(@PathVariable Long id) {
        Optional<DoctorProfile> doctorProfile = doctorProfileRepository.findById(id);
        return doctorProfile;
    }

}