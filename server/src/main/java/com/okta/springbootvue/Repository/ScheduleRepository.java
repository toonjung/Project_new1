package com.okta.springbootvue.Repository;  
  
import com.okta.springbootvue.Entity.Schedule;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource  
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Schedule findById(long id);
}