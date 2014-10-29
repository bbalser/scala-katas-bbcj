package vendingMachine


class VendingMachine {
  var credit: String = ""

  def display: String =  credit match{
    case "" => "INSERT COIN"
    case "DIME" => "0.10"
    case "QUARTER" => "0.25"
    case _ =>  "0.05"
  }

  def insert(coin: String) = {
    credit = coin
  }



}
