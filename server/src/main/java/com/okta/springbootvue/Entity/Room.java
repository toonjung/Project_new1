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
@Table(name = "Room")
public class Room{

  @Id
  @SequenceGenerator(name = "ROOM_SEQ", sequenceName = "ROOM_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROOM_SEQ")
  @Column(name = "ROOM_ID", unique = true, nullable = true)

  private @NonNull Long id;
  private @NonNull String room;
  
}