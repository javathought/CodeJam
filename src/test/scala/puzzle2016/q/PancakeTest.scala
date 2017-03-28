package puzzle2016.q

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import Pancake._

/**
  *
  */
@RunWith(classOf[JUnitRunner])
class PancakeTest extends FunSuite {

  test("Count Pankcake Jam is ok") {
    assert( ln(("-"    toList) reverse)    === 1, "solution for '-' is KO")
    assert( ln(("-+"   toList) reverse)    === 1, "solution for '-+' is KO")
    assert( ln(("+-"   toList) reverse)    === 2, "solution for '+-' is KO")
    assert( ln(("+++"  toList) reverse)    === 0, "solution for '+++' is KO")
    assert( ln(("--+-" toList) reverse)    === 3, "solution for '--+-' is KO")
  }

}
