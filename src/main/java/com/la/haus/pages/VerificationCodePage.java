package com.la.haus.pages;

import com.la.haus.utilities.Utils;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class VerificationCodePage extends GeneralPage {

  private static final String TXT_VERIFICATION_CODE = "//section[@id='verification_code']//section//input[$]";

  @FindBy(xpath = "//section[@id='verification_code']//h4[contains(text(),'Código de verificación')]")
  WebElementFacade lblVerificationCode;

  @FindBy(xpath = "//p[contains(text(), 'El código es incorrecto')]")
  WebElementFacade lblWrongCode;


  public boolean isLabelVerificationPresent() {
    return lblVerificationCode.waitUntilPresent().isPresent();
  }

  public boolean isLabelWrongCodePresent() {
    return lblWrongCode.waitUntilPresent().isPresent();
  }

  public void setVerficationCode() {
    int[] code = Utils.getRandomNumber(6);
    for (int i = 1; i <= 6; i++) {
      find(By.xpath(TXT_VERIFICATION_CODE.replace("$", String.valueOf(i))))
          .sendKeys(String.valueOf(code[i - 1]));
    }
  }
}
