package com.la.haus.definitions;

import com.la.haus.models.Apartment;
import com.la.haus.models.Reservation;
import com.la.haus.steps.ReservationStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ReservationDefinition {

  @Steps
  ReservationStep reservationStep;

  @Given("I enter the website {string}")
  public void openPage(String url) {
    reservationStep.openPage(url);
  }

  @And("I select Meet exclusive projects in the city {string}")
  public void selectExclusiveProjects(String city) {
    reservationStep.selectExclusiveProjects(city);
  }

  @Given("I select an apartment with the following characteristics")
  public void selectApartment(
      DataTable apartmentData) {
    Apartment apartment = new Apartment(apartmentData.asMaps().get(0));
    reservationStep.selectApartment(apartment);
  }

  @When("I send the apartment reservation form for 72 hours")
  public void reserveApartment(DataTable reservationData) {
    Reservation reservation = new Reservation(reservationData.asMaps().get(0));
    reservationStep.reserveApartment(reservation);
  }

  @When("I enter a random code")
  public void setRamdomCode() {
    reservationStep.setVerificationCode();
  }

  @And("return to the home page without verifying the reservation")
  public void returnHomePageAndApartment() {
    reservationStep.returnHomePageAndApartment();
  }

  @Then("the reservation form will be sent correctly")
  public void submitForm() {
    reservationStep.validateSubmitForm();
  }

  @Then("the verification will not be performed and the wrong code message will be displayed")
  public void valideErrorVerification() {
    reservationStep.validateErrorVerification();
  }

  @Then("the apartment must be available to be reserved")
  public void verificateApartmentAvailability() {
    reservationStep.verificateApartmentAvailability();
  }
}
