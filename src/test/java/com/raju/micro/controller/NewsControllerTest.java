package com.raju.micro.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@WebMvcTest(NewsController.class)
@Ignore
public class NewsControllerTest {
	private MockMvc mvc;
	@InjectMocks
	private NewsController newsController;

	@Mock
	RestTemplate restTemplate;

	@Test
	public void test() {
		try {
			MockHttpServletResponse response = mvc
					.perform(get("/news/template/?apiKey=ccaf5d41cc5140c984818c344edcc14d&country=us&category=business")
							.accept(MediaType.APPLICATION_JSON))
					.andReturn().getResponse();
			assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
			assertThat(response.getContentAsString()).isEqualTo("null");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
