package com.manal.conferencedemospringboot.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.Type;

@Entity(name= "speakers")
public class Speaker {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long speaker_id;
  private String first_name;
  private String last_name;
  private String title;
  private String company;
  private String speaker_bio;
  //gets JPA to stream the binary data into this field
  //stands for large object, binary data can get really large
  // and this annotation helps JPA deal with large data
  @Lob
  //needed to help hibernate deal with binary data
  //Hibernate is the JPA implementation we're using
  //under the covers. Without it, we'll end up with
  // an exception when JPA queries the data and tries
  // to push it into the Session instance
  @Type(type = "org.hibernate.type.BinaryType")
  private byte[] speaker_photo;

  public byte[] getSpeaker_photo() {
    return speaker_photo;
  }

  public void setSpeaker_photo(byte[] speaker_photo) {
    this.speaker_photo = speaker_photo;
  }

  //specified that it is the other side of the specified
// many-to-many relationship
//mapped by speakers refers to the attribute
// on the Session class called speakers
  @ManyToMany(mappedBy = "speakers")
  private List<Session> sessions;

  public List<Session> getSessions() {
    return sessions;
  }

  public void setSessions(List<Session> sessions) {
    this.sessions = sessions;
  }

  public Speaker() {
  }

  public Long getSpeaker_id() {
    return speaker_id;
  }

  public void setSpeaker_id(Long speaker_id) {
    this.speaker_id = speaker_id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getSpeaker_bio() {
    return speaker_bio;
  }

  public void setSpeaker_bio(String speaker_bio) {
    this.speaker_bio = speaker_bio;
  }
}
