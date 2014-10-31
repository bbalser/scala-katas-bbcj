package vendingMachine

import java.text.DecimalFormat


class VendingMachine {
  var credit: Option[Double] = None
  var coinReturn: List[String] = Nil

  def display: String =  formatDecimal(credit).getOrElse("INSERT COIN")

  def insert(coin: String): Unit = Coin.decode(coin) match {
    case Some(x) => credit = addToCredit(x.value)
    case None => coinReturn = coinReturn :+ coin
  }

  private def addToCredit(value: Double): Option[Double] = {
    credit.map(_ + value) orElse Some(value)
  }

  private def formatDecimal(decimal: Option[Double]) = decimal.map( new DecimalFormat("0.00").format )

  def selectProduct(value: String) = ???

}
