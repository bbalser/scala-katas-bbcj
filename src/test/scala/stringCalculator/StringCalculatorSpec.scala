package stringCalculator

import org.scalatest.{FlatSpec, ShouldMatchers}
import stringCalculator.StringCalculator.add


class StringCalculatorSpec extends FlatSpec with ShouldMatchers {

  "When adding strings, it" should "return 0 for empty string" in {
    add("") should be (0)
  }

  it should "return 1 when given String 1" in {
    add("1") should be (1)
  }

  it should "return 2 when given String 1,1" in {
    add("1,1") should be (2)
  }



}
