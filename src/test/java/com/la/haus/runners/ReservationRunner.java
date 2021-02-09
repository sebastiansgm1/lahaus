package com.la.haus.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/reservation.feature",
    glue = {"com.la.haus.definitions"})

public class ReservationRunner {

}
