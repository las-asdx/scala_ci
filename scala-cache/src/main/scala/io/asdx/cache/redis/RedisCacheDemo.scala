package io.asdx.cache.redis

import scalacache._
import scalacache.memoization.memoizeSync
import scalacache.modes.sync._
import scalacache.redis._
import scalacache.serialization.binary._

import scala.concurrent.duration.DurationInt

/**
 * @auther: liansheng
 * @Date: 2021/5/15 02:06
 * @Description:
 */
object RedisCacheDemo {

  implicit val redisCache: Cache[String] = RedisCache("localhost", 6379)

  val db = Map(1 -> "A", 2 -> "B", 3 -> "C")

  def queryDb(id: Int): String = {
    println(s"Getting id $id from db")
    db(id)
  }

  def getUser(id: Int): String = memoizeSync(None) {
    queryDb(id)
  }
}
