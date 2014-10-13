package roman

object RomanNumberConverter {
  val data = List((100, "C"), (50, "L"), (10, "X"), (9, "IX"), (5, "V"), (4, "IV"), (1, "I"))

  def toRoman(arabic: Int): String = {

    data.foldLeft((arabic, "")) { case ((number, buffer), (arabicValue, romanCharacter)) =>
      (number % arabicValue, buffer + (romanCharacter * (number / arabicValue)))
    }._2

  }

  def toArabic(roman: String): Int = {
    var arabicResult = 0
    roman.foreach{  char =>
      data.foreach{ case (arabicValue,romanCharacter) =>
        if(romanCharacter == char.toString){
          arabicResult += arabicValue
        }
      }
    }
    arabicResult
  }

}


