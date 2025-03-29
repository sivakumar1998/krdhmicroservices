package in.cdac.asa.asaauth;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import in.cadac.auth.auth.domainobject.AuthRequest;
import in.cadac.auth.auth.domainobject.AuthResponse;
import in.cadac.auth.auth.domainobject.SignedAuthRequest;
import in.cadac.auth.auth.domainobject.signature.X509Certificate;

@RestController
public class Test {
	private static String resxml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
			+ "<AuthRes code=\"7d5540bb76c7410d805b35248718d49d\" info=\"04{01000462LDBlGYLkB6ckGdbctEIz2fXctUeWQGxOBba3I3fkMayjqavufI4EG8CeQot8dhqP,A,5da986e8159427c4c7892374c54ba3bcf4fec4020297495152f0ecd3a32c8b41,0180000008000010,2.0,20250328162254,0,0,0,0,2.5,acf49307761427f68f53f156b4e72a444885a7646047fd11cdaaed88bbbb97aa,275ee032c0b98c3264761e606dd1ab8e43b638ec15dcf51c698a4c1f7eded2d5,275ee032c0b98c3264761e606dd1ab8e43b638ec15dcf51c698a4c1f7eded2d5,23,E,100,NA,NA,NA,NA,NA,NA,NA,,NA,NA,NA,NA,NA,NA}\" ret=\"y\" ts=\"2025-03-28T16:19:24.998+05:30\" txn=\"90f573f8-bd8f-41d5-8407-6ba28b6a8836\">\n"
			+ "    <Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\">\n" + "        <SignedInfo>\n"
			+ "            <CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/>\n"
			+ "            <SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/>\n"
			+ "            <Reference URI=\"\">\n" + "                <Transforms>\n"
			+ "                    <Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/>\n"
			+ "                </Transforms>\n"
			+ "                <DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\"/>\n"
			+ "                <DigestValue>rFFltEa4UOS035a80K5v3zIpYv5Zy4PHUFEivaoNW8k=</DigestValue>\n"
			+ "            </Reference>\n" + "        </SignedInfo>\n"
			+ "        <SignatureValue>1RCV3B6FqlZgG/Q/G/ejGMEwJb6VtdVOlwVlQXunYeYPh3mWsDw3jEY2yQqyZwvrmCYCgnHFvOp3&#13;\n"
			+ "IanBaLcoWEEIz5h7RUEo5nmEij385UTjEd8wFRcil9a9uyJrPI2iQrcKXjuQiKMkca41oDs44Rys&#13;\n"
			+ "Dz0JgnsP+qg/XjZlABo06idTg5H5sL3k6+orma0WLi0u/7VNg7tqrqyH+mEX1XCtf7PT+04T0NhX&#13;\n"
			+ "ZD5LHYYr/lxaFcepNtFWE9yDb08Snq4BmA2yCzEgqMSHbWn/iV14HsOWe6JnCqELEFG5JKwazjD0&#13;\n"
			+ "3Iw9QxjIcrOAEozVIaCQIjbULzpNhUzJGpLOkw==</SignatureValue>\n" + "    </Signature>\n" + "</AuthRes>";
//	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
//		
//
//
//		XmlMapper xmlMapper=new XmlMapper();
//		xmlMapper.setDefaultPropertyInclusion(JsonInclude.Value.construct(JsonInclude.Include.NON_EMPTY, JsonInclude.Include.NON_EMPTY));
//		xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
//
//		AuthResponse res=xmlMapper.readValue(resxml, AuthResponse.class);
//		System.out.println(res.getSignature().getSignatureValue().getSignatureValue());
//	}

	@PostMapping(value = "/testres", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public String transferResponse(@RequestBody String res) {
		String modifiedxml = res.replaceAll("&#xd;", "&#13;");
		System.err.println(modifiedxml);
		return modifiedxml;
	}

	@PostMapping(value = "/testreq", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public String transferRequest(@RequestBody SignedAuthRequest req) throws JsonProcessingException {
//				.replaceAll("&#xd;", "&#13;");
		XmlMapper mapper=new XmlMapper();
		String signedxml=mapper.writeValueAsString(req);
		return signedxml.replaceAll("&#xd;", "&#13;");
		
	}
}
