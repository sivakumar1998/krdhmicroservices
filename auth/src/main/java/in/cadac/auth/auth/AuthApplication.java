package in.cadac.auth.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootApplication
@EnableFeignClients
public class AuthApplication {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException  {
			SpringApplication.run(AuthApplication.class, args);
		
//	        XmlMapper xmlMapper = new XmlMapper();
//	        SignedRequest auth = xmlMapper.readValue(xml, SignedRequest.class);
//
//	        System.out.println(auth);
	}

}
