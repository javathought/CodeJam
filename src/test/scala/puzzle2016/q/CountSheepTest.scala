package puzzle2016.q

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import CountSheep._

/**
  * Some test on Count Sheep
  */
@RunWith(classOf[JUnitRunner])
class CountSheepTest extends FunSuite {


  test("Count Sheep is ok") {

    println(digits(34, Set()))

    assert(countSheep(1) === 10)
    assert(countSheep(2) === 90)
    assert(countSheep(11) === 110)
    assert(countSheep(1692) === 5076)

  }

}
