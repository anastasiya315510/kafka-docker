/*
 author Anastasiya
 created on 29/08/2021
 */


package com.test.kafkadocker.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KafkaRecord {

     private Long pk;
     private LocalDateTime data;
     private LocalDateTime beforeData;
     private HeaderKafkaRecord headers;


}
