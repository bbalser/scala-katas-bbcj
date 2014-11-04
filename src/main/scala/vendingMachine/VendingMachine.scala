package vendingMachine

import java.text.DecimalFormat


class VendingMachine {
  var credit: Option[Double] = None
  var coinReturn: List[String] = Nil
  var productSelected: Option[String] = None
  var priceList = Map("COLA" -> 1.00, "CHIPS" -> 0.50, "CANDY" -> 0.65)

  def display: String = productSelected match {
    case Some(x) => {
      productSelected = None
      "PRICE: " + formatDecimal(priceList(x))
    }
    case None => formatDecimal(credit).getOrElse("INSERT COIN")
  }

  def insert(coin: String): Unit = Coin.decode(coin) match {
    case Some(x) => credit = addToCredit(x.value)
    case None => coinReturn = coinReturn :+ coin
  }

  private def addToCredit(value: Double): Option[Double] = {
    credit.map(_ + value) orElse Some(value)
  }


  private def formatDecimal(decimal: Option[Double]): Option[String] = decimal.map( formatDecimal )

  private def formatDecimal(decimal: Double): String = new DecimalFormat("0.00").format(decimal)

  def selectProduct(value: String) = productSelected = Some(value)

}
