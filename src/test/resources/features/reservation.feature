#language: en

Feature: As a user I want to try the reservation of apartments in exclusive projects

  Background:
    Given I enter the website 'https://sobreplanos-staging.herokuapp.com/'
    And I select Meet exclusive projects in the city 'Bogotá y alrededores'

  Scenario: Test of successful submission of booking form
    Given I select an apartment with the following characteristics
      | Project     | Rooms | Floor | Type |
      | Urban Chicó | 2     | 3     | 16   |
    When I send the apartment reservation form for 72 hours
      | Name              | Identification | Email                    | Country  | Phone      |
      | Sebastian Galeano | 1157854147     | sebastiansgm41@gmail.com | Colombia | 3217996306 |
    Then the reservation form will be sent correctly

  Scenario: Code validation test for incorrect reservation
    Given I select an apartment with the following characteristics
      | Project     | Rooms | Floor | Type |
      | Urban Chicó | 1     | 5     | 08   |
    When I send the apartment reservation form for 72 hours
      | Name             | Identification | Email                    | Country  | Phone      |
      | Sebastian Molina | 1152787417     | sebastiansgm1@prueba.com | Colombia | 3217522707 |
    When I enter a random code
    Then the verification will not be performed and the wrong code message will be displayed

  Scenario: Reservation test failed due to lack of verification
    Given I select an apartment with the following characteristics
      | Project     | Rooms | Floor | Type |
      | Urban Chicó | 1     | 9     | 03   |
    When I send the apartment reservation form for 72 hours
      | Name              | Identification | Email                    | Country  | Phone      |
      | Sebastian Galeano | 1154524152     | sebastiansgm78@gmail.com | Colombia | 3212452706 |
    And return to the home page without verifying the reservation
    Then the apartment must be available to be reserved



