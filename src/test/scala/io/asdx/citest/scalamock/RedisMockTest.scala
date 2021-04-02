package io.asdx.citest.scalamock

import com.github.sebruck.EmbeddedRedis
import org.scalatest.funspec.AnyFunSpec

/**
 * @auther: liansheng
 * @Date: 2021/4/1 10:10
 * @Description:
 */
class RedisMockTest extends AnyFunSpec with EmbeddedRedis {

  describe("withRedis") {
    it("start redis on a random free port") {

      withRedis() {
        port =>
//          val redis = RedisClient(port = port)
      }
    }

  }

}
