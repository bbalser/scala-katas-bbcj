package fizzbuzz

object FizzBuzz {

  def fizzbuzz(numbers: List[Int]): List[String] = {
    numbers match {
      case 3::_ => List("fizz")
      case _ => numbers.map { x => x.toString }
    }
  }

}
