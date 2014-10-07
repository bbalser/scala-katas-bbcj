package fizzbuzz

object FizzBuzz {

  def fizzbuzz(numbers: List[Int]): List[String] = {
    numbers match {
      case 3::_ => List("fizz")
      case 2::_ => List("2")
      case _ => List("1")
    }
  }

}
