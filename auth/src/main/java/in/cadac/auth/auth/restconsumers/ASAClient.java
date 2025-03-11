package in.cadac.auth.auth.restconsumers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.cadac.auth.auth.domainobject.AuthResponse;
import in.cadac.auth.auth.domainobject.SignedAuthRequest;

@FeignClient(name = "asaservice", url = "http://localhost:9080")
public interface ASAClient {

	
	public AuthResponse callAsaService(@RequestBody SignedAuthRequest request);
}
