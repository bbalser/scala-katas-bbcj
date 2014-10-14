package stringCalculator


object StringCalculator {

  def add(numbers: String): Int = numbers match{
  case "" => 0
  case default => numbers.toInt
  }


}


