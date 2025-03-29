package in.cadac.auth.auth.domainobject;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "BfdRank")
public class BfdRank implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JacksonXmlProperty(isAttribute = true, localName = "pos")
	private String pos;
	@JacksonXmlProperty(isAttribute = true, localName = "val")
	private String val;

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

}
