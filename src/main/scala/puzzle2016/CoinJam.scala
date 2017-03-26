package puzzle2016

import better.files.Scanner
import puzzle.Solver

/** C: Coin Jam
  * Qualification Round 2016 -
  */
object CoinJam extends Solver("coinJam.txt") {

  // generate String of a Coin Jam candidate
  def leftPad(s: String, length: Int, repeat: String): String = {
    if (s.length >= length) s
    else repeat.padTo(length - s.length, repeat).mkString + s

  }

  /**
    * search for a diviser less than 1000 (limitation for performance)
    * @param candidate cadidate number to Coin Jam
    * @return a divisor less than 1000 or candidate itself if no divisor found
    */
  def divisor(candidate: BigInt): BigInt = {

    // simple algo : divide by odd numbers under 1000
    def divHelper(i: BigInt, integr: BigInt): BigInt = {
      if (integr % i == 0) i
      else if (i > mxaDivider ) integr  // limit for performance
      else divHelper(i + 2, integr)
    }

    if (candidate == 1 ) 1
    else {
      divHelper(3, candidate)
    }
  }

  /**
    * generates a coin jam response in a pair format
    * @param num the iteration a coin jam to generate
    * @param length the length of coin jam to generate
    * @return a candidate coin jam in par format : (is a coin jam, response String expected)
    */
  def jam(num: Int, length: Int): (Boolean, String) = {
    val candidate = "1" +
      leftPad(num.toBinaryString, length - 2, "0") + "1"

    val divisors = for (base <- 2 to 10) yield {
      val parsedInt =  BigInt(candidate, base)
      val div = divisor(parsedInt)
      if (div == parsedInt) (true, div) else (false, div)

    }

    val res = divisors map {case (a,b) => (a, b.toString)} reduce ((x,y) => (x._1 || y._1, x._2 + " " + y._2))
    (res._1, s"$candidate" + " " + res._2)
  }

  // generate list
  def listJam(size: Int, nb: Int): Stream[String] = {
    val stream1: Stream[Int] = {
      def loop(v: Int): Stream[Int] = v #:: loop(v + 1)
      loop(0)
    }

    stream1 map {jam(_, size)} filter (! _._1) map (_._2 + "\n") take nb
  }

  // cleaner code
  /**
    * generate the stream of coin jams
    * @param size the size of binary string
    * @param nb the number of coins jam to generate
    * @return the list of coin jams to solve the puzzle
    */
  def streamJam(size: Int, nb: Int): Stream[String] = {
    Stream.from(1) map (jam(_, size)) filter (! _._1) map {_._2 + "\n"} take nb
  }

  // Do not need to test all possible divisers
  lazy val mxaDivider = BigInt("1000", 10)

  override def solve(in: Scanner): String = {
    val size = in.next[Int]
    val nb = in.next[Int]

    "\n" + (streamJam(size,  nb) reduce(_ + _))
  }
}
