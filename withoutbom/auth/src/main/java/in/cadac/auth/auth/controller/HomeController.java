package in.cadac.auth.auth.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import feign.RetryableException;
import in.cadac.auth.auth.config.Config;
import in.cadac.auth.auth.domainobject.AuthRequest;
import in.cadac.auth.auth.domainobject.AuthResponse;
import in.cadac.auth.auth.domainobject.SignedAuthRequest;
import in.cadac.auth.auth.error.CryptoException;
import in.cadac.auth.auth.error.DuplicateKeyException;
import in.cadac.auth.auth.services.AuthRequestProcessor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
public class HomeController {
	@Autowired
	private Config config;
	@Autowired
	private AuthRequestProcessor requestprocessor;
	private static String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Auth xmlns=\"http://www.uidai.gov.in/authentication/uid-auth-request/2.0\" ac=\"STGCEG0001\" lk=\"93232e9d-a1e9-45f1-bdfc-e0b44b8b55aa\" rc=\"Y\" sa=\"sastgc1002\" tid=\"\" txn=\"877b3a14-e1b1-4337-b3ce-9b8513ff456f\" uid=\"857182959021\" ver=\"2.5\"><Uses bio=\"n\" bt=\"\" otp=\"n\" pa=\"n\" pfa=\"n\" pi=\"y\" pin=\"n\"/><Meta dc=\"\" dpId=\"\" mc=\"\" mi=\"\" rdsId=\"\" rdsVer=\"\" udc=\"00-50-56-C0-00-08\"/><Skey ci=\"20250929\">Ipvq4BoOIJtPVGafyjBKA01ogYP3dRzcZPO2xQxSmbFOaNnpw9Cmmx00JjF268yBGrvDRAFRtT1KcGwBWDbzOpwuLWiwONk9Nkwzu8kAQWPe+Ej++73CWlBkr/e9yDw3hYAEYa9exPE4BohJTi1a66Csv66OFXxMF/Jk5AHR0y9EnrepeXRFllitV4hQ21DOeABnXBiZOm3UYBrR77qWvXSeM9NEtW6RI3bLlBrqqoJktimwLzK98ojZdX5H6zOYdmHwzMJE/BjqCxjsD92tQo7jTDiJSGmpDice//lY3rn2dAtAfATGq9CRbLCuFRS0bUxUZdMskEHyXb0efXoJ1g==</Skey><Data type=\"X\">MjAyNC0xMi0yMVQxNjoyNDo1Obby+6rJoci1YG0zYXw6AljKFVN1ud/1Uwa3l7IlBVTHnb2QatE0IcqFnYlmfYnT069LqGBDZUFC0Q5XGphd5HYMxuZsV4iKB/HM6EBMvZfWcMs+vxKAxBkBiN/f1O5NTFPbc74kUsxbe4R32c6z2bHl+NiTP791fGCPUoqrComsTiksvwtp37EbmyanU9uuKuluxtXzM3JcePSb8tlwdk6y1z38rG1n+XW7xl+ansol6gj9v3kP2jfhlV2nMQhN20T/CTO+FA0uHIjU6C0nJuC7KM1G+IBBXllemhwH3wrnT7Id6Ca3OFUJg1fBbQ4GrkcxM3GpIoBL</Data><Hmac>nXNCaKPrCk5pVOCTdYLnfhKOwQ4ALd1LHtq07WYtllVwKZxxUnB7Nsvdz1O1tbWg</Hmac><Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>xvnak5Mrhzfkp2VVWEWj6DtZaWY=</DigestValue></Reference></SignedInfo><SignatureValue>Y8WzF67s2ptfpb1zazZc1ci1DX7kDZAUPOQGPJvad/V9490IUMF85E1hhKDnW7QVtNXln4CxxWUa&#13;\n"
			+ "G6A1qzXuUMGhUc9tgLM/pX9vFh34doNpCj5NkWxU71l1Q6xFlkqFnUM6kHPBY56D4AyCTtfk1qFn&#13;\n"
			+ "ymBKLWaZVEuJZJa3w/8TJRHGfM6zu5dBkIjybcPM7ERKEjAn2Uwu+JVw8DqGcERuXwjyb3VXiV7m&#13;\n"
			+ "pIiT/Pmb7EFCmjjmdub5cEw17a2WSq33aaVhsI+bBi4UrPs60y3nxfk+ek3o5jzC3vhaU3VS15rW&#13;\n"
			+ "LUieXtXd9XRgQ0oEe08cecUDB2hwZ/ol3U35oA==</SignatureValue><KeyInfo><X509Data><X509SubjectName>CN=DS CENTRE FOR E GOVERNANCE 01,2.5.4.51=#0c21424d54432054544d432020324e4420464c4f4f5220205348414e54494e41474152,STREET=BANGALORE,ST=KARNATAKA,2.5.4.17=#0c06353630303237,OU=CENTRE FOR E GOVERNANCE,O=CENTRE FOR E GOVERNANCE,C=IN</X509SubjectName><X509Certificate>MIIGrTCCBZWgAwIBAgIFZIl+QYcwDQYJKoZIhvcNAQELBQAwgZMxCzAJBgNVBAYTAklOMS0wKwYD&#13;\n"
			+ "VQQKEyRDYXByaWNvcm4gSWRlbnRpdHkgU2VydmljZXMgUHZ0IEx0ZC4xHTAbBgNVBAsTFENlcnRp&#13;\n"
			+ "ZnlpbmcgQXV0aG9yaXR5MTYwNAYDVQQDEy1DYXByaWNvcm4gU3ViIENBIGZvciBEb2N1bWVudCBT&#13;\n"
			+ "aWduZXIgRFNDIDIwMjIwHhcNMjMwMzI5MTIxNDE0WhcNMjYwMzI5MTIxNDE0WjCB3jELMAkGA1UE&#13;\n"
			+ "BhMCSU4xIDAeBgNVBAoMF0NFTlRSRSBGT1IgRSBHT1ZFUk5BTkNFMSAwHgYDVQQLDBdDRU5UUkUg&#13;\n"
			+ "Rk9SIEUgR09WRVJOQU5DRTEPMA0GA1UEEQwGNTYwMDI3MRIwEAYDVQQIDAlLQVJOQVRBS0ExEjAQ&#13;\n"
			+ "BgNVBAkMCUJBTkdBTE9SRTEqMCgGA1UEMwwhQk1UQyBUVE1DICAyTkQgRkxPT1IgIFNIQU5USU5B&#13;\n"
			+ "R0FSMSYwJAYDVQQDDB1EUyBDRU5UUkUgRk9SIEUgR09WRVJOQU5DRSAwMTCCASIwDQYJKoZIhvcN&#13;\n"
			+ "AQEBBQADggEPADCCAQoCggEBAJ5G4eMUXoqPkH80FnI29qtzzZj9p7EXdefRv8QlGoOxB0I1LYxi&#13;\n"
			+ "rV5P+OL99l+JkS7Ai9Uz0vDOZpHo12PCdt2oNke/dZvgNrpL4erEy2vwt8yl2Ru4/gqNdFdtTM7t&#13;\n"
			+ "Gs7jRsB4vTGJSgBaaHmdDgvV7tALGeAp9x2wEFfAxN9kTFuNGYOSZUmrG7tBJFSzOws3xmvy7Op3&#13;\n"
			+ "Lbzg8wM7xyzwEeFnR6JzRPyP6Ak05Oftr7/sEey59pn+7mzf8ogrYCoYpDPUqjeM1A7bXocfh6/t&#13;\n"
			+ "eZ17myUl+EdGq4M4Rc62gZdW7e9F6SyhVRWZCtmWyfAWt1wFZrzEu2wevZVa1jkCAwEAAaOCArkw&#13;\n"
			+ "ggK1MDQGA1UdJQQtMCsGCCsGAQUFBwMEBggrBgEFBQcDAgYKKwYBBAGCNwoDDAYJKoZIhvcvAQEF&#13;\n"
			+ "MB8GA1UdIwQYMBaAFPJ+3f2kiz2mTEzy/e9TMxcKyn7JMIGfBggrBgEFBQcBAQSBkjCBjzArBggr&#13;\n"
			+ "BgEFBQcwAYYfaHR0cDovL29jc3AuY2VydGlmaWNhdGUuZGlnaXRhbDBgBggrBgEFBQcwAoZUaHR0&#13;\n"
			+ "cDovL3d3dy5jZXJ0aWZpY2F0ZS5kaWdpdGFsL3JlcG9zaXRvcnkvQ2Fwcmljb3JuU3ViQ0Fmb3JE&#13;\n"
			+ "b2N1bWVudFNpZ25lckRTQzIwMjIuY2VyMIH3BgNVHSAEge8wgewwVgYGYIJkZAIDMEwwSgYIKwYB&#13;\n"
			+ "BQUHAgIwPho8Q2xhc3MgMyBDZXJ0aWZpY2F0ZSBpc3N1ZWQgYnkgQ2Fwcmljb3JuIENlcnRpZnlp&#13;\n"
			+ "bmcgQXV0aG9yaXR5MEQGBmCCZGQKATA6MDgGCCsGAQUFBwICMCwaKk9yZ2FuaXphdGlvbmFsIERv&#13;\n"
			+ "Y3VtZW50IFNpZ25lciBDZXJ0aWZpY2F0ZTBMBgdggmRkAQoCMEEwPwYIKwYBBQUHAgEWM2h0dHA6&#13;\n"
			+ "Ly93d3cuY2VydGlmaWNhdGUuZGlnaXRhbC9yZXBvc2l0b3J5L2Nwc3YxLnBkZjBeBgNVHR8EVzBV&#13;\n"
			+ "MFOgUaBPhk1odHRwOi8vd3d3LmNlcnRpZmljYXRlLmRpZ2l0YWwvY3JsL0NhcHJpY29yblN1YkNB&#13;\n"
			+ "Zm9yRG9jdW1lbnRTaWduZXJEU0MyMDIyLmNybDAdBgNVHQ4EFgQUmnQWrqy5BJlqMXRGhftG6dLu&#13;\n"
			+ "rb8wIwYDVR0RBBwwGoEYcGQua3JkaEBrYXJuYXRha2EuZ292LmluMAwGA1UdEwEB/wQCMAAwDgYD&#13;\n"
			+ "VR0PAQH/BAQDAgbAMA0GCSqGSIb3DQEBCwUAA4IBAQAoIXKXg64mz6STlPmtsWvHnv8HRuP6KuTK&#13;\n"
			+ "PUQsvlW5lY4n1c1Nmnk50hz4OlVp0G7lumjNCq8kfmGy158Y2WBU6THttFtWsvN+uzHQNcQDdJ4b&#13;\n"
			+ "BVOW16V2cGLOMIc3iaXo64bY9OlN3OfsTcRNdRESt/SL0EKvdqkvZgNIvWCjU2IsWy+LcYDOHWfW&#13;\n"
			+ "4GD+vdOO44ooq7SRgkEq1vVQdOAWWLPXQedVPn4Zb5MN1gRuKintJ7kIzm8YNx55qTCeHSR4qDBM&#13;\n"
			+ "7IZmc/UOhB1b71ln+EAe2H02wW0s4qyDBFvBjj27oekCQrSvvNCA+KV8cEBqkF1fbLdTEt+4qWxL&#13;\n"
			+ "d93j</X509Certificate></X509Data></KeyInfo></Signature></Auth>";

	private Logger logger = LoggerFactory.getLogger(HomeController.class);

	@PostMapping(value = "/authrequest", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public AuthResponse authRequest(@Valid @RequestBody AuthRequest auth, HttpServletRequest request)
			throws JsonMappingException, JsonProcessingException, CryptoException, RetryableException, DuplicateKeyException {
		String clientIP = getClientIp(request);
		AuthResponse response=requestprocessor.processRequest(auth,clientIP);
		return response;
		
	}

//	@GetMapping(value = "/test",produces = MediaType.APPLICATION_XML_VALUE)
	public SignedAuthRequest test() throws JsonMappingException, JsonProcessingException {
		XmlMapper mapper = new XmlMapper();
		SignedAuthRequest sr = mapper.readValue(xml, SignedAuthRequest.class);
		return sr;
	}

	@GetMapping(value = "/test")
	public String testulr() {
		return config.getCryptoUrl();
	}
	private String getClientIp(HttpServletRequest request) {
		String remoteAddr = "";
		try {
			remoteAddr = request.getRemoteAddr();
		} catch (Exception excp) {
			logger.info("Error in fetching ip details");
		}
		return remoteAddr;
	}
	@PostMapping(value="/testres",produces =MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE )
	public AuthResponse testResponseMapping(@RequestBody AuthResponse resp) {
		System.err.println(resp.getTs());
		return resp;
	}
}
