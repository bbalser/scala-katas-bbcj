package roman

import org.scalatest.{FlatSpec, ShouldMatchers}
import roman.RomanNumberConverter.{toArabic, toRoman}

class RomanNumberConverterSpec extends FlatSpec with ShouldMatchers {

  "When converting arabic to roman numerals, it" should "return I for 1" in {
    toRoman(1) should be("I")
  }

  it should "return II for 2" in {
    toRoman(2) should be("II")
  }

  it should "return IV for 4" in {
    toRoman(4) should be("IV")
  }

  it should "return V for 5" in {
    toRoman(5) should be("V")
  }

  it should "return VI for 6" in {
    toRoman(6) should be("VI")
  }

  it should "return IX for 9" in {
    toRoman(9) should be("IX")
  }

  it should "return X for 10" in {
    toRoman(10) should be("X")
  }

  it should "return XI for 11" in {
    toRoman(11) should be("XI")
  }

  it should "return L for 50" in {
    toRoman(50) should be("L")
  }

  it should "return LI for 51" in {
    toRoman(51) should be("LI")
  }

  it should "return C for 100" in {
    toRoman(100) should be("C")
  }

  "When converting roman to arabic, it" should "return 1 for I" in {
    toArabic("I") should be (1)
  }

  it should "return 2 for II" in {
    toArabic("II") should be (2)
  }

  it should "return 5 for V" in {
    toArabic("V") should be (5)
  }

  it should "return 4 for IV" in {
    toArabic("IV") should be (4)
  }





}
