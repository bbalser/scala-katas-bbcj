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

  it should "throw an exception when given -1' " in {
    an [IllegalArgumentException] should be thrownBy add("-1")
  }

  it should "throw an exception with a nice message when give -1" in {
    val exception = intercept[IllegalArgumentException] {
      add("-1")
    }
    exception.getMessage should be ("negatives not allowed : -1")
  }

  it should "throw an exception with msg containing the offending number when given -2" in {
    val exception = intercept[IllegalArgumentException] {
      add("-2")
    }
    exception.getMessage should be ("negatives not allowed : -2")
  }

  it should "throw an exception with all the negative numbers in the message when given multiple negatives" in {
    val exception = intercept[IllegalArgumentException] {
      add("-2,-3")
    }
    exception.getMessage should be ("negatives not allowed : -2, -3")
  }

//  it should "ignore numbers larger than 1000" in {
//    add("1001,2")  should be (2)
//  }
}
