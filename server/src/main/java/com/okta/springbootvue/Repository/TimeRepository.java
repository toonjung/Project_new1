package com.okta.springbootvue.Repository;  
  
import com.okta.springbootvue.Entity.Time;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource  
public interface TimeRepository extends JpaRepository<Time, Long> {
    Time findById(long id);
}