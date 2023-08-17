package com.socket.chatting.boot.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    /**
     * - Docket: Springfox 프레임워크의 api 들에 대한 기본 인터페이스 설정을 위한 빌더이다. 이 예제에서는 Swagger 의 기본 설정을 위한 Bean 으로 사용된다.
     * - userDefaultResponseMessages(): Swagger 에 미리 정의되어 있는 기본 응답 메시지를 사용할 지에 대한 여부를 설정하는 메서드.
     * - apiInfo(): Swagger API 문서에 대한 설명을 표기하는 메서드.
     * - select(): 선택된 api 에 대한 빌더를 초기화한다.
     * - apis(): Swagger API 문서로 만들기 API 메서드들이 작성되어 있는 패키지 (Controller 를 포함하고 있는 패키지) 의 경로를 지정해준다.
     * - paths(): 특정 Path 를 지정하여 apis() 에 지정된 경로중에서 원하는 경로의 api 만 문서화한다.
     * - build(): ApiSelectorBuilder 를 빌드한다. Docket 타입을 반환한다.
     * @return
     */

    @Bean
    public Docket api(){

        return new Docket(DocumentationType.OAS_30)
//                .securityContexts(Arrays.asList(securityContext())) //securityContext는 인증하는 방식을,
//                .securitySchemes(Arrays.asList(apiKey()))//그리고 ApiKey는 버튼을 클릭했을때 입력하는 값을 넣는 설정을 하는 것이다.
                .useDefaultResponseMessages(true) // Swagger 에서 제공해주는 기본 응답 코드 (200, 401, 403, 404) 등의 노출 여부
                .apiInfo(apiInfo()) // Swagger UI 로 노출할 정보
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.socket")) // api 스펙이 작성되어 있는 패키지 (controller)
                .paths(PathSelectors.any()) // apis 에 위치하는 API 중 특정 path 를 선택
                .build()
                .ignoredParameterTypes(Pageable.class);
    }

//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .build();
//    }
//
//    private List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
//    }
//
//    private ApiKey apiKey() {
//        return new ApiKey("Authorization", "Authorization", "header");
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("채팅")
                .description("채팅<br>"+
                        "<b>* 중요 :: 채팅>")
                .version("1.0.0")
                .build();
    }



}
