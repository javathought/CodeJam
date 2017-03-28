package puzzle2016.a1

import better.files.Scanner
import puzzle.Solver

/** A1: Last Word
  * Round A1 2016 -
  */
object LastWord extends Solver("A1-A-large-practice.in.txt") {

  def solution(initial: String) = {
    initial.foldLeft[String]("") ((w: String,c: Char) => if (w.length == 0 || c >= w(0)) "" + c + w else w + c )
  }

  override def solve(in: Scanner) = {
    solution(in.next[String])
  }

}
