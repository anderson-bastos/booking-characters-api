package com.claudio_personagens.bookingcharactersapi.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(length = 50)
    private String id;
}
