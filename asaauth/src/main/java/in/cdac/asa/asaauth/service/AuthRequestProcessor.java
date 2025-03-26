package in.cdac.asa.asaauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import in.cadac.auth.auth.domainobject.AuthResponse;
import in.cadac.auth.auth.domainobject.SignedAuthRequest;
import jakarta.validation.Valid;

@Service
public class AuthRequestProcessor {
	@Autowired
	private Environment env;

	public AuthResponse processAuthRequest(String requestxml) {
		StringBuffer url=new StringBuffer();
		XmlMapper xmlMappper=new XmlMapper();
		SignedAuthRequest request=null;
		try {
			
			request = validateSignedXml(xmlMappper.readValue(requestxml, SignedAuthRequest.class));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		url.append(env.getProperty("uidai_auth_url")+env.getProperty("ac")+"/");
		if(request.getUid().length()==12) {
			url.append(request.getUid().charAt(0)+"/"+request.getUid().charAt(1)+"/");
		}else {
			url.append("0/0/");
		}
		url.append(env.getProperty("asa_lk"));
//		RestTemplate restTemplate=new RestTemplate();
//		AuthResponse response=restTemplate.postForObject(url.toString(), requestxml, AuthResponse.class);
//		return response;
		return null;
	}
	public SignedAuthRequest validateSignedXml(@Valid SignedAuthRequest req) {
		return req;
	}
}
