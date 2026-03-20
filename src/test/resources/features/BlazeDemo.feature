Feature: Testes de API - BlazeDemo

  @compra
  Scenario Outline: Comprar passagem aérea
    Given que acesso a API "<url>"
    When realizo uma request POST para "<endpoint_find>"
    And escolho o voo com ID "<flightId>"
    Then finalizo a compra com os dados do usuário
    Examples:
      | url                  						     | endpoint_find       | flightId |
      | https://www.blazedemo.com | /reserve.php          | 123      |