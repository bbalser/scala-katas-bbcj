package vendingMachine

import org.scalatest.{FlatSpec, ShouldMatchers}
import org.scalatest.BeforeAndAfter

class VendingMachineSpec extends FlatSpec with ShouldMatchers with BeforeAndAfter {
  var machine: VendingMachine = _
  implicit var screen: TestDisplayScreen = _
  implicit var coinReturn: TestCoinReturn = _
  implicit var hopper: TestHopper = _

  before {
    screen = new TestDisplayScreen()
    coinReturn = new TestCoinReturn()
    hopper = new TestHopper()
    machine = new VendingMachine()
  }

  "When getting vending machine display, it" should "return 'INSERT COIN' when credit is 0" in {
    screen.items should be (List("INSERT COIN"))
  }

  it should "show 0.05 after inserting a nickel" in {
    machine.insert("NICKEL")
    screen.items should be (List("INSERT COIN", "0.05"))
  }

  it should "show 0.10 after inserting a dime" in {
    machine.insert("DIME")
    screen.items should be (List("INSERT COIN", "0.10"))
  }

  it should "show 0.25 after inserting a quarter" in {
    machine.insert("QUARTER")
    screen.items should be (List("INSERT COIN", "0.25"))
  }

  it should "show 0.10 after inserting two nickels" in {
    machine.insert("NICKEL")
    machine.insert("NICKEL")
    screen.items should be (List("INSERT COIN", "0.05", "0.10"))
  }

  it should "show 0.20 after inserting two dimes" in {
    machine.insert("DIME")
    machine.insert("DIME")
    screen.items should be(List("INSERT COIN", "0.10", "0.20"))
  }

  it should "show 0.50 after inserting two quarters" in {
    machine.insert("QUARTER")
    machine.insert("QUARTER")
    screen.items should be (List("INSERT COIN","0.25","0.50"))
  }

  it should "return PENNY after PENNY is inserted" in {
    machine.insert("PENNY")
    coinReturn.items should be (List("PENNY"))
    screen.items should be (List("INSERT COIN"))
  }

  it should "return PENNY after PENNY is inserted but maintain credit" in {
    machine.insert("DIME")
    machine.insert("PENNY")
    coinReturn.items should be (List("PENNY"))
    screen.items should be (List("INSERT COIN", "0.10"))
  }

  it should "return HALF-DOLLAR after HALF-DOLLAR is inserted" in {
    machine.insert("HALF-DOLLAR")
    coinReturn.items should be (List("HALF-DOLLAR"))
  }

  it should "show PRICE: 1.00 when cola is selected" in {
    machine.selectProduct("COLA")
    screen.items should be (List("INSERT COIN", "PRICE: 1.00"))
  }
  
  it should "show PRICE: 0.50 when chips is selected" in {
    machine.selectProduct("CHIPS")
    screen.items should be (List("INSERT COIN", "PRICE: 0.50"))
  }

  it should "show PRICE: 0.65 when candy is selected" in {
    machine.selectProduct("CANDY")
    screen.items should be (List("INSERT COIN", "PRICE: 0.65"))
  }

  it should "show THANK YOU when a product is selected and enough money has been inserted" in {
    machine.insert("QUARTER")
    machine.insert("QUARTER")
    machine.selectProduct("CHIPS")
    screen.items should be (List("INSERT COIN", "0.25", "0.50", "THANK YOU"))
  }

  it should "show THANK YOU when a product is selected and more than enough money has been inserted" in {
    machine.insert("QUARTER")
    machine.insert("QUARTER")
    machine.insert("DIME")
    machine.selectProduct("CHIPS")
    screen.items should be (List("INSERT COIN", "0.25", "0.50", "0.60", "THANK YOU"))
  }

  it should "contain 0 products in hopper when no items have been purchased" in {
    hopper.items should be (List())

  }

  it should "contain selected product in hopper when item has been purchased" in {
    machine.insert("QUARTER")
    machine.insert("QUARTER")
    machine.selectProduct("CHIPS")
    hopper.items should be (List("CHIPS"))

  }

  it should "return QUARTER when product is QUARTER less than deposited amount" in {
    machine.insert("QUARTER")
    machine.insert("QUARTER")
    machine.insert("QUARTER")
    machine.selectProduct("CHIPS")
    coinReturn.items should be (List("QUARTER"))
  }

  it should "return correct DIME when product is DIME less than deposited amount" in {
    machine.insert("QUARTER")
    machine.insert("QUARTER")
    machine.insert("DIME")
    machine.selectProduct("CHIPS")
    coinReturn.items should be (List("DIME"))
  }

  it should "return DIME,NICKEL when product is .15 less than deposited amount" in {
    machine.insert("QUARTER")
    machine.insert("QUARTER")
    machine.insert("QUARTER")
    machine.insert("NICKEL")
    machine.selectProduct("CANDY")
    coinReturn.items should be (List("DIME,NICKEL"))
  }

  it should "return any coins inserted when return coins is pressed" in {
    machine.insert("DIME")
    machine.insert("NICKEL")
    machine.returnCoins
    coinReturn.items should be (List("DIME,NICKEL"))
    screen.items should be (List("INSERT COIN", "0.10", "0.15", "INSERT COIN"))
  }

  it should "show SOLD OUT when product is selected and it is out of stock" in {
    machine.insert("QUARTER")
    machine.insert("QUARTER")
    machine.chipsCnt = 0
    machine.selectProduct("CHIPS")


    screen.items should be (List("INSERT COIN", "0.25", "0.25", "SOLD OUT"))
  }





}

class TestDisplayScreen extends DisplayScreen {
  var items: List[String] = Nil

  override def display(content: String): Unit = items = items :+ content

  def clear = items = Nil
}

class TestCoinReturn extends CoinReturn {
  var items: List[String] = Nil

  override def returnCoins(coin: String): Unit = items = items :+ coin

  def clear = items = Nil
}

class TestHopper extends Hopper {
  var items: List[String] = Nil

  override def add(content: String): Unit = items = items :+ content

  def clear = items = Nil
}
