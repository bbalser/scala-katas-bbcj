package roman

object RomanNumberConverter {

  def toRoman(arabic: Int): String = {
    var roman = ""
    var number = arabic

    if (number >= 5) {
      roman += "V"
      number -= 5
    }

    roman + ("I" * number)
  }

}
