package br.melo;


import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class ProvaRestTest {

	@Test
	public void testCadastrarComSucesso() {
		String body = 
				"{\r\n"
				+ "  \"gabarito\": \"1a,2b,3c\",\r\n"
				+ "  \"peso\": \"2,2,6\"\r\n"
				+ "}";
		given()
			.contentType(ContentType.JSON)
			.body(body)
			.when()
			.post("/api/prova")
			.then()
			.statusCode(201);
		
	}
	
	@Test
	public void testCadastrarSemGabarito() {
		String body = 
				"{\r\n"
				+ "  \"gabarito\": \"\",\r\n"
				+ "  \"peso\": \"2,2,6\"\r\n"
				+ "}";
		given()
		.contentType(ContentType.JSON)
		.body(body)
		.when()
		.post("/api/prova")
		.then()
		.statusCode(400);
		
	}
	
	@Test
	public void testCadastrarSemPeso() {
		String body = 
				"{\r\n"
				+ "  \"gabarito\": \"1a,2b,3c\",\r\n"
				+ "  \"peso\": \"\"\r\n"
				+ "}";;
		given()
			.contentType(ContentType.JSON)
			.body(body)
			.when()
			.post("/api/prova")
			.then()
			.statusCode(400);
		
	}
	
	@Test
	public void testCadastrarPesoNaoInteiro() {
		String body = 
				"{\r\n"
				+ "  \"gabarito\": \"1a,2b,3c\",\r\n"
				+ "  \"peso\": \"2,1.5,6.5\"\r\n"
				+ "}";
		given()
			.contentType(ContentType.JSON)
			.body(body)
			.when()
			.post("/api/prova")
			.then()
			.statusCode(400);
		
	}
	
	@Test
	public void testCadastrarSomaPesoErrada() {
		String body = 
				"{\r\n"
				+ "  \"gabarito\": \"1a,2b,3c\",\r\n"
				+ "  \"peso\": \"2,2,7\"\r\n"
				+ "}";
		given()
			.contentType(ContentType.JSON)
			.body(body)
			.when()
			.post("/api/prova")
			.then()
			.statusCode(400);
		
	}
	
	@Test
	public void testCadastrarTamanhoGabaritoDiferenteTamanhoPeso() {
		String body = 
				"{\r\n"
				+ "  \"gabarito\": \"1a,2b,3c,4d\",\r\n"
				+ "  \"peso\": \"2,2,6\"\r\n"
				+ "}";
		given()
			.contentType(ContentType.JSON)
			.body(body)
			.when()
			.post("/api/prova")
			.then()
			.statusCode(400);
		
	}
	
	
}
