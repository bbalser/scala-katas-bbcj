package roman

import scala.annotation.tailrec

object RomanNumberConverter {
  val map = Map[Int, String](50 -> "L", 10 -> "X", 5 -> "V", 1 -> "I")

  def toRoman(arabic: Int): String = {

    @tailrec def convertToRoman(remainder: Int, roman: String): String = {

      if(remainder > 0){
        val num = findLargestDivisor(remainder)
        convertToRoman(remainder - num, roman + map(num))
      }else {
        roman
      }
    }
    convertToRoman(arabic, "")

  }

  private def findLargestDivisor(remainder: Int): Int = {
    map.keySet.foreach { key =>
        if (remainder >= key) {
          return key
        }
    }
    return 0
  }

}


