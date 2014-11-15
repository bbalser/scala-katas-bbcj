package vendingMachine

sealed class Coin(val name: String, val value: Double)

object Coin {

  private val coins: List[Coin] = List(NICKEL, DIME, QUARTER)

  def decodeName(name: String): Option[Coin] = coins.find { coin => coin.name == name }
  def decodeValue(value: String): Option[Coin] = coins.find { coin => VendingMachine.formatDecimal(coin.value) == value }

  case object NICKEL extends Coin("NICKEL", 0.05)
  case object DIME extends Coin("DIME", 0.1)
  case object QUARTER extends Coin("QUARTER", 0.25)

}
