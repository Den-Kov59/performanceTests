import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class GetAllSimulation extends BaseSimulation {

  private val scn = scenario("GetAllSimulation")
    .exec(
      http("request_get_all")
        .get("/posts")
    )

  setUp(scn.inject(atOnceUsers(20)).protocols(httpProtocol))
}
