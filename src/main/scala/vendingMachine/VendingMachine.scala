package vendingMachine

import java.text.DecimalFormat

class VendingMachine()(implicit screen: DisplayScreen = new DisplayScreen(),
                                coinReturn: CoinReturn = new CoinReturn(),
                                hopper: Hopper = new Hopper()) {

  var credit: Double = 0

  screen.display("INSERT COIN")

  def insert(coin: String): Unit = Coin.decodeName(coin) match {
    case Some(x) => {
      credit += x.value
      screen.display(formatDecimal(credit))
    }
    case None => coinReturn.returnCoins(coin)
  }

  private def formatDecimal(decimal: Double): String = new DecimalFormat("0.00").format(decimal)

  def selectProduct(value: String) = {
    var output = ""
    val price = VendingMachine.priceList(value)

    if (credit >= price){
      hopper.add(value)
      output =  "THANK YOU"
    }else{
      output = s"PRICE: ${formatDecimal(price)}"
    }
    makeChange(price)
    screen.display(output)
  }

  def makeChange(price: Double) = {
    val coin = Coin.decodeValue(formatDecimal(credit - price))
    if(coin != None){
      coinReturn.returnCoins(coin.get.name)
    }

  }

}

object VendingMachine {
  val priceList = Map("COLA" -> 1.00, "CHIPS" -> 0.50, "CANDY" -> 0.65)
}
