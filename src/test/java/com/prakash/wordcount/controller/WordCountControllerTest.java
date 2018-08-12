package com.prakash.wordcount.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = WordCountController.class, secure = false)
public class WordCountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private static String baseURL = "/counter-api/";
	private static String topURL = baseURL + "top/";
	private static String searchURL = baseURL + "search/";

	@Test
	public void testSearch() throws Exception {
		String inputJSONString = "{\"searchText\":[\"Duis\", \"Sed\", \"Donec\", \"Augue\", \"Pellentesque\", \"123\"]}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(searchURL).accept(MediaType.APPLICATION_JSON)
				.content(inputJSONString).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{\"counts\":[{\"Duis\":11},{\"Sed\":4},{\"Donec\":8},{\"Augue\":0},{\"Pellentesque\":5},{\"123\":0}]}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void testTop10() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(topURL + 10);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String actual = result.getResponse().getContentAsString();
		String expected = "vel|17\n" + "eget|17\n" + "et|14\n" + "eu|13\n" + "id|12\n" + "ac|12\n" + "sed|12\n"
				+ "metus|12\n" + "sit|12\n" + "amet|12";
		Assert.assertEquals(expected, actual);
	}

}
