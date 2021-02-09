package com.la.haus.utilities;

import lombok.Getter;

@Getter
public enum AssertionMessages {
  ERROR_SUBMIT_FORM("Error submitting the form"),
  ERROR_VERIFICATION("Code validation failed"),
  ERROR_APARTMENT_NO_AVALIBLE("Error, the apartment is not available");;

  private String message;

  AssertionMessages(String message) {
    this.message = message;
  }
}
