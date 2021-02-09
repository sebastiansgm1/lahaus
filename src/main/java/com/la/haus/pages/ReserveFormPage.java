package com.la.haus.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class ReserveFormPage extends GeneralPage {

  @FindBy(id = "name")
  WebElementFacade txtName;

  @FindBy(id = "identification")
  WebElementFacade txtIdentification;

  @FindBy(id = "email")
  WebElementFacade txtEmail;

  @FindBy(xpath = "//div[@aria-owns = 'country-listbox']")
  WebElementFacade btnSelectCountry;

  @FindBy(id = "phone")
  WebElementFacade txtPhone;

  @FindBy(id = "terms")
  WebElementFacade chkAceptTerms;

  @FindBy(xpath = "//button[@type='submit']")
  WebElementFacade btnSubmit;

  public void setName(String name) {
    typeInto(txtName, name);
  }

  public void setIdentification(String identification) {
    typeInto(txtIdentification, identification);
  }

  public void setEmail(String email) {
    typeInto(txtEmail, email);
  }

  public void setPhone(String phone) {
    typeInto(txtPhone, phone);
  }

  public void checkTerms() {
    chkAceptTerms.click();
  }

  public void selectCountry(String country) {
    btnSelectCountry.click();
    find(By.xpath("//ul[@id='country-listbox']//li//span[text()='" + country + "']"))
        .waitUntilVisible().click();
  }

  public void submitForm() {
    btnSubmit.click();
  }
}
