package in.cadac.auth.auth.domainobject.signature;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName ="KeyInfo" )
public class KeyInfo {

	@JsonProperty(value = "X509Data")
	private X509Data x509Data;
	
	public X509Data getX509Data() {
		return x509Data;
	}
	public void setX509Data(X509Data x509Data) {
		this.x509Data = x509Data;
	}
	@Override
	public String toString() {
		return "KeyInfo [x509Data=" + x509Data + "]";
	}
	
	
	
	
}
