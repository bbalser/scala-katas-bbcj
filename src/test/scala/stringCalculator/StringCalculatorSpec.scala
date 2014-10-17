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

  it should "handle new lines between number instead of commas" in {
    add("1\n2,3") should be (6)
  }

  it should "return 1 when given custom delimiter String '//;\n1' " in {
    add("//;\n1") should be (1)
  }

  it should "return 3 when give custom delimiter String '//;\n1;2' " in {
    add("//;\n1;2") should be (3)
  }


}
