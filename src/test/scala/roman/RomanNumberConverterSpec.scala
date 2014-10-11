package roman

import org.scalatest.{FlatSpec, ShouldMatchers}
import roman.RomanNumberConverter.toRoman
import roman.RomanNumberConverter.testFoldLeft

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



  it should "return 21 for list(1,2,3,4,5,6)" in {
    testFoldLeft(0) should be(21)
  }

}
