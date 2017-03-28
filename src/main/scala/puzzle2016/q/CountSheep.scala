package puzzle2016.q

import better.files.Scanner
import puzzle.Solver

import scala.annotation.tailrec

/** A: Counting Sheep
  * Qualification Round 2016 -
  */
object CountSheep extends Solver("sheep_small.txt") {


  /**
    * add digits of `cur` in Set `d`, so the set grows
    * @param cur current number to read the digits
    * @param d a Set containing already cumulated digits
    * @return s Set with new digits of cur
    */
  @tailrec
  def digits (cur: Int, d: Set[Int]): Set[Int] = {
    if (cur == 0) d else digits(cur/10, d + cur%10)
  }

  def countSheep(start: Int): Int = {

    /*
      Create an empty Set (so contains uniques) to cumulates digits in numbers until all digits are presents => size is 10
     */
    @tailrec
    def helper (s:Int, d: Set[Int], n: Int): Int = {
      val newDigits = digits(s*n, d)  // add digits of s*n in the set
      if (newDigits.size == 10) s*n else helper(s, newDigits, n+1)
    }

    helper(start, Set(), 1) // starts with an empty Set

  }


  override def solve(in: Scanner): Any = {
    val firstNumber = in.next[Int]
      if ( firstNumber == 0)
        "INSOMNIA"
      else {
        countSheep(firstNumber)
      }
    }


}
