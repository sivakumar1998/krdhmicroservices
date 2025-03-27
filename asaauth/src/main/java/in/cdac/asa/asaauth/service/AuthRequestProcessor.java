package in.cdac.asa.asaauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import in.cadac.auth.auth.domainobject.AuthResponse;
import in.cadac.auth.auth.domainobject.SignedAuthRequest;

@Service
public class AuthRequestProcessor {
	@Autowired
	private Environment env;

	public AuthResponse processAuthRequest(String request) throws JsonMappingException, JsonProcessingException {
		StringBuffer url=new StringBuffer();
		XmlMapper mapper=new XmlMapper();
		SignedAuthRequest signedrequest= mapper.readValue(request, SignedAuthRequest.class);
		
		url.append(env.getProperty("uidai_auth_url")+env.getProperty("ac")+"/");
		if(signedrequest.getUid().length()==12) {
			url.append(signedrequest.getUid().charAt(0)+"/"+signedrequest.getUid().charAt(1)+"/");
		}else {
			url.append("0/0/");
		}
		url.append(env.getProperty("asa_lk"));
		RestTemplate restTemplate=new RestTemplate();
		AuthResponse response=restTemplate.postForObject(url.toString(), request, AuthResponse.class);
		return response;
	}
	
}
