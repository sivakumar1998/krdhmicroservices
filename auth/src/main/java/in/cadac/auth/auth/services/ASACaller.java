package in.cadac.auth.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cadac.auth.auth.domainobject.AuthResponse;
import in.cadac.auth.auth.domainobject.SignedAuthRequest;
import in.cadac.auth.auth.restconsumers.ASAClient;

@Service
public class ASACaller {
	@Autowired
	private ASAClient asaClient;

	public AuthResponse getASAResponse(SignedAuthRequest request) {
		return asaClient.callAsaService(request);

	}
}
