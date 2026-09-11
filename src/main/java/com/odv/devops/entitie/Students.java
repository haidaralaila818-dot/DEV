package com.odv.devops.entitie;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String nom;
    @Setter
    private String prenom;
    @Setter
    private LocalDate dateN;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    @PrePersist
    void beforeCreate() {
        LocalDateTime now = LocalDateTime.now();
        createDate = now;
        updateDate = now;
    }

    @PreUpdate
    void beforeUpdate() {
        updateDate = LocalDateTime.now();
    }
}
