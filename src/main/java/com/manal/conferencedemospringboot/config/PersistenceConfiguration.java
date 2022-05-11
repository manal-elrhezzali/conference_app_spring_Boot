package com.manal.conferencedemospringboot.config;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {
  //we'll override the Data source bean provided by te data jpa starter
  //when this method returns the DataSource object Spring looks for it
  // and tries see if one already exists in the Spring context
//    if it does, it will replace its definition with the one that it found
  @Bean
  public DataSource dataSource() {
  //the body of the method is where the configuration actually happens
    DataSourceBuilder builder = DataSourceBuilder.create();
    builder.url("jdbc:postgresql://localhost:5432/conference_app");
    //added this to know to see if the bean definition gets created
    System.out.println("**********My custom datasource bean has been initialized and set**********");
    return builder.build();
  }

}
