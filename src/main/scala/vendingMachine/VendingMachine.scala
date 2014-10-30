package vendingMachine

import java.text.DecimalFormat


class VendingMachine {
  var credit: Option[Double] = None

  def display: String =  credit.map( new DecimalFormat("0.00").format(_)).getOrElse("INSERT COIN")

  def insert(coin: String) = credit = Some(credit.getOrElse(0.0) + (coin match {
    case "NICKEL" => 0.05
    case "DIME" => 0.1
    case "QUARTER" => 0.25
  }))

}
