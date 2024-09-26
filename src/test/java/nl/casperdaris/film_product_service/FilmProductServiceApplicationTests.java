package nl.casperdaris.film_product_service;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.fasterxml.jackson.databind.ObjectMapper;

import nl.casperdaris.film_product_service.dto.ProductRequest;

@SpringBootTest
@Testcontainers
class FilmProductServiceApplicationTests {

	// @Rule
	// public MySQLContainer mysql = new MySQLContainer();

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void shouldCreateFilmProduct() throws Exception {
		ProductRequest productRequest = getProductRequest();
		String productRequestString = objectMapper.writeValueAsString(productRequest);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(productRequestString))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	private ProductRequest getProductRequest() {
		return ProductRequest.builder()
				.title("Test film")
				.description("Example description for the first film.")
				.price(BigDecimal.valueOf(3.99))
				.build();
	}
}
