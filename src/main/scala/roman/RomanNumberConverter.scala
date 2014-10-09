package roman

import scala.annotation.tailrec

object RomanNumberConverter {

  def toRoman(arabic: Int): String = {

    @tailrec def convertToRoman(remainder: Int, roman: String) : String = {
      if (remainder >= 50) {
        convertToRoman(remainder-50, roman + "L")
      } else if (remainder >= 10) {
        convertToRoman(remainder-10,roman + "X")
      } else if (remainder >= 5) {
        convertToRoman(remainder-5,roman + "V")
      } else {
        roman + ("I" * remainder)
      }
    }

    convertToRoman(arabic, "")
  }

}
