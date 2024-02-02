package io.ssaragi.java.spring.boot.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * Swagger 설정 클래스
 */
@OpenAPIDefinition(
    info = @Info(
        title = "샘플 API 명세서",
        description = "샘플 API 명세서 설명",
        version = "v1"
    )
)
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI(@Value("${springdoc.version}") String springdocVersion) {
        // API 문서의 정보를 설정하는 Info 객체 생성
//        Info info = new Info()
//                .title("Sample Project")
//                .version(springdocVersion)
//                .description("This is Sample Project Description.");

        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER)
                .name("Authorization");
        SecurityRequirement securityRequirement = new SecurityRequirement().addList("bearerAuth");

        // OpenAPI 객체를 생성하고, info 객체로 API 문서의 메타데이터를 설정함
        // 현재는 비어있는 Components 객체를 설정하지만, 필요에 따라 여기에 재사용 가능한 구성요소들을 추가할 수 있음
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("bearerAuth", securityScheme))
                .security(Collections.singletonList(securityRequirement));
    }
}
