import collection.immutable.{List, Map}
import java.lang.String

object PhoneNumbers extends App {
  val input = args.head
  val data: Map[Int, List[String]] = Map(
    0 -> List("0"),
    1 -> List("1"),
    2 -> List("a", "b", "c"),
    3 -> List("d", "e", "f"),
    4 -> List("g", "h", "i"),
    5 -> List("j", "k", "l"),
    6 -> List("m", "n", "o"),
    7 -> List("p", "q", "r", "s"),
    8 -> List("t", "u", "v"),
    9 -> List("w", "x", "y", "z")
  )
  getCombinations(input.substring(0, 1), input.substring(1))
    .foreach(f => Console.println(f))

  def getCombinations(current: String, remaining: String): List[String] = {
    val vals = data.apply(Integer.parseInt(current));
    if (remaining.length() == 0)
      return vals

    val subresult = getCombinations(remaining.substring(0, 1), remaining.substring(1))

    return vals
      .map(f => subresult.map(f2 => f + f2))
      .flatten
  }
}