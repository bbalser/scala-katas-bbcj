package stringCalculator

import org.scalatest.{FlatSpec, ShouldMatchers}
import stringCalculator.StringCalculator.add


class StringCalculatorSpec extends FlatSpec with ShouldMatchers {

  "When adding strings, it" should "return 0 for empty string" in{
    add("") should be (0)
  }


}
