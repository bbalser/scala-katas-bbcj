package roman

import scala.annotation.tailrec

object RomanNumberConverter {
  val data = List((100, "C"), (50, "L"), (10, "X"), (9, "IX"), (5, "V"), (4, "IV"), (1, "I"))

  def toRoman(arabic: Int): String = {

    data.foldLeft((arabic, "")) { case ((number, buffer), (arabicValue, romanCharacter)) =>
      (number % arabicValue, buffer + (romanCharacter * (number / arabicValue)))
    }._2

  }

  def toArabic(roman: String): Int = {
    roman.size
  }

}


