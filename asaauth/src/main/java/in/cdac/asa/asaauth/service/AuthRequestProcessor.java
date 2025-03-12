package in.cdac.asa.asaauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.cadac.auth.auth.domainobject.AuthResponse;
import in.cadac.auth.auth.domainobject.SignedAuthRequest;

@Service
public class AuthRequestProcessor {
	@Autowired
	private Environment env;

	public AuthResponse processAuthRequest(SignedAuthRequest request) {
		StringBuffer url=new StringBuffer();
		url.append(env.getProperty("uidai_auth_url")+env.getProperty("ac")+"/");
		if(request.getUid().length()==12) {
			url.append(request.getUid().charAt(0)+"/"+request.getUid().charAt(1)+"/");
		}else {
			url.append("0/0/");
		}
		url.append(env.getProperty("asa_lk"));
		RestTemplate restTemplate=new RestTemplate();
		AuthResponse response=restTemplate.postForObject(url.toString(), request, AuthResponse.class);
		return response;
	}
}
