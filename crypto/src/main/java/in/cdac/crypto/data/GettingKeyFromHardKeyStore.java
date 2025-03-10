package in.cdac.crypto.data;

import com.safenetinc.luna.provider.LunaProvider;
import java.io.ByteArrayInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("getKeyFromHardKeyStore")
public class GettingKeyFromHardKeyStore {
  private static final Logger logger = LoggerFactory.getLogger(GettingKeyFromHardKeyStore.class);
  
//  @Cacheable(value = {"KeyStoreCache"}, key = "#slot+#certkeyname", unless = "#result.get('key') == null && #result.get('cert') == null")
  public HashMap<String, Object> getKeyFromKeyStore(String slot, String provider, String partitionpassword, String certkeyname, String certType) throws Exception {
    logger.debug("Class: GettingKeyStore : Method : getKeyFromKeyStore : slot : " + slot + " certkeyname : " + certkeyname +  " cert type :  " + certType);
    KeyStore lunaKeyStore = null;
    HashMap<String, Object> hmap = new HashMap<>();
    ByteArrayInputStream is1 = new ByteArrayInputStream(("slot:" + slot.trim()).getBytes());
    Security.addProvider((Provider)new LunaProvider());
    lunaKeyStore = KeyStore.getInstance(provider.trim());
    lunaKeyStore.load(is1, partitionpassword.toCharArray());
    Key key = lunaKeyStore.getKey(certkeyname, null);
    X509Certificate cert = (X509Certificate)lunaKeyStore.getCertificate(certkeyname);
    if (key == null && cert == null) {
      logger.info("Class: GettingKeyStore : method : getKeyFromKeyStore: Null pointer exception");
      throw new NullPointerException("Cert and key are null");
    } 
    hmap.put("key", key);
    hmap.put("cert", cert);
    return hmap;
  }
}

