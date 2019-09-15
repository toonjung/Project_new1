package com.okta.springbootvue.Repository;  
  
import com.okta.springbootvue.Entity.Day;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource  
public interface DayRepository extends JpaRepository<Day, Long> {
    Day findById(long id);
}