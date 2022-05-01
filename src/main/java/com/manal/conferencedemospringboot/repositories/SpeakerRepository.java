package com.manal.conferencedemospringboot.repositories;

import com.manal.conferencedemospringboot.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}
