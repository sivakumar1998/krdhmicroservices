package in.cadac.auth.auth.domainobject.signature;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Transforms")
public class Transforms {
	@JsonProperty(value = "Transform")
private Transform transform;

	public Transform getTransform() {
		return transform;
	}

	public void setTransform(Transform transform) {
		this.transform = transform;
	}

	@Override
	public String toString() {
		return "Transforms [transform=" + transform + "]";
	}
	
}
