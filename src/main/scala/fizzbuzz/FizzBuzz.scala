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

  object IsFizz {
    def unapply(num: Int): Boolean = isDivisible(num, 3)
  }

  object IsBuzz {
    def unapply(num: Int): Boolean = isDivisible(num, 5)
  }

  object IsFizzBuzz {
    def unapply(num: Int): Boolean =  isDivisible(num,15)
  }

  private def isDivisible(num: Int, mod: Int): Boolean ={
          num % mod == 0
  }

}

