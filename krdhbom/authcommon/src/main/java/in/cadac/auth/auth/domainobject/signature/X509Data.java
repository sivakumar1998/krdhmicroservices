package in.cadac.auth.auth.domainobject.signature;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "X509Data")
public class X509Data implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty(value ="X509SubjectName" )
	private X509SubjectName x509SubjectName;
	@JsonProperty(value ="X509Certificate" )
	private X509Certificate x509Certificate;

	public X509SubjectName getX509SubjectName() {
		return x509SubjectName;
	}

	public void setX509SubjectName(X509SubjectName x509SubjectName) {
		this.x509SubjectName = x509SubjectName;
	}

	public X509Certificate getX509Certificate() {
		return x509Certificate;
	}

	public void setX509Certificate(X509Certificate x509Certificate) {
		this.x509Certificate = x509Certificate;
	}

	@Override
	public String toString() {
		return "X509Data [x509SubjectName=" + x509SubjectName + ", x509Certificate=" + x509Certificate + "]";
	}

	
	
}
