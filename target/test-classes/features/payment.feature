Feature : Make Payment Feature

  @payment
  Scenario Outline: Make payment for three differents client
    Given I login to app with username and password
    When I go to Make Payment screen
    And User makes payment with "<amount>" amount to this "<phone>","<name>" and "<client>"
    Then Then user should see reduced balance by "<amount>"
    Examples:
      |phone      |   name  | amount | client       |
      |5300010101 | Edip    |   25   | Greenland    |
      |5300010102 | İlhan   |   50   | Norway       |
      |5300010103 | Cemal   |   75   | Switzerland  |
