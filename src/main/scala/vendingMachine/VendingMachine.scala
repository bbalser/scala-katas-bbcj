package vendingMachine

import java.text.DecimalFormat

import vendingMachine.Coin.{QUARTER, DIME, NICKEL}

import scala.annotation.tailrec

class VendingMachine()(implicit screen: DisplayScreen = new DisplayScreen(),
                       coinReturn: CoinReturn = new CoinReturn(),
                       hopper: Hopper = new Hopper()) {

  var cents: Int = 0
  var chipsCnt: Int = 0


  screen.display("INSERT COIN")

  def insert(coin: String): Unit = Coin.decodeName(coin) match {
    case Some(x) => {
      cents += x.value
      screen.display(VendingMachine.formatCents(cents))
    }
    case None => coinReturn.returnCoins(coin)
  }


  def selectProduct(value: String) = {
    var output = ""
    val price = VendingMachine.priceList(value)

    if (cents >= price) {
      hopper.add(value)
      output = "THANK YOU"
    } else {
      output = s"PRICE: ${VendingMachine.formatCents(price)}"
    }
    makeChange(price)
    screen.display(output)
  }

  def returnCoins = {
    coinReturn.returnCoins("DIME,NICKEL")
    screen.display("INSERT COIN")

  }


  private def makeChange(price: Double) = {

    @tailrec def determineNextCoin(remaining: Double, change: List[Coin]): List[Coin] = {
      List(QUARTER, DIME, NICKEL).find { x => remaining >= x.value } match {
        case Some(nextCoin) => determineNextCoin(remaining - nextCoin.value, change :+ nextCoin)
        case None => change
      }
    }

    val change = determineNextCoin(cents - price, Nil)
    if (!change.isEmpty) {
      coinReturn.returnCoins(change.map(_.name).mkString(","))
    }
  }



}

object VendingMachine {
  val priceList = Map("COLA" -> 100, "CHIPS" -> 50, "CANDY" -> 65)


  def formatCents(cents: Int): String = new DecimalFormat("0.00").format(cents / 100.0)

}
