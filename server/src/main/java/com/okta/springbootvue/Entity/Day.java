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
@Table(name = "Day" )//สร้างตารางที่ชื่อว่า Day
public class Day{

  @Id
  @SequenceGenerator(name = "DAY_SEQ", sequenceName = "DAY_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAY_SEQ")
  @Column(name = "DAY_ID", unique = true, nullable = true)

  private @NonNull Long id;
  private @NonNull String day;

}