
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
@Table(name = "Duration")
public class Duration{

  @Id
  @SequenceGenerator(name = "Duration_SEQ", sequenceName = "Duration_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Duration_SEQ")
  @Column(name = "Duration_ID", unique = true, nullable = true)

  private @NonNull Long id;
  private @NonNull String duration;
  
}