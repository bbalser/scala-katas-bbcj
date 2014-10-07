package fizzbuzz

object FizzBuzz {

  def fizzbuzz(numbers: List[Int]): List[String] = {
      numbers.map { x => if (x == 3)  "fizz" else x.toString }
  }

}
