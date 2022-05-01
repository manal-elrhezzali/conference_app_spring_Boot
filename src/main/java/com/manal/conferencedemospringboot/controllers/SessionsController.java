package com.manal.conferencedemospringboot.controllers;

import com.manal.conferencedemospringboot.models.Session;
import com.manal.conferencedemospringboot.repositories.SessionRepository;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//added so that Spring MVC knows that this is a controller
//means that this will respond to payloads, incoming and outgoing as JSON REST endpoints
@RestController
//tells the router what the mapping URL will look like
@RequestMapping("/api/v1/sessions")
public class SessionsController {
  //injects the sessionRepository that we created
  //Spring will autowire this when our SessionController is built.
  //Spring will create an instance of the SessionRepository and put it onto our class
  @Autowired
  private SessionRepository sessionRepository;

  @GetMapping
  public List<Session> list() {
    return sessionRepository.findAll();
  }

  @GetMapping
  @RequestMapping("{id}")
  public Session get(@PathVariable Long id) {
    return sessionRepository.getById(id);
  }

  @PostMapping
  //Typically, when you create or post something you get a 201 back, but the
  //Spring controllers will by default return 200 when the method executes and finishes.
  //This annotation overrides that, we can specify the exact response we want
  @ResponseStatus(HttpStatus.CREATED)
  public Session create(@RequestBody final Session session) {
    return sessionRepository.saveAndFlush(session);
  }

  @DeleteMapping
  @RequestMapping(value = "{id}")
  public void delete(@PathVariable Long id) {
    //also need to check cascades.
    //this only deletes session records without any children records
    //at this current implementation
    sessionRepository.deleteById(id);
  }

  @PutMapping
  @RequestMapping(value = "{id}")
  public Session update(@PathVariable Long id, @RequestBody Session session) {
    //because this is a PUT, we expect all attributes to be passed in.
    //a Patch would only update passed values
    //TODO: add validation that all attributes are passed in, otherwise return a 400 bad payload
    //finding the session we're going to update
    Session existingSession = sessionRepository.getById(id);
    //takes the existing session and copies the incoming session data onto it, the third
    //param allows us to ignore properties on the entities or Java
    //object that we do not want to copy
    BeanUtils.copyProperties(session, existingSession, "session_id");
    return sessionRepository.saveAndFlush(existingSession);

  }


}
