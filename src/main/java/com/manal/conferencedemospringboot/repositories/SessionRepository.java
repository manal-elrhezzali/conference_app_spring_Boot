package com.manal.conferencedemospringboot.repositories;

import com.manal.conferencedemospringboot.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

//by extending repository we now have the operations: find, update, delete and a bunch
// of other operations already set up and usable
// for us on our Session JPA class
public interface SessionRepository extends JpaRepository<Session, Long> {

}
