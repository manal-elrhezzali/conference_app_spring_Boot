package com.manal.conferencedemospringboot.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  //injects the app version we just created into the
  //controller
  //the ${} notation tells Spring Boot and Spring to look
  //in the properties section of the app and find that
  // and inject the value into the string appVersion
  @Value("${app.version}")
  private String appVersion;

  @GetMapping
  @RequestMapping("/")
  public Map getStatus() {
    Map map = new HashMap<String, String>();
    map.put("app-version", appVersion);
    return map;
  }
}
