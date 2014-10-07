package fizzbuzz

import org.scalatest.{FlatSpec, ShouldMatchers}
import fizzbuzz.FizzBuzz.fizzbuzz

class FizzBuzzSpec extends FlatSpec with ShouldMatchers {

  "FizzBuzz" should "return List of 1 when given List of 1" in {
    fizzbuzz(List(1)) should be (List("1"))
  }

  it should "return List of 2 when given List of 2" in {
    fizzbuzz(List(2)) should be (List("2"))
  }

  it should "return List of fizz when given List of number divisible by 3" in {
    fizzbuzz(List(3)) should be (List("fizz"))
  }

}
