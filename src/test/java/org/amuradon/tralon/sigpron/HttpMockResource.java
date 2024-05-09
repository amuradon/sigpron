package org.amuradon.tralon.sigpron;

import java.io.IOException;
import java.util.Map;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import jakarta.inject.Inject;

public class HttpMockResource implements QuarkusTestResourceLifecycleManager {

	 
	@Override
	public Map<String, String> start() {
		return null;
	}

	@Override
	public void stop() {
	}

	@Override
	public void inject(TestInjector testInjector) {
//		testInjector.injectIntoFields(server, new TestInjector.AnnotatedAndMatchesType(Inject.class, MockWebServer.class));
	}
}
