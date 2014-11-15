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
      screen.display(VendingMachine.formatDecimal(credit))
    }
    case None => coinReturn.returnCoins(coin)
  }



  def selectProduct(value: String) = {
    var output = ""
    val price = VendingMachine.priceList(value)

    if (credit >= price){
      hopper.add(value)
      output =  "THANK YOU"
    }else{
      output = s"PRICE: ${VendingMachine.formatDecimal(price)}"
    }
    makeChange(price)
    screen.display(output)
  }

  def makeChange(price: Double) = {
      Coin.decodeValue(VendingMachine.formatDecimal(credit - price)) match {
        case Some(x) =>  coinReturn.returnCoins(x.name)
        case None => ""
    }
  }

}

object VendingMachine {
  val priceList = Map("COLA" -> 1.00, "CHIPS" -> 0.50, "CANDY" -> 0.65)
  def formatDecimal(decimal: Double): String = new DecimalFormat("0.00").format(decimal)

}
