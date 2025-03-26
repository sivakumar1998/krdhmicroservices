package in.cdac.asa.asaauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import in.cadac.auth.auth.domainobject.AuthResponse;
import in.cadac.auth.auth.domainobject.SignedAuthRequest;
import in.cdac.asa.asaauth.service.AuthRequestProcessor;

@RestController
@RequestMapping(value = "asa")
public class Controller {
private static String response="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
		+ "<AuthRes code=\"19ea1255a1554c56bd3a97c0a74e1466\" info=\"04{01000462LDBlGYLkB6ckGdbctEIz2fXctUeWQGxOBba3I3fkMayjqavufI4EG8CeQot8dhqP,A,5da986e8159427c4c7892374c54ba3bcf4fec4020297495152f0ecd3a32c8b41,0180000008000010,2.0,20250301154224,0,0,0,0,2.5,acf49307761427f68f53f156b4e72a444885a7646047fd11cdaaed88bbbb97aa,275ee032c0b98c3264761e606dd1ab8e43b638ec15dcf51c698a4c1f7eded2d5,275ee032c0b98c3264761e606dd1ab8e43b638ec15dcf51c698a4c1f7eded2d5,23,E,100,NA,NA,NA,NA,NA,NA,NA,,NA,NA,NA,NA,NA,NA}\" ret=\"y\" ts=\"2025-03-01T15:38:47.826+05:30\" txn=\"0e2fb6eb-d300-4be8-82a9-4868eeda7a0a\">\n"
		+ "    <Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\">\n"
		+ "        <SignedInfo>\n"
		+ "            <CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/>\n"
		+ "            <SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/>\n"
		+ "            <Reference URI=\"\">\n"
		+ "                <Transforms>\n"
		+ "                    <Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/>\n"
		+ "                </Transforms>\n"
		+ "                <DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\"/>\n"
		+ "                <DigestValue>x0fzyttVJ62ZuyDATRSzkDc/RAkE5veRbGfFVgS6o3g=</DigestValue>\n"
		+ "            </Reference>\n"
		+ "        </SignedInfo>\n"
		+ "        <SignatureValue>Smhp/CKhNZOzCJNDevFjSuBiC6DxaryxTaTcCTcyf5PTASbqEqOwDFPT76AH3s0SpsBWebiS4bt4&#13;\n"
		+ "2XyvN2wbX51mz3SFZVEI13A8FJkj2rxsanodZqCY/CIaUzNCAroCicgUqAjE0aPhzYkp+y0szg1k&#13;\n"
		+ "lnpmsprJ6i6pEl2/wh4hqUfqwv72hM3hUbxVMiYYY21yMY0iRF1KrBKVLdFktFUlT6kKm2+J4Q0K&#13;\n"
		+ "XEF5mkibb/c3sXsFD7xM2pPZe/EWij6wBhNn+/GU/jR4qPV+U4ksgQncaauVNgQLhXBKTnzZQrpw&#13;\n"
		+ "D3FldiJ+5blU2Z2tSPUnsJSL9i/vmjh0AfLqZw==</SignatureValue>\n"
		+ "    </Signature>\n"
		+ "</AuthRes>";
@Autowired
private AuthRequestProcessor requestProcessor;
@PostMapping(value="/authrequesttest")
public AuthResponse processAuthRequestTest(@RequestBody SignedAuthRequest request) throws JsonMappingException, JsonProcessingException {
	XmlMapper xml=new XmlMapper();
	AuthResponse authresponse=xml.readValue(response, AuthResponse.class);
	return authresponse;
}
@PostMapping(value="/authrequest")
public AuthResponse processAuthRequest( String request) throws JsonMappingException, JsonProcessingException {
	AuthResponse authresponse=requestProcessor.processAuthRequest(request);
	return authresponse;
}
}
