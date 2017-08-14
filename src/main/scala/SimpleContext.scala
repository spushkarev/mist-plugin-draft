import io.hydrosphere.mist.api._

object SimpleContext extends MistJob with Logging {

    def execute(numbers: List[Int], multiplier: Option[Int]): Map[String, Any] = {
      val logger = getLogger
      val multiplierValue = multiplier.getOrElse(2)
      val rdd = context.parallelize(numbers)
      logger.info(s"Hello from SimpleContext")
      val x = rdd.map(x => x * multiplierValue).collect()
      Map("result" -> x)
    }
}
