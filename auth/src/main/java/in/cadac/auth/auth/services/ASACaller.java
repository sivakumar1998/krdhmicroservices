package in.cadac.auth.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import in.cadac.auth.auth.domainobject.AuthResponse;
import in.cadac.auth.auth.domainobject.SignedAuthRequest;
import in.cadac.auth.auth.restconsumers.ASAClient;
import jakarta.validation.Valid;

@Service
public class ASACaller {
	@Autowired
	private ASAClient asaClient;

	public AuthResponse getASAResponse(String request) {
		return asaClient.callAsaService(request);

	}
	public AuthResponse getASAResponseObject(SignedAuthRequest req) {
		return asaClient.callAsaServiceObject(req);
	}
}
