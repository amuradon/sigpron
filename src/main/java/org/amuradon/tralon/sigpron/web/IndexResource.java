package org.amuradon.tralon.sigpron.web;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class IndexResource {

	@Inject
	Template index;
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public TemplateInstance get() {
		return index.data("name", "amuradon");
	}
}
