package vendingMachine

import org.scalatest.{FlatSpec, ShouldMatchers}
import org.scalatest.BeforeAndAfter

class VendingMachineSpec extends FlatSpec with ShouldMatchers with BeforeAndAfter {
  var machine: VendingMachine = _

  before {
    machine = new VendingMachine()
  }

  "When getting vending machine display, it" should "return 'INSERT COIN' when credit is 0" in {
    machine.display should be ("INSERT COIN")
  }

  it should "show 0.05 after inserting a nickel" in {
    machine.insert("NICKEL")
    machine.display should be ("0.05")
  }

  it should "show 0.10 after inserting a dime" in {
    machine.insert("DIME")
    machine.display should be ("0.10")
  }

  it should "show 0.25 after inserting a quarter" in {
    machine.insert("QUARTER")
    machine.display should be ("0.25")
  }

  it should "show 0.10 after inserting two nickels" in {
    machine.insert("NICKEL")
    machine.insert("NICKEL")
    machine.display should be ("0.10")
  }

  it should "show 0.20 after inserting two dimes" in {
    machine.insert("DIME")
    machine.insert("DIME")
    machine.display should be ("0.20")
  }

  it should "show 0.50 after inserting two quarters" in {
    machine.insert("QUARTER")
    machine.insert("QUARTER")
    machine.display should be ("0.50")
  }


  it should "return PENNY after PENNY is inserted" in {
    machine.insert("PENNY")
    machine.coinReturn should be (List("PENNY"))
    machine.display should be ("INSERT COIN")
  }

  it should "return PENNY after PENNY is inserted but maintain credit" in {
    machine.insert("PENNY")
    machine.insert("DIME")
    machine.coinReturn should be (List("PENNY"))
    machine.display should be ("0.10")
  }

  it should "return HALF-DOLLAR after HALF-DOLLAR is inserted" in {
    machine.insert("HALF-DOLLAR")
    machine.coinReturn should be (List("HALF-DOLLAR"))
  }

  it should "show PRICE: 1.00 when cola is selected" in {
    machine.selectProduct("COLA")
    machine.display should be ("PRICE: 1.00")
  }
  
  it should "show PRICE: 0.50 when chips is selected" in {
    machine.selectProduct("CHIPS")
    machine.display should be ("PRICE: 0.50")
  }

  it should "show PRICE: 0.65 when candy is selected" in {
    machine.selectProduct("CANDY")
    machine.display should be ("PRICE: 0.65")
  }

  it should "show INSERT COIN when checking the display after the price has been shown and there are no coins inserted" in {
    machine.selectProduct("COLA")
    machine.display should be ("PRICE: 1.00")
    machine.display should be ("INSERT COIN")
  }

  it should "show THANK YOU when a product is selected and enough money has been inserted" in {
    machine.insert("QUARTER")
    machine.insert("QUARTER")
    machine.selectProduct("CHIPS")
    machine.display should be ("THANK YOU")
  }

  it should "show THANK YOU when a product is selected and more than enough money has been inserted" in {
    machine.insert("QUARTER")
    machine.insert("QUARTER")
    machine.insert("DIME")
    machine.selectProduct("CHIPS")
    machine.display should be ("THANK YOU")
  }

  it should "contain 0 products in hopper when no items have been purchased" in {
    machine.hopper should be (None)

  }

}
