package roman

import scala.annotation.tailrec

object RomanNumberConverter {

  def toRoman(arabic: Int): String = {

    @tailrec def convertToRoman(remainder: Int, roman: String) : String = {
      if (remainder >= 5) {
        convertToRoman(remainder-5,roman + "V")
      } else {
        roman + ("I" * remainder)
      }
    }

    convertToRoman(arabic, "")
  }

}
