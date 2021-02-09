package com.la.haus.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GeneralPage extends PageObject {

  private static final String SCROLL_INSTRUCTION = "window.scrollBy(0, document.body.scrollHeight)";

  public void scrollDown() {
    JavascriptExecutor executor = (JavascriptExecutor) this.getDriver();
    executor.executeScript(
        SCROLL_INSTRUCTION, "");
  }

  public void scrollToElement(WebElement element){
    new Actions(getDriver()).moveToElement(element).perform();
  }
}
