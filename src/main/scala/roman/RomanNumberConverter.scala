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

    @tailrec def innerConvert(romanString: String, arabicValue: Int): Int = romanString match {
      case "" => arabicValue
      case x => {
        val tuple = data.find { case (arabicValue, romanCharacter) => romanString.startsWith(romanCharacter)}.get
        innerConvert(romanString.drop(tuple._2.size), arabicValue + tuple._1)
      }
    }

    innerConvert(roman, 0)
  }


}


