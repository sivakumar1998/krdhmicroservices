package in.cadac.auth.auth.restconsumers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.cadac.auth.auth.domainobject.AuthResponse;
import in.cadac.auth.auth.domainobject.SignedAuthRequest;
import jakarta.validation.Valid;

@FeignClient(name = "asaauth")
public interface ASAClient {

	@PostMapping(value = "asa/authrequest", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public AuthResponse callAsaService(@RequestBody String request);
	@PostMapping(value="asa/authrequestObject", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public AuthResponse callAsaServiceObject(@Valid @RequestBody SignedAuthRequest req);
}
