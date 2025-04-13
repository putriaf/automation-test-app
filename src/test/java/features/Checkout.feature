Feature: Checkout Item

  Scenario: Successful order product
    Given User Click a product to checkout
    When User enters intended color and quantity
    And User proceed to checkout from cart
    And User complete payment
    Then User should be redirected to Payment Received Page
