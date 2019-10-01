package com.okta.springbootvue.Repository;  
  
import com.okta.springbootvue.Entity.PeriodTime;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource  
public interface PeriodTimeRepository extends JpaRepository<PeriodTime, Long> {
    PeriodTime findById(long id);
}