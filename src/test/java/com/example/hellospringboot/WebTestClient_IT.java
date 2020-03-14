package com.example.hellospringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class WebTestClient_IT {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void post() {
		String uri = "/transformedclaim/vcclaim/";
		webTestClient.post().uri(uri)
				.exchange()
				.expectStatus().isOk()
				.expectBody().json("{\"Hello\":  \"world\"}");
	}

	@Test
	public void get() {
		String uri = "/transformedclaim/vcclaimintake/";
		webTestClient.get().uri(u -> u.path(uri).queryParam("name", "Fred").build())
				.exchange()
				.expectStatus().isOk()
				.expectBody().json("{\"Hello\": \"Fred\"}");
	}

	@Test
	public void badUri() {
		String uri = "/bogus/";
		webTestClient.post().uri(uri)
				.exchange()
				.expectStatus().isNotFound();
	}
}
