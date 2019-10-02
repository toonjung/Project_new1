
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
@Table(name = "PeriodTime")
public class PeriodTime{

  @Id
  @SequenceGenerator(name = "PeriodTime_SEQ", sequenceName = "PeriodTime_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PeriodTime_SEQ")
  @Column(name = "PeriodTime_ID", unique = true, nullable = true)

  private @NonNull Long id;
  private @NonNull String PeriodTime;
  

}