
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
@Table(name = "Time")
public class Time{

  @Id
  @SequenceGenerator(name = "TIME_SEQ", sequenceName = "TIME_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIME_SEQ")
  @Column(name = "TIME_ID", unique = true, nullable = true)

  private @NonNull Long id;
  private @NonNull String time;
  
  
  @OneToMany(fetch = FetchType.EAGER)
  private Collection<Schedule> schedule;
}