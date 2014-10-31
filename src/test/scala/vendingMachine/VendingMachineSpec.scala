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

  it should "show INSERT COIN when return coins is selected " in {
    machine.insert("DIME")
    machine.returnCoins
    machine.display should be ("INSERT COIN")
  }


}
