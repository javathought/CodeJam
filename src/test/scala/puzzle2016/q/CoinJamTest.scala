package puzzle2016.q

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import CoinJam._


/**
  * Created by pascalabaziou on 16/03/2017.
  */
@RunWith(classOf[JUnitRunner])
class CoinJamTest extends FunSuite {

  test("isPrime is ok") {
    assert(divisor(1) === 1)
    assert(divisor(2) === 2)
    assert(divisor(3) === 3)
    assert(divisor(4) === 2)
    assert(divisor(5) === 5)
    assert(divisor(6) === 2)
    assert(divisor(7) === 7)
  }


    test("Coin Jam is ok") {
      listJam(6,3)

  }



}
