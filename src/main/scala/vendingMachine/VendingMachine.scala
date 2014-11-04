package vendingMachine

import java.text.DecimalFormat


class VendingMachine {
  var credit: Option[Double] = None
  var coinReturn: List[String] = Nil
  var productSelected = ""
  var priceList = Map("COLA" -> 1.00, "CHIPS" -> 0.50, "CANDY" -> 0.65)

  def display: String =  if (productSelected != "") "PRICE: " + formatDecimal(Option(priceList(productSelected))).get else formatDecimal(credit).getOrElse("INSERT COIN")

  def insert(coin: String): Unit = Coin.decode(coin) match {
    case Some(x) => credit = addToCredit(x.value)
    case None => coinReturn = coinReturn :+ coin
  }

  private def addToCredit(value: Double): Option[Double] = {
    credit.map(_ + value) orElse Some(value)
  }

  private def formatDecimal(decimal: Option[Double]) = decimal.map( new DecimalFormat("0.00").format )

  def selectProduct(value: String) = productSelected = value

}
