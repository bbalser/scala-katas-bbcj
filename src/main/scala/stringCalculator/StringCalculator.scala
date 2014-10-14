package stringCalculator


object StringCalculator {

  def add(numbers: String): Int = {
    numbers.replace("\n", ",").split(",").collect { case x if !x.isEmpty => x.toInt }.sum
  }

}


