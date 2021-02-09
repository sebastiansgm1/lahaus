package com.la.haus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProjectDetailsPage extends GeneralPage {

  public void selectNumberOfRooms(int numberRooms) {
    find(
        By.xpath(
            "//section[@id='units-info']//button[contains(text(), '" + numberRooms
                + " hab')] ")).waitUntilVisible().click();
  }

  public void selectFloor(int floor) {
    find(By.xpath(
        "//p[contains(text(), 'Piso')]/preceding-sibling::button[contains(text(), '" + floor
            + "')]")).click();
  }

  public void viewApartment(String type) {
    WebElement btnViewApartment = getDriver().findElement(By.xpath("//span[contains(text(), 'Tipo ." + type
        + "')]/preceding-sibling::div//a//span[contains(text(), 'Ver')]"));
    btnViewApartment.click();
  }

  public String isAvalibleApartment(String type) {
    return find((By.xpath("//span[contains(text(), 'Tipo ." + type
        + "')]/preceding-sibling::div//p[contains(text(),'DISPONIBLE')]"))).waitUntilVisible().getText();
  }
}
