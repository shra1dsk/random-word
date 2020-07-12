package com.example.randomword;

import com.example.randomword.service.DictionaryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest
class RandomwordControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DictionaryService service;

	@Test
	public void shouldReturnRandomWord() throws Exception {
		when(service.getRandomWord()).thenReturn("xyz");
		this.mockMvc.perform(get("/dictionary/randomWord")).andExpect(status().isOk())
				.andExpect(content().string(containsString("xyz")));
	}

}
