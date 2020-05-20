package com.juston.justonprogrammingchallenge;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class JustonProgrammingChallengeApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@LocalServerPort
	private int port;
	

	private String createValidJson() {
		String json = "{\"address\": {\"colorKeys\": [\"B\",\"G\",\"Z\"],\"values\": [74,117,115,116,79,110]},\"meta\": {\"digits\": 33,\"processingPattern\": \"d{5}+[a-z&$§]\"}}"; 
		return json; 
	}

	@Test 
	public void invalidEndPoint_thenStatus404()  {
			
		String json = "{\"address\": {\"colorKeys\": [\"B\",\"G\",\"Z\"],\"values\": [a,117,115,116,79,110]},\"meta\": {\"digits\": 33,\"processingPattern\": \"d{5}+[a-z&$§]\"}}"; 
		 try {
			this.mockMvc.perform(post("/student")
					    .contentType(MediaType.APPLICATION_JSON)				        
					    .content(json)
				        .contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().is(404));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void validJson_thenStatus200()  {
			
		String json = createValidJson();			
		 try {
			this.mockMvc.perform(post("/api")
					    .contentType(MediaType.APPLICATION_JSON)				       
					     .content(json)
				        .contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().is(200));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void invalidJson_letterInValues_thenStatus400()  {
			
		String json = "{\"address\": {\"colorKeys\": [\"B\",\"G\",\"Z\"],\"values\": [a,117,115,116,79,110]},\"meta\": {\"digits\": 33,\"processingPattern\": \"d{5}+[a-z&$§]\"}}"; 
		 try {
			this.mockMvc.perform(post("/api")
					    .contentType(MediaType.APPLICATION_JSON)				        
					    .content(json)
				        .contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().is(400));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void invalidJson_noValueInValues_thenStatus400()  {
			
		String json = "{\"address\": {\"colorKeys\": [\"B\",\"G\",\"Z\"],\"values\": []},\"meta\": {\"digits\": 33,\"processingPattern\": \"d{5}+[a-z&$§]\"}}"; 
		 try {
			this.mockMvc.perform(post("/api")
					    .contentType(MediaType.APPLICATION_JSON)				        
					    .content(json)
				        .contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().is(500))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Must Pass Valid Format"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void invalidJson_noValueInColorKeys_thenStatus400()  {
			
		String json = "{\"address\": {\"colorKeys\": [],\"values\": []},\"meta\": {\"digits\": 33,\"processingPattern\": \"d{5}+[a-z&$§]\"}}"; 
		 try {
			this.mockMvc.perform(post("/api")
					    .contentType(MediaType.APPLICATION_JSON)				        
					    .content(json)
				        .contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().is(500))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Must Pass Valid Format"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void invalidJson_InvalidDigitException_thenStatus500()  {
			
		String json = "{\"address\": {\"colorKeys\": [\"B\",\"G\",\"Z\"],\"values\": [74,117,115,116,79,110]},\"meta\": {\"digits\": -1,\"processingPattern\": \"d{5}+[a-z&$§]\"}}"; 
		 try {
			this.mockMvc.perform(post("/api")
					    .contentType(MediaType.APPLICATION_JSON)				        
					    .content(json)
				        .contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().is(500))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Must Pass Valid Format"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void invalidJson_jsonEOFException_thenStatus400()  {
			
		String json = "{"; 
		 try {
			this.mockMvc.perform(post("/api")
					    .contentType(MediaType.APPLICATION_JSON)				        
					    .content(json)
				        .contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().is(400))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Must Pass Valid json Format"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test 
	public void invalidJson_jsonParseException_thenStatus400()  {
			
		String json = "{{}}}"; 
		 try {
			this.mockMvc.perform(post("/api")
					    .contentType(MediaType.APPLICATION_JSON)				        
					    .content(json)
				        .contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().is(400))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Must Pass Valid json Format"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void invalidJson_NullPointerException_thenStatus500()  {
			
		String json = "{}"; 
		 try {
			this.mockMvc.perform(post("/api")
					    .contentType(MediaType.APPLICATION_JSON)				        
					    .content(json)
				        .contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().is(500))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Must Pass Valid json Format"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
