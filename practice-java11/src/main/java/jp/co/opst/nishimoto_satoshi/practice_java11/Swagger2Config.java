package jp.co.opst.nishimoto_satoshi.practice_java11;

import java.util.Collections;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
    public Docket docket() {
		@SuppressWarnings("unchecked")
		Predicate<String> paths = Predicates.or(Predicates.containsPattern("/items"));

		var apiInfo = new ApiInfo(
				"サンプルAPI",
				"SpringBootでREST APIを作成するサンプルです。",
				"1.0.0",
				null,
				new Contact("西本　聡", null, "nishimoto.satoshi@opst.co.jp"),
				"NO LICENSE",
				null,
				Collections.emptyList());

		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("sample-api")
				.protocols(Set.of("HTTP"))
				.consumes(Set.of("application/json"))
				.produces(Set.of("application/json"))
				.select()
				.paths(paths)
				.build()
				.apiInfo(apiInfo)
				.tags(new Tag("ITEMS", "商品台帳"))	;
	}
}