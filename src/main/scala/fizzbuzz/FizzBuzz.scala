package fizzbuzz

object FizzBuzz {

  def fizzbuzz(numbers: List[Int]): List[String] = {
      numbers.map(convertNumber)
  }

  private def convertNumber(num: Int) : String  = {
    if(num % 3 == 0) "fizz"
    else if (num % 5 == 0) "buzz"
    else num.toString
  }

}

