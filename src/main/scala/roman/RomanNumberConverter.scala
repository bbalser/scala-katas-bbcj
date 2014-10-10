package roman

import scala.annotation.tailrec

object RomanNumberConverter {
  val map = Map[Int, String](50 -> "L", 10 -> "X", 5 -> "V", 1 -> "I")

  def toRoman(arabic: Int): String = {

    map.foldLeft((arabic, "")) { case ((number, romanString), (key, value)) =>
      (number % key, romanString + (value * (number / key)))
    }._2

  }

}


