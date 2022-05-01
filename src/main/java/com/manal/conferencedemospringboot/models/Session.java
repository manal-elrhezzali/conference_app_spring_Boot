package com.manal.conferencedemospringboot.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name= "sessions")
public class Session {
  //these attributes do not follow the Java naming convention
  //we named them as we did in the DB columns, so that
  // JPA will auto-bind to these columns and we don't
  // need to annotate them
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long session_id;
  private String session_name;
  private String session_description;
  private Integer session_length;

  //means that we are setting a many-to-many relationship
  //and that we have a mapping JoinTable in our DB
  @ManyToMany
  //defines the JoinTable and the foreign key columns
  @JoinTable(name = "session_speakers",
  joinColumns = @JoinColumn(name = "session_id"),
  inverseJoinColumns = @JoinColumn(name = "speaker_id"))
  private List<Speaker> speakers;

  public List<Speaker> getSpeakers() {
    return speakers;
  }

  public void setSpeakers(List<Speaker> speakers) {
    this.speakers = speakers;
  }

  //helps with serialization and deserialization
//  which will happen when we plug in the controllers later on
  public Session() {
  }

  public Long getSession_id() {
    return session_id;
  }

  public void setSession_id(Long session_id) {
    this.session_id = session_id;
  }

  public String getSession_name() {
    return session_name;
  }

  public void setSession_name(String session_name) {
    this.session_name = session_name;
  }

  public String getSession_description() {
    return session_description;
  }

  public void setSession_description(String session_description) {
    this.session_description = session_description;
  }

  public Integer getSession_length() {
    return session_length;
  }

  public void setSession_length(Integer session_length) {
    this.session_length = session_length;
  }
}
