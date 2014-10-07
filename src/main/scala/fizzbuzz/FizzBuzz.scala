package fizzbuzz

object FizzBuzz {

  def fizzbuzz(numbers: List[Int]): List[String] = {
      numbers.map(convertNumber)
  }

  private def convertNumber(num: Int) : String  = num match {
    case IsFizz() => "fizz"
    case IsBuzz() => "buzz"
    case x => x.toString
  }

  object IsFizz {
    def unapply(num: Int): Boolean = num % 3 == 0
  }

  object IsBuzz {
    def unapply(num: Int): Boolean = num % 5 == 0
  }

}

