package com.channoufi.banking.models;


import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {

  @Id
  @GeneratedValue
  private Integer id;

  @CreatedDate
  @Column(
      name = "createdDate",
      nullable = false,
      updatable = false
  )
  private LocalDateTime createdDate;

  @LastModifiedDate
  @Column(name = "lastModifiedDate")
  private LocalDateTime lastModifiedDate;

}