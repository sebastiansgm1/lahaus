package com.la.haus.models;

import java.util.Map;
import lombok.Getter;

@Getter
public class Apartment {

  private String project;
  private int rooms;
  private int floor;
  private String type;

  public Apartment(Map<String, String> apartmentData) {
    project = apartmentData.get("Project");
    rooms = Integer.parseInt(apartmentData.get("Rooms"));
    floor = Integer.parseInt(apartmentData.get("Floor"));
    type = apartmentData.get("Type");
  }
}
