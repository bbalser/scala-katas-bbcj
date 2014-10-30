package vendingMachine

import java.text.DecimalFormat


class VendingMachine {
  var credit: Option[Double] = None
  var coinReturn: List[String] = Nil

  def display: String =  credit.map( new DecimalFormat("0.00").format(_)).getOrElse("INSERT COIN")

  def insert(coin: String) = credit = coin match {
    case "NICKEL" => addToCredit(0.05)
    case "DIME" => addToCredit(0.1)
    case "QUARTER" => addToCredit(0.25)
    case _ => reject(coin)
  }

  def addToCredit(value: Double): Option[Double] = {
    credit match {
      case None => Some(value)
      case Some(x) => Some(x + value)
    }
  }

  def reject(coin: String) : Option[Double] = {
    coinReturn = coin :: coinReturn
    credit

  }

  def returnCoins = ???

}
