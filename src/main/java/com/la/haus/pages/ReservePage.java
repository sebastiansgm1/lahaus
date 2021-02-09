package com.la.haus.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ReservePage extends GeneralPage {

  @FindBy(xpath = "//button[@class = 'lh-btn lh-btn--sm lh-btn--fill-secondary' and contains(text(), 'Reservar x 72 horas')]")
  WebElementFacade btnReserve;

  public void reserve() {
    btnReserve.click();
  }
}
