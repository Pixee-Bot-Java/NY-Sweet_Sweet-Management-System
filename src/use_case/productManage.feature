Feature: add delete edit and discount

  Scenario Outline: owner enters the Product page
    Given the owner in owner page
    When the owner enters the <int1>
    Then the owner enters the Product page
    Examples:
      | int1 |
      | 1    |

  Scenario Outline: owner doesn't enter the Product page
    Given the owner in owner page
    When the owner enters the <int1>
    Then the owner doesn't enter the Product page
    Examples:
      | int1 |
      | 2    |

  Scenario Outline: View Products
    Given the owner in Product page
    When the <owner> enters option to show products <option>
    Then product show
    Examples:
      |owner| option |
      |"noor"| "0"  |

  Scenario Outline: add product
    Given the owner in Product page
    When the owner <owner> enters option to add products <option>
    And set product Id=<productId> product name =<name> quantity =<quantity>  price=<price>  cost=<cost> expiration date <int1>-<int2>-<int3> discount percentage=<discount per>
    Then  the product is created successfully and a  message is displayed
    Examples:
     |owner | option | productId|name  |quantity|price|cost|int1|int2 |int3|discount per|
      |"noor"| "1"    |"103"       |"milk"|20   |10 |8 |5  |1  |2024  |10|

  Scenario Outline: failed to add product
    Given the owner in Product page
    When the owner <owner> enters option to add products <option>
    And set invalid product Id=<productId> product name =<name> quantity =<quantity>  price=<price>  cost=<cost> expiration date <int1>-<int2>-<int3> discount percentage=<discount per>
    Then   message is displayed the product is already added
    Examples:
      |owner  | option | productId|name  |quantity|price|cost|int1|int2 |int3|discount per|
      |"noor" | "1"    |"101"       |"milk"|20   |10.5 |8.5 |5  |1  |2024  |10.2|

  Scenario Outline: edit product name
    Given the owner in Product page
    When the owner <owner> enters option to edit product name <option>
    And set product Id=<productId> new product name =<name>
    Then the product name update successfully message is displayed
    Examples:
      |owner  | option |productId| name|
      |"noor"  | "2a"    |"101"   |"milk free sugar"     |

  Scenario Outline: failed to edit product name
    Given the owner in Product page
    When the owner <owner> enters option to edit product name <option>
    And set product invalid Id=<productId> new product name =<name>
    Then failed to edit the product name and message is displayed
    Examples:
      |owner    | option |productId| name|
      |"noor"   | "2a"    |"000"   |"milk free sugar"     |

  Scenario Outline: edit product quantity
    Given the owner in Product page
    When the owner <owner> enters the option to edit product quantity  <option>
    And set product Id=<productId> new product quantity =<quantity>
    Then  the product quantity update successfully and a message is displayed
    Examples:
      |owner   | option | productId|quantity|
      |"noor"    | "2b"    |"101"    |10     |

  Scenario Outline:failed to edit product quantity
    Given the owner in Product page
    When the owner <owner> enters the option to edit product quantity  <option>
    And set invalid product Id=<productId> new product quantity =<quantity>
    Then  failed to edit the product quantity  and a message is displayed
    Examples:
      |owner   | option | productId|quantity|
      |"noor"   | "2b"    |"000"    |1     |

  Scenario Outline: edit product price
    Given the owner in Product page
    When the owner <owner> enters the option to edit the product price <option>
    And set product Id=<productId> new product price =<price>
    Then  the product price update successfully and a message is displayed
    Examples:
      |owner   | option |productId| price|
      |"noor" | "2c"    |"101"   |120.2 |

  Scenario Outline: failed to edit product price
    Given the owner in Product page
    When the owner <owner> enters the option to edit the product price <option>
    And set invalid product Id=<productId> new product price =<price>
    Then  failed to edit the product price and a message is displayed
    Examples:
      |owner   | option |productId| price|
      |"noor" | "2c"    |"000"   |100.5|

  Scenario Outline: edit product expiration date
    Given the owner in Product page
    When the owner <owner> enters the option to edit product  expiration date <option>
    And set product Id=<productId> new product expiration date =<day>-<month>-<year>
    Then the product expiration date update successfully And a  message is displayed
    Examples:
      |owner   | option |productId|  day|month|year|
      |"noor"  | "2e"    |"101"   |10|10     |2024|

  Scenario Outline: failed to edit product expiration date
    Given the owner in Product page
    When the owner <owner> enters the option to edit product  expiration date <option>
    And set invalid product Id=<productId> new product expiration date =<day>-<month>-<year>
    Then failed to edit the product expiration date  And a  message is displayed
    Examples:
      |owner   | option |productId| day|month|year|
      |"noor"  | "2e"    |"000"   |10|10     |2024|

  Scenario Outline: edit product cost
    Given the owner in Product page
    When the owner <owner> enters the option to edit product cost <option>
    And set product Id=<productId> new product cost =<cost>
    Then the product cost update successfully And a  message is displayed
    Examples:
      |owner   | option |productId| cost|
      |"noor"  | "2d"    |"101"   |80.5|

  Scenario Outline: failed to edit product cost
    Given the owner in Product page
    When the owner <owner> enters the option to edit product cost <option>
    And set invalid product Id=<productId> new product cost =<cost>
    Then faild to edit the product cost  And a  message is displayed
    Examples:
      |owner   | option |productId| cost|
      |"noor"  | "2d"    |"000"   |80.5 |

  Scenario Outline: delete product
    Given the owner in Product page
    When the owner <owner> enters the option to delete product <option>
    And set product Id=<productId>
    Then the product delete successfully a  message is displayed
    Examples:
      |owner   | option | productId|
      |"noor"  |"3"    |"101"   |

  Scenario Outline:failed to delete product
    Given the owner in Product page
    When the owner <owner> enters the option to delete product <option>
    And set invalid product Id=<productId>
    Then the product delete failed a  message is displayed
    Examples:
      |owner    | option | productId|
      |"noor" |"3"    |"000"   |

  Scenario Outline: View Discount Product
    Given the owner in Product page
    When the owner <owner> enters the option to View Discount Product <option>
    Then discount product show
    Examples:
      |owner   | option |
      |"noor" | "4a"  |
  Scenario Outline: Discount rule
    Given the owner in Product page
    When the owner <owner> enters the option to set Discount rule  <option>
    And set percentage =<percentage> day before expiration=<day>
    Then the Discount rule Applied successfully and a  message is displayed
    Examples:
      |owner    | option | percentage| day|
      |"noor"| "4b"    |10    |8          |

  Scenario Outline: Exit
    Given the owner in Product page
    When the owner enters the option to exit product page  <option>
    Then go back to owner page
    Examples:
      | option |
      | "5"   |

  Scenario Outline: invalid option
    Given the owner in Product page
    When the owner enters an invalid option  <option>
    Then invalid option and  message is displayed
    Examples:
      | option |
      |"9"   |





