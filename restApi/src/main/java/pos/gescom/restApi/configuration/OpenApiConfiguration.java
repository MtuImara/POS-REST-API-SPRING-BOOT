package pos.gescom.restApi.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API POINT OF SALE", version = "0.1", description = "POINT OF SALE, DESCRIPTION DES APIs UD BACKEND", contact = @Contact(name = "TOUT-AUTRE", email = "hapanakujibu@gmail.com", url = "www.tout-autre.com")))
public class OpenApiConfiguration {

}
