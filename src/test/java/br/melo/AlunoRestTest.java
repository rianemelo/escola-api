package br.melo;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class AlunoRestTest {

	@Test
	@Order(1)
	public void testACadastrarAlunoComSucessoOne() {
		String body = 
				"{\r\n"
				+ "  \"matricula\": \"10M\",\r\n"
				+ "  \"nome\": \"Bruce\"\r\n"
				+ "}";
		given()
			.contentType(ContentType.JSON)
			.body(body)
			.when()
			.post("/api/aluno")
			.then()
			.statusCode(201);	
	}
	
	@Test
	@Order(2)
	public void testBCadastrarAlunoComSucessoTwo() {
		String body = 
				"{\r\n"
				+ "  \"matricula\": \"20M\",\r\n"
				+ "  \"nome\": \"Celia\"\r\n"
				+ "}";
		given()
			.contentType(ContentType.JSON)
			.body(body)
			.when()
			.post("/api/aluno")
			.then()
			.statusCode(201);	
	}
	
	@Test
	@Order(3)
	public void testCCadastrarProva() {
		String body = 
				"{\r\n"
				+ "  \"gabarito\": \"1a,2b,3c\",\r\n"
				+ "  \"peso\": \"2,3,5\"\r\n"
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
	@Order(4)
	public void testDCadastrarRespostaOne() {
		String body = 
				"{\r\n"
				+ "  \"idProva\": 1,\r\n"
				+ "  \"matricula\": \"10M\",\r\n"
				+ "  \"solucao\": \"1a,2b,3c\"\r\n"
				+ "}";
		given()
			.contentType(ContentType.JSON)
			.body(body)
			.when()
			.post("/api/resposta")
			.then()
			.statusCode(201);	
	}

	@Test
	@Order(5)
	public void testECadastrarRespostaTwo() {
		String body = 
				"{\r\n"
				+ "  \"idProva\": 1,\r\n"
				+ "  \"matricula\": \"20M\",\r\n"
				+ "  \"solucao\": \"1a,2a,3d\"\r\n"
				+ "}";
		given()
			.contentType(ContentType.JSON)
			.body(body)
			.when()
			.post("/api/resposta")
			.then()
			.statusCode(201);	
	}
	
	
	@Test
	@Order(6)
	public void testFListarAprov() {
		given()
			.when().get("/api/aluno/aprovados")
			.then()
			.statusCode(200)
			.body(is("[{\"matricula\":\"10M\",\"media\":10.0,\"nome\":\"Bruce\"}]"));
	}
	
	@Test
	@Order(6)
	public void testGbuscarAluno() {
		given()
			.pathParam("matricula", "10M")
			.then()
			.statusCode(200)
			.body(is("{\"matricula\":\"10M\",\"media\":10.0,\"nome\":\"Bruce\"}"));
		
	}
	
	
}
