package com.manal.conferencedemospringboot.controllers;

import com.manal.conferencedemospringboot.models.Speaker;
import com.manal.conferencedemospringboot.repositories.SpeakerRepository;
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

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

  @Autowired
  private SpeakerRepository speakerRepository;

  @GetMapping
  public List<Speaker> list() {
    return speakerRepository.findAll();
  }

  @GetMapping
  @RequestMapping("{id}")
  public Speaker get(@PathVariable Long id) {
    return speakerRepository.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Speaker create(@RequestBody Speaker speaker) {
    return speakerRepository.saveAndFlush(speaker);
  }

  @PutMapping
  @RequestMapping("{id}")
  public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
    Speaker existingSpeaker = speakerRepository.getById(id);
    BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
    return speakerRepository.saveAndFlush(existingSpeaker);
  }

  @DeleteMapping
  @RequestMapping("{id}")
  public void delete(@PathVariable Long id) {
    speakerRepository.deleteById(id);
  }

}
