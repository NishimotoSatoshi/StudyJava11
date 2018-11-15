package jp.co.opst.nishimoto_satoshi.study_java11.java11.jep;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.Charset;

import org.junit.jupiter.api.Test;

/**
 * 321: HTTP Client (Standard).
 */
class Jep321 {

	@Test
	void test() throws Exception {
		URI requestUri = URI.create("http://www.opst.co.jp/");
		HttpRequest request = HttpRequest.newBuilder(requestUri).GET().build();
		Charset responseCharset = Charset.forName("UTF-8");
		HttpResponse<String> responce = HttpClient.newHttpClient().send(request, BodyHandlers.ofString(responseCharset));
		System.out.println(responce.body());
		assertEquals(200, responce.statusCode());
	}
}
