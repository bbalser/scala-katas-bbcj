package roman

object RomanNumberConverter {

  def toRoman(arabic: Int): String = arabic match  {
    case 5 => "V"
    case _ => "I" * arabic

  }

}
