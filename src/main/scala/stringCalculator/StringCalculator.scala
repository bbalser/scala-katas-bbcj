package stringCalculator


object StringCalculator {

  def add(numbers: String): Int = {
    val cleanedNumbers = ";|/".r.replaceAllIn(numbers, "")
    cleanedNumbers.replace("\n", ",").split(",").collect { case x if !x.isEmpty => x.toInt }.sum
  }

}


