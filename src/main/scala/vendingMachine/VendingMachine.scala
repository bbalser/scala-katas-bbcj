package vendingMachine


class VendingMachine {
  var credit: String = ""

  def display: String =  credit match{
    case "" => "INSERT COIN"
    case "DIME" => "0.10"
    case "QUARTER" => "0.25"
    case "2 NICKELS" => "0.10"
    case "2 DIMES" => "0.20"
    case "2 QUARTERS" => "0.50"
    case _ =>  "0.05"
  }

  def insert(coin: String) = coin match{
    case "NICKEL" => credit = if (credit == "NICKEL") "2 NICKELS" else coin
    case "DIME" => credit = if (credit == "DIME") "2 DIMES" else coin
    case "QUARTER" => credit = if (credit == "QUARTER") "2 QUARTERS" else coin
    case _ => credit = coin


  }

}
