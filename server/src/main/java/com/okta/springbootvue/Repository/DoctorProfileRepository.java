package com.okta.springbootvue.Repository;

import com.okta.springbootvue.Entity.DoctorProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface DoctorProfileRepository extends JpaRepository<DoctorProfile, Long> {
	DoctorProfile findById(long id);
}