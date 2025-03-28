package com.mgumussoy.kodluyoruz.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data

@MappedSuperclass

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date,update_date"},allowGetters = true)
public class BaseEntity {

    @Id
    @Column(name = "id",nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="created_by")
    @CreatedBy
    private String createdBy;

    @Column(name="created_date")
    @CreatedDate
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "update_by")
    @LastModifiedBy
    private String updateBy;

    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;

    @Column(name="system_auto_date")
    @CreationTimestamp
    private Date date;
}
