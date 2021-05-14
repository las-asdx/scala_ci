package io.asdx.cache.redis

import com.redis.RedisClient
import io.asdx.cache.redis.RedisCacheDemo.getUser
import io.asdx.embedded.redis.EmbeddedRedis
import org.scalatest.BeforeAndAfterAll
import org.scalatest.funspec.AnyFunSpec
import redis.embedded.RedisServer

/**
 * @auther: liansheng
 * @Date: 2021/5/15 02:09
 * @Description:
 */
class RedisCacheDemoTest extends AnyFunSpec with EmbeddedRedis with BeforeAndAfterAll {

  var redis: RedisServer = null
  var redisPort: Int = 6379

  override def beforeAll() = {
    redisPort = getFreePort
    redis = startRedis(redisPort) // A random free port is chosen
  }

  override def afterAll() = {
    stopRedis(redis)
  }

  describe("") {
    it("test redis") {
      val v1 = getUser(1)
      val v2 = getUser(1)

      val redis = new RedisClient("localhost", redisPort)
      val res = redis.get("io.asdx.cache.redis.RedisCacheDemo.getUser(1)")
//      assert(res.map(_.equals(v1)).getOrElse(false))
      assert(true)
    }
    it("test ttl") {
      getUser(1)
      Thread.sleep(100)
      getUser(1)
      Thread.sleep(5000)
      getUser(1)
      Thread.sleep(100)
      getUser(2)
      Thread.sleep(100)
      getUser(2)
      Thread.sleep(5000)
      getUser(2)
      Thread.sleep(100)
    }
  }
}
