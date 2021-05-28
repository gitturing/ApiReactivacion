package co.com.ccb.apirest.configuracion;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Swagger {
	
	  @Bean
	   public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2).select()
	                .apis(RequestHandlerSelectors
	                        .basePackage("co.com.ccb.apirest"))
	                .paths(PathSelectors.regex("/.*"))
	                .build().apiInfo(apiEndPointsInfo());
	    }
	  
	  private ApiInfo apiEndPointsInfo() {
	        return new ApiInfoBuilder().title("Api de registros de personas")
	                .description("Api para el control de registro de personas")
	                .contact(new Contact("Cámara de comercio de Bucaramanga", "https://www.camaradirecta.com/", "info@k4soft.com"))
	                .license("Apache 2.0")
	                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
	                .version("1.0.0")
	                .build();
	    }

}
