package roman

import scala.annotation.tailrec

object RomanNumberConverter {
  val data = List( (100,"C"), (50, "L"), (10, "X"), (5, "V"),(4, "IV"), (1, "I"))

  def toRoman(arabic: Int): String = {


    data.foldLeft((arabic, "")) { case ((number, buffer), (arabicValue, romanCharacter)) =>
      (number % arabicValue, buffer + (romanCharacter * (number / arabicValue)))
    }._2

  }

  def testFoldLeft(in: Int): Int ={
    val list = List(1,2,3,4,5,6)
    list.foldLeft(in)((thisIsInOrTheResultOfThePrevIteration, thisIsAnElementFromTheList) => thisIsInOrTheResultOfThePrevIteration + thisIsAnElementFromTheList)
  }

}


