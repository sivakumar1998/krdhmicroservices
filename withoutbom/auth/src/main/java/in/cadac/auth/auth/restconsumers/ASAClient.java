package in.cadac.auth.auth.restconsumers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.cadac.auth.auth.domainobject.AuthResponse;
import in.cadac.auth.auth.domainobject.SignedAuthRequest;

@FeignClient(name = "asaauth")
public interface ASAClient {

	@PostMapping(value = "asa/authrequest")
	public AuthResponse callAsaService(@RequestBody SignedAuthRequest request);
}
