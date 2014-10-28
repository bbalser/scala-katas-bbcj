package stringCalculator

object StringCalculator {

  val CustomDelimiterRegex = "^//(.+)$".r

  def add(numbers: String): Int = {

    val delimiter = if (numbers.startsWith("//")) determineDelimiter((numbers.split("\n")(0))) else ","

    val cleanedNumbers = "/".r.replaceAllIn(numbers, "")
    val numberList = cleanedNumbers.replace("\n", delimiter).split(delimiter).toList.collect { case x if !x.isEmpty => x.toInt}

    numberList.filter(_ < 0) match {
      case Nil => numberList.filter(_ < 1001).sum
      case x => throw new IllegalArgumentException(s"negatives not allowed : ${x.mkString(", ")}")
    }
  }

  def determineDelimiter(numbers: String): String = numbers match {
    case CustomDelimiterRegex(x) => x

  }


}


