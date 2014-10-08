package roman

import org.scalatest.{FlatSpec, ShouldMatchers}
import roman.RomanNumberConverter.toRoman

class RomanNumberConverterSpec extends FlatSpec with ShouldMatchers {

  "When converting arabic to roman numerals, it" should "return I for 1" in {
    toRoman(1) should be ("I")
  }

}
