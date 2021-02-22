package com.claudio_personagens.bookingcharactersapi.domain;

import com.claudio_personagens.bookingcharactersapi.base.AbstractBaseEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Builder
public class Address extends AbstractBaseEntity {
    @Column(length = 150)
    private String street;
    @Column(length = 5)
    private String number;
    @Column(length = 100)
    private String district;
    @Column(length = 100)
    private String complement;
    @Column(length = 100)
    private String city;
    @Column(length = 100)
    private String state;
}
