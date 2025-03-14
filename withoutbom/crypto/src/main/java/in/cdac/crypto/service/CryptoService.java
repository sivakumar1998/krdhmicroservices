package in.cdac.crypto.service;

import java.io.StringReader;
import java.io.StringWriter;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import in.cdac.crypto.data.CryptoPara;
import in.cdac.crypto.data.GettingKeyFromHardKeyStore;
@Service
public class CryptoService {
	private static final Logger logger = LoggerFactory.getLogger(CryptoService.class);
	@Autowired
	private CryptoPara cryptopara;
	@Autowired
	private GettingKeyFromHardKeyStore keyStore;

	public String dosign(String xml) {
		return null;
	}

	public String signing(String xmlDocument) {
		try {
			if (cryptopara.getCertPath() == null || cryptopara.getCertAlias().isEmpty()) {
				logger.info("Cryptopara Details : slot and certkeyn name are empty ");
				throw new Exception("Either slot or certkeyname is empty");
			}
			HashMap<String, Object> hmap = keyStore.getKeyFromKeyStore(String.valueOf(cryptopara.getCertPath()),
					cryptopara.getProvider(), cryptopara.getSlotPassword(), cryptopara.getCertAlias(),
					cryptopara.getCertType());
			PrivateKey key = (PrivateKey) hmap.get("key");
			X509Certificate x509 = (X509Certificate) hmap.get("cert");
			if (key == null && x509 == null)
				synchronized (this) {
					hmap = this.keyStore.getKeyFromKeyStore(String.valueOf(cryptopara.getCertPath()),
							cryptopara.getProvider(), cryptopara.getSlotPassword(), cryptopara.getCertAlias(),
							cryptopara.getCertType());
					key = (PrivateKey) hmap.get("key");
					x509 = (X509Certificate) hmap.get("cert");
				}
			logger.info(
					"Class: SignUsingHardToken : Keys and Certificate have been fetched from function getKeyFromKeyStore()");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			Document inputDocument = dbf.newDocumentBuilder().parse(new InputSource(new StringReader(xmlDocument)));
			Document signedDocument = sign(inputDocument, true, key, x509);
			StringWriter stringWriter = new StringWriter();
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans = tf.newTransformer();
			trans.transform(new DOMSource(signedDocument), new StreamResult(stringWriter));
			String resp = stringWriter.getBuffer().toString();
			return resp;
		} catch (Exception excp) {
			logger.info("Exception in Class Name:SignUsingHardToken---MethodName:signing", excp);
			return null;
		}
	}

	private Document sign(Document xmlDoc, boolean includeKeyInfo, PrivateKey privatekey, X509Certificate x509) {
		Node node = null;
		try {
			if (System.getenv("SKIP_DIGITAL_SIGNATURE") != null)
				return xmlDoc;
			XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
			Reference ref = fac.newReference("", fac.newDigestMethod("http://www.w3.org/2000/09/xmldsig#sha1", null),
					Collections.singletonList(fac.newTransform("http://www.w3.org/2000/09/xmldsig#enveloped-signature",
							(TransformParameterSpec) null)),
					null, null);
			SignedInfo sInfo = fac.newSignedInfo(
					fac.newCanonicalizationMethod("http://www.w3.org/TR/2001/REC-xml-c14n-20010315",
							(C14NMethodParameterSpec) null),
					fac.newSignatureMethod("http://www.w3.org/2000/09/xmldsig#rsa-sha1", null),
					Collections.singletonList(ref));
			if (privatekey == null)
				throw new RuntimeException(
						"Key could not be read for digital signature. Please check value of signature alias and signature password");
			X509Certificate x509Cert = x509;
			KeyInfo kInfo = getKeyInfo(x509Cert, fac);
			DOMSignContext dsc = new DOMSignContext(privatekey, xmlDoc.getDocumentElement());
			XMLSignature signature = fac.newXMLSignature(sInfo, kInfo);
			signature.sign(dsc);
			node = dsc.getParent();
		} catch (Exception ex) {
			logger.info("Exception in signing", ex);
		}
		return node.getOwnerDocument();
	}

	

	private KeyInfo getKeyInfo(X509Certificate cert, XMLSignatureFactory fac) {
		KeyInfoFactory kif = fac.getKeyInfoFactory();
		List<Object> x509Content = new ArrayList<>();
		x509Content.add(cert.getSubjectX500Principal().getName());
		x509Content.add(cert);
		X509Data xd = kif.newX509Data(x509Content);
		return kif.newKeyInfo(Collections.singletonList(xd));
	}
}
