package com.okta.springbootvue.Entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;


@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Employee" )//สร้างตารางที่ชื่อว่า Employee
public class Employee{

  @Id
  @SequenceGenerator(name = "EMPLOYEE_SEQ", sequenceName = "EMPLOYEE_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_SEQ")
  @Column(name = "EMPLOYEE_ID", unique = true, nullable = true)

  private @NonNull Long id;
  private @NonNull String employee;

}