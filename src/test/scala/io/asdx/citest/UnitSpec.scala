package io.asdx.citest

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.{Inside, Inspectors, OptionValues}

/**
 * @auther: liansheng
 * @Date: 2021/3/31 17:11
 * @Description:
 */
abstract class UnitSpec extends AnyFunSpec with OptionValues with Inside with Inspectors{

}
