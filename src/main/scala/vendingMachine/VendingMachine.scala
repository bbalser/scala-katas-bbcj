package vendingMachine

import java.text.DecimalFormat

class VendingMachine()(implicit screen: DisplayScreen) {
  var credit: Double = 0
  var coinReturn: List[String] = Nil
  var productSelected: Option[String] = None
  var priceList = Map("COLA" -> 1.00, "CHIPS" -> 0.50, "CANDY" -> 0.65)

  screen.display("INSERT COIN")

  def display: String = ???

//  def display: String = productSelected match {
//    case Some(x) => {
//      productSelected = None
//      val productCost = priceList(x)
//      if (credit.getOrElse(0.0) >= productCost) {
//        "THANK YOU"
//      } else {
//        "PRICE: " + formatDecimal(productCost)
//      }
//    }
//    case None => formatDecimal(credit).getOrElse("INSERT COIN")
//  }

  def insert(coin: String): Unit = Coin.decode(coin) match {
    case Some(x) => {
      credit += x.value
      screen.display(formatDecimal(credit))
    }
    case None => coinReturn = coinReturn :+ coin
  }

  private def formatDecimal(decimal: Option[Double]): Option[String] = decimal.map( formatDecimal )

  private def formatDecimal(decimal: Double): String = new DecimalFormat("0.00").format(decimal)

  def selectProduct(value: String) = {
    val price = priceList(value)
    if (credit >= price) {
      screen.display("THANK YOU")
    } else {
      screen.display(s"PRICE: ${formatDecimal(price)}")
    }
  }

  def hopper: Option[String] = ???

}
