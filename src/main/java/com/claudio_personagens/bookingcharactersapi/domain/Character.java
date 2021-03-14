package com.claudio_personagens.bookingcharactersapi.domain;

import com.claudio_personagens.bookingcharactersapi.base.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Character extends AbstractBaseEntity {
    private float price;
}
