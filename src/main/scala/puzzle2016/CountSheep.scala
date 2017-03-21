package puzzle2016

import java.io.{File, PrintWriter}

import scala.io.Source

/** A: Counting Sheep
  * Qualification Round 2016 -
  */
object CountSheep extends App {

  val path = new File(this.getClass.getClassLoader.getResource("sheep_small.txt").toURI).getPath
  val pathRes = new File(this.getClass.getClassLoader.getResource("sheep_large_res.txt").toURI).getPath


  /**
    * add digits of `cur` in Set `d`, so the set grows
    * @param cur current number to read the digits
    * @param d a Set containing already cumulated digits
    * @return s Set with new digits of cur
    */
  def digits (cur: Int, d: Set[Int]): Set[Int] = {
    if (cur == 0) d else digits(cur/10, d + cur%10)
  }

  def countSheep(start: Int): Int = {

    /*
      Create an empty Set (so contains uniques) to cumulates digits in numbers until all digits are presents => size is 10
     */

    def helper (s:Int, d: Set[Int], n: Int): Int = {
      val newDigits = digits(s*n, d)  // add digits of s*n in the set
      if (newDigits.size == 10) s*n else helper(s, newDigits, n+1)
    }

    helper(start, Set(), 1) // starts with an empty Set

  }

  val pw = new PrintWriter(new File("res_small.txt" ))
  var i = 0
  for (line <- Source.fromFile(path).getLines()) {
    if (i == 0) {
      println(s"$line cases")
    } else {
      if (line.toInt == 0)
        pw.write(s"Case #$i: INSOMNIA\n")
      else {
        val res = countSheep(line.toInt)
        pw.write(s"Case #$i: $res\n")
      }

    }
    i = i + 1
  }
  pw.close()

}
