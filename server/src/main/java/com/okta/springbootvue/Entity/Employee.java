package com.okta.springbootvue.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.okta.springbootvue.Entity.Schedule;


@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Employee" )//สร้างตารางที่ชื่อว่า Day
public class Employee{

  @Id
  @SequenceGenerator(name = "EMPLOYEE_SEQ", sequenceName = "EMPLOYEE_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_SEQ")
  @Column(name = "EMPLOYEE_ID", unique = true, nullable = true)

  private @NonNull Long id;
  private @NonNull String employee;

  @OneToMany(fetch = FetchType.EAGER)
  private Collection<Schedule> schedule;

}