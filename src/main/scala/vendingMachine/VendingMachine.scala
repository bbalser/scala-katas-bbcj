package vendingMachine

import java.text.DecimalFormat

class VendingMachine()(implicit screen: DisplayScreen = new DisplayScreen(),
                                coinReturn: CoinReturn = new CoinReturn()) {

  var credit: Double = 0

  screen.display("INSERT COIN")

  def insert(coin: String): Unit = Coin.decode(coin) match {
    case Some(x) => {
      credit += x.value
      screen.display(formatDecimal(credit))
    }
    case None => coinReturn.returnCoins(coin)
  }

  private def formatDecimal(decimal: Double): String = new DecimalFormat("0.00").format(decimal)

  def selectProduct(value: String) = {
    val price = VendingMachine.priceList(value)
    val output = if (credit >= price) "THANK YOU" else s"PRICE: ${formatDecimal(price)}"
    screen.display(output)
  }

  def hopper: Option[String] = ???

}

object VendingMachine {
  val priceList = Map("COLA" -> 1.00, "CHIPS" -> 0.50, "CANDY" -> 0.65)
}
