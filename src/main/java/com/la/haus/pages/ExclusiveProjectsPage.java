package com.la.haus.pages;

import org.openqa.selenium.By;

public class ExclusiveProjectsPage extends GeneralPage {

  public void openProject(String project) {
    find(
        By.xpath("//p[contains(text(), '" + project + "')]")).waitUntilVisible()
        .waitUntilClickable().click();
  }
}
