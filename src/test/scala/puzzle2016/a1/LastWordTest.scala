package puzzle2016.a1

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import LastWord._


/**
  *
  */
@RunWith(classOf[JUnitRunner])
class LastWordTest extends FunSuite {

  test("lastword is ok") {
    assert(solution("CAB") === "CAB")
    assert(solution("JAM") === "MJA")
    assert(solution("CODE") === "OCDE")
    assert(solution("ABAAB") === "BBAAA")
    assert(solution("CABCBBABC") === "CCCABBBAB")
    assert(solution("ABCABCABC") === "CCCBAABAB")
    assert(solution("ZXCASDQWE") === "ZXCASDQWE")

  }

}
