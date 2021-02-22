package com.claudio_personagens.bookingcharactersapi.domain;

import com.claudio_personagens.bookingcharactersapi.base.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
public class Booking extends AbstractBaseEntity {
    private Client client;
    private CharacterGroup characterGroup;
    private LocalDate bookingAt;
}
