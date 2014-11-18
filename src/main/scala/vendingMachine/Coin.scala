package vendingMachine

sealed class Coin(val name: String, val value: Int)

object Coin {

  private val coins: List[Coin] = List(NICKEL, DIME, QUARTER)

  def decodeName(name: String): Option[Coin] = coins.find { coin => coin.name == name }
  def decodeValue(value: String): Option[Coin] = coins.find { coin => VendingMachine.formatCents(coin.value) == value }

  case object NICKEL extends Coin("NICKEL", 5)
  case object DIME extends Coin("DIME", 10)
  case object QUARTER extends Coin("QUARTER", 25)

}
