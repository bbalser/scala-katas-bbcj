package fizzbuzz

object FizzBuzz {

  def fizzbuzz(numbers: List[Int]): List[String] = {
      numbers.map(convertNumber)
  }

  private def convertNumber(num: Int) : String  = num match {
    case IsFizzBuzz() => "fizzbuzz"
    case IsFizz() => "fizz"
    case IsBuzz() => "buzz"
    case x => x.toString
  }

  //Not sure I yet understand....these are classes, how are we able to call these as we do above?
  object IsFizz {
    def unapply(num: Int): Boolean = num % 3 == 0
  }

  object IsBuzz {
    def unapply(num: Int): Boolean = num % 5 == 0
  }

  //Tried to refactor to use above code...
  object IsFizzBuzz {
    def unapply(num: Int): Boolean =  (num % 5 == 0 && num % 3 == 0)
  }

}

