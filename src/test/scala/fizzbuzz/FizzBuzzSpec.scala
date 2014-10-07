package fizzbuzz

import org.scalatest.{FlatSpec, ShouldMatchers}
import fizzbuzz.FizzBuzz.fizzbuzz

class FizzBuzzSpec extends FlatSpec with ShouldMatchers {

  "FizzBuzz" should "return List of 1 when give List of 1" in {
    fizzbuzz(List(1)) should be (List("1"))
  }

  //Please delete
  it should "have another example of test" in {
    1 should be (1)
  }

}
