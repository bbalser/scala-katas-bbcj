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
  it should "return List of numbers when given List of numbers not divisible by 3 or 5" in {
    fizzbuzz(List(1,2)) should be (List("1","2"))
  }

  it should "return List of numbers converting 3 to fizz when given List(1,2,3,4)" in {
    fizzbuzz(List(1,2,3,4)) should be (List("1","2","fizz","4"))
  }

  it should "return List of buzz when given List of 5 " in {
    fizzbuzz(List(5)) should be (List("buzz"))
  }

  it should "return List of fizz when given List of 6" in {
    fizzbuzz(List(6)) should be (List("fizz"))
  }

  it should "return List of buzz when given List of 10" in {
    fizzbuzz(List(10)) should be (List("buzz"))
  }

  it should "return List of fizzbuzz when given List of 15" in {
    fizzbuzz(List(15)) should be (List("fizzbuzz"))
  }



}
