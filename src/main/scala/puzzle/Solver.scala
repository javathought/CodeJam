package puzzle

import java.io.InputStream

import better.files._

import scala.io.Source

/**
  *
  */
abstract class Solver(name: String) extends App {
  println(s"Solving: $name")

  def solve(in: Scanner): Any

  for {
    in <- Scanner(File.resource(name).newInputStream)(Scanner.Config.default).autoClosed
    out <- File(name.replace(".txt", ".out")).newOutputStream.printWriter().autoClosed
    i <- 1 to in.next[Int]
    output = s"Case #$i: ${solve(in)}"
  } {
    println(output)
    out.println(output)
  }
}
