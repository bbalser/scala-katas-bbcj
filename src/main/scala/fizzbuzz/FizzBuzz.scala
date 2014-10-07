package fizzbuzz

object FizzBuzz {

  def fizzbuzz(numbers: List[Int]): List[String] = {
      numbers.map(convertNumber)
  }

  private def convertNumber(num: Int) : String = num match {
    case 3 => "fizz"
    case 5 => "buzz"
    case _ => num.toString
  }

}
