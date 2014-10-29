package vendingMachine

import org.scalatest.{FlatSpec, ShouldMatchers}
import org.scalatest.BeforeAndAfter



class VendingMachineSpec  extends FlatSpec with ShouldMatchers with BeforeAndAfter {
  var machine: VendingMachine = _

  before {
    machine = new VendingMachine()
  }

  "When getting vending machine display, it" should "return 'INSERT COIN' when credit is 0" in {

    machine.display should be ("INSERT COIN")

  }

}
