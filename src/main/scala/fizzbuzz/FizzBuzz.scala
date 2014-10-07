package fizzbuzz

object FizzBuzz {

  def fizzbuzz(numbers: List[Int]): List[String] = {
      numbers.map(convertNumber)
  }

  private def convertNumber(num: Int) : String  = num match {
    case x if (x % 3 == 0) => "fizz"
    case x if (x % 5 == 0) => "buzz"
    case x => x.toString
  }

}

