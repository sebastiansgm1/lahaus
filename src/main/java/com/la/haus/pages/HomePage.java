package com.la.haus.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class HomePage extends GeneralPage {

  @FindBy(css = "div.lh-btn.lh-btn--sm.lh-btn--fill-tertiary")
  WebElementFacade btnKnowExclusiveProjects;

  public void openPage(String url) {
    getDriver().get(url);
  }

  public void openCityMenu(String city) {
    find(By.xpath("//ul[@class='subnav-links']//a[text()='" + city + "']")).waitUntilVisible()
        .click();
  }

  public void knowExclusiveProjects() {
    btnKnowExclusiveProjects.click();
  }
}
