package com.la.haus.steps;

import static com.la.haus.utilities.AssertionMessages.ERROR_APARTMENT_NO_AVALIBLE;
import static com.la.haus.utilities.AssertionMessages.ERROR_SUBMIT_FORM;
import static com.la.haus.utilities.AssertionMessages.ERROR_VERIFICATION;
import static org.hamcrest.Matchers.is;

import com.la.haus.models.Apartment;
import com.la.haus.models.Reservation;
import com.la.haus.pages.ExclusiveProjectsPage;
import com.la.haus.pages.HomePage;
import com.la.haus.pages.ProjectDetailsPage;
import com.la.haus.pages.ReserveFormPage;
import com.la.haus.pages.ReservePage;
import com.la.haus.pages.VerificationCodePage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class ReservationStep {

  private static final String AVALIBLE = "DISPONIBLE";

  private String url;
  private String city;
  private Apartment apartment;

  @Page
  HomePage homePage;

  @Page
  ExclusiveProjectsPage exclusiveProjectsPage;

  @Page
  ProjectDetailsPage projectDetailsPage;

  @Page
  ReservePage reservePage;

  @Page
  ReserveFormPage reserveFormPage;

  @Page
  VerificationCodePage verificationCodePage;

  @Step
  public void openPage(String url) {
    this.url = url;
    homePage.openPage(url);
  }

  @Step
  public void selectExclusiveProjects(String city) {
    this.city = city;
    homePage.openCityMenu(city);
    homePage.knowExclusiveProjects();
  }

  @Step
  public void selectApartment(Apartment apartment) {
    this.apartment = apartment;
    exclusiveProjectsPage.openProject(apartment.getProject());
    projectDetailsPage.selectNumberOfRooms(apartment.getRooms());
    projectDetailsPage.selectFloor(apartment.getFloor());
    projectDetailsPage.viewApartment(apartment.getType());
  }

  @Step
  public void reserveApartment(Reservation reservation) {
    reservePage.reserve();
    reserveFormPage.setName(reservation.getName());
    reserveFormPage.setIdentification(reservation.getIdentification());
    reserveFormPage.setEmail(reservation.getEmail());
    reserveFormPage.scrollDown();
    reserveFormPage.selectCountry(reservation.getCountry());
    reserveFormPage.setPhone(reservation.getPhone());
    reserveFormPage.checkTerms();
    reserveFormPage.submitForm();
  }

  @Step
  public void validateSubmitForm() {
    MatcherAssert.assertThat(ERROR_SUBMIT_FORM.getMessage(),
        verificationCodePage.isLabelVerificationPresent());
  }

  @Step
  public void setVerificationCode() {
    verificationCodePage.setVerficationCode();
  }

  @Step
  public void validateErrorVerification() {
    MatcherAssert.assertThat(ERROR_VERIFICATION.getMessage(),
        verificationCodePage.isLabelWrongCodePresent());
  }

  @Step
  public void returnHomePageAndApartment() {
    homePage.openPage(url);
    homePage.openCityMenu(city);
    homePage.knowExclusiveProjects();
    exclusiveProjectsPage.openProject(apartment.getProject());
    projectDetailsPage.selectNumberOfRooms(apartment.getRooms());
    projectDetailsPage.selectFloor(apartment.getFloor());

  }

  public void verificateApartmentAvailability() {
    MatcherAssert.assertThat(ERROR_APARTMENT_NO_AVALIBLE.getMessage(),
        projectDetailsPage.isAvalibleApartment(apartment.getType()), is(AVALIBLE));
  }
}
