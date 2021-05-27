package com.quarkus.demo.rest;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/version")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
public class VersionResource {

	@Inject
	@ConfigProperty(name = "quarkus.application.version")
	private String version;

	@GET
	@PermitAll
	public Response find() {
		return Response.ok().entity("{\"version\":\"" + version + "\"}").build();
	}
}