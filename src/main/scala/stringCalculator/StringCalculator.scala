package stringCalculator


object StringCalculator {

  def add(numbers: String): Int = {
    numbers.split(",").collect { case x if !x.isEmpty => x.toInt }.sum
  }

}


