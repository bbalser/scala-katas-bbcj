package stringCalculator

object StringCalculator {

  val CustomDelimiterRegex = "^//(.)\n.+$".r

  def add(numbers: String): Int = {

    val delimiter = determineDelimiter(numbers)

    val cleanedNumbers = "/".r.replaceAllIn(numbers, "")
    val numberList = cleanedNumbers.replace("\n", delimiter).split(delimiter).collect { case x if !x.isEmpty => x.toInt}

    numberList.find(_ < 0) match {
      case Some(x) => throw new IllegalArgumentException()
      case None => numberList.sum
    }
  }

  def determineDelimiter(numbers: String): String = numbers match {
    case CustomDelimiterRegex(x) => x
    case _ => ","
  }

}


