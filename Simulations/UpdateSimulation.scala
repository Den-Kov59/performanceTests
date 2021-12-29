import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class PatchSimulation extends BaseSimulation {
  private val scn =
    scenario("Patch")
      .exec(
        http("patch_request")
          .patch("/posts/23")
          .body(StringBody("{title: 'newTitle'}"))
      )

  setUp(scn.inject(atOnceUsers(20)).protocols(httpProtocol))
}
