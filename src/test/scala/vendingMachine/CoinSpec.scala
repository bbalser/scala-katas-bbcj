package vendingMachine

import org.scalatest._

class CoinSpec extends FlatSpec with ShouldMatchers {

  "A Coin" should "decode NICKEL into object worth 0.05" in {
    Coin.decode("NICKEL").get.value should be (0.05)
  }

  it should "decode DIME into object worth 0.1" in {
    Coin.decode("DIME").get.value should be (0.1)
  }

  it should "decode QUARTER into object worth 0.25" in {
    Coin.decode("QUARTER").get.value should be (0.25)
  }

  it should "decode unknown coin into None" in {
    Coin.decode("UNKNOWN") should be (None)
  }
}
