import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class PostSimulation extends BaseSimulation {
  private val scn =
    scenario("Post")
      .exec(
        http("post_request")
          .post("/posts")
          .body(StringBody("""{id: '23',
              |title: 'test',
              |body: 'tst',
              |userId: 1}""".stripMargin))
      )

  setUp(scn.inject(atOnceUsers(20)).protocols(httpProtocol))
}
