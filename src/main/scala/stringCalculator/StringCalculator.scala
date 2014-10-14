package stringCalculator


object StringCalculator {

  def add(numbers: String): Int = {
    if (numbers == "") 0 else  numbers.toInt
  }

}


