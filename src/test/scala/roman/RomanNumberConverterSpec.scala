package roman

import org.scalatest.{FlatSpec, ShouldMatchers}
import roman.RomanNumberConverter.toRoman

class RomanNumberConverterSpec extends FlatSpec with ShouldMatchers {

  "When converting arabic to roman numerals, it" should "return I for 1" in {
    toRoman(1) should be ("I")
  }

  it should "return II for 2" in {
    toRoman(2) should be ("II")
  }

  it should "return V for 5" in {
    toRoman(5) should be ("V")
  }
  it should "return VI for 6" in {
    toRoman(6) should be ("VI")
  }

  it should "return X for 10" in {
    toRoman(10) should be ("X")
  }

  it should "return X1 for 11" in {
    toRoman(11) should be ("X1")
  }
  it should "return L for 50" in {
    toRoman(50) should be ("L")
  }

}
