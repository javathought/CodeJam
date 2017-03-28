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

  test("isPrime is ok") {  // calculates only for odd numbers
    assert(divisor(1) === 1)
    assert(divisor(2) === 2)
    assert(divisor(3) === 3)
    assert(divisor(5) === 5)
    assert(divisor(7) === 7)
    assert(divisor(9) === 3)
    assert(divisor(11) === 11)
    assert(divisor(13) === 13)
    assert(divisor(15) === 3)
    assert(divisor(17) === 17)
    assert(divisor(19) === 19)
    assert(divisor(21) === 3)
  }


    test("Coin Jam is ok") {
      listJam(6,3)

  }



}
