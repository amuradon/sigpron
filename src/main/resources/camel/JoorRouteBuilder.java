import org.apache.camel.builder.RouteBuilder;

public class JoorRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer:keepAlive?delay=360000&fixedRate=true&period=360000")
			.log("JOOR logged");
	}

}
