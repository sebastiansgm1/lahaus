package com.la.haus.models;

import java.util.Map;
import lombok.Getter;

@Getter
public class Reservation {

  private String name;
  private String identification;
  private String email;
  private String country;
  private String phone;

  public Reservation(Map<String, String> reservationData) {
    name = reservationData.get("Name");
    identification = reservationData.get("Identification");
    email = reservationData.get("Email");
    country = reservationData.get("Country");
    phone = reservationData.get("Phone");
  }
}
