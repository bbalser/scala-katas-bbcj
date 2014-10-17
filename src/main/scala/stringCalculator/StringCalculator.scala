package stringCalculator


object StringCalculator {

  def add(numbers: String): Int = {

    var delimiter = ","

    if(numbers.contains("//")){
      delimiter = numbers.split("//")(1).charAt(0).toString
    }

    val cleanedNumbers = "/".r.replaceAllIn(numbers, "")
    cleanedNumbers.replace("\n", delimiter).split(delimiter).collect { case x if !x.isEmpty => x.toInt }.sum
  }



}


