package vendingMachine


class VendingMachine {
  var credit: String = ""

  def display: String =  credit match{
    case "" => "INSERT COIN"
    case _ =>  "0.05"
  }

  def insert(coin: String) = {
    credit = coin
  }



}
