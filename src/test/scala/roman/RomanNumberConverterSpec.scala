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

}
