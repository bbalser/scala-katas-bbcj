package stringCalculator

import com.sun.javaws.exceptions.InvalidArgumentException


object StringCalculator {

  def add(numbers: String): Int = {

    val delimiter = getCustomerDelimiter(numbers)

    val cleanedNumbers = "/".r.replaceAllIn(numbers, "")
    cleanedNumbers.replace("\n", delimiter).split(delimiter).collect { case x if !x.isEmpty => x.toInt }.sum
  }

  private def getCustomerDelimiter(numbers: String): String = numbers match {
    case IsCustom() => numbers.split("//")(1).charAt(0).toString
    case default => ","
  }

  object IsCustom {
    def unapply(numbers: String): Boolean = numbers.contains("//")
  }

}


