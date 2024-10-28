package com.toy.rtb.model.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class CommonEntity {
    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private LocalDateTime createdDt;

    @Column(nullable = false)
    private String updatedBy;

    @Column(nullable = false)
    private LocalDateTime updatedDt;

    @PrePersist
    public void prePersist() {
        this.createdBy = "admin";
        this.createdDt = LocalDateTime.now();
        this.updatedBy = "admin";
        this.updatedDt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedBy = "admin";
        this.updatedDt = LocalDateTime.now();
    }
}
