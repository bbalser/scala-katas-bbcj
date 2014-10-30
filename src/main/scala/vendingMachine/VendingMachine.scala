package vendingMachine


class VendingMachine {
  var credit: String = ""

  def display: String =  credit match{
    case "" => "INSERT COIN"
    case "DIME" => "0.10"
    case "QUARTER" => "0.25"
    case "2 NICKELS" => "0.10"
    case _ =>  "0.05"
  }

  def insert(coin: String) = {
    credit = if (credit == "NICKEL") "2 NICKELS" else coin
  }

}
