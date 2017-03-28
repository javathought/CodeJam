package puzzle2016.q

import better.files.Scanner
import puzzle.Solver

import scala.annotation.tailrec

/** B: Pancake Revenge
  * Qualification Round 2016 -
  */
object Pancake extends Solver("B-large-practice.in.txt") {

  def switch(c: Char): Char = {
    c match {
      case '+' => '-'
      case '-' => '+'
    }
  }

  @tailrec
  def lnr(t: List[Char]): Int = {
    t match {
      case Nil => 0
      case '-' :: tail => lnr(tail)
      case '+' :: tail => 1 + ln(tail)
    }
  }

  @tailrec
  def ln(pancakes: List[Char]): Int =  {
    pancakes match {
      case Nil => 0
      case '+' :: tail => ln(tail)
      case '-' :: t => 1 + lnr(t)
    }
  }

  override def solve(in: Scanner): Int = {
    ln((in.next[String] toList) reverse)
  }

}
