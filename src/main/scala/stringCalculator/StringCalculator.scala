package stringCalculator

object StringCalculator {

  val CustomDelimiterRegex = "^//(.)\n.+$".r

  def add(numbers: String): Int = {

    val delimiter = determineDelimiter(numbers)

    val cleanedNumbers = "/".r.replaceAllIn(numbers, "")
    cleanedNumbers.replace("\n", delimiter).split(delimiter).collect { case x if !x.isEmpty => x.toInt }.sum
  }

  def determineDelimiter(numbers: String): String = {
    numbers match {
      case CustomDelimiterRegex(x) => x
      case _ => ","
    }
  }

}


