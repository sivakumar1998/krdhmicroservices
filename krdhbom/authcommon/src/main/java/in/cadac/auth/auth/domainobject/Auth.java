//package in.cadac.auth.auth.domainobject;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
//
//public class Auth {
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String rc;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String uid;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String ac;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String tid;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String ver;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String txn;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String lk;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String sa;
//
//    @JsonProperty("Uses")
//    private Uses uses;
//
//    @JsonProperty("Meta")
//    private Meta meta;
//
//    @JsonProperty("Skey")
//    private Skey skey;
//
//    @JsonProperty("Data")
//    private Data data;
//
//    @JsonProperty("Hmac")
//    private String hmac;
//
//    // Getters and setters
//}
//
//class Uses {
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String pi;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String pa;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String pfa;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String bio;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String bt;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String pin;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String otp;
//
//    // Getters and setters
//}
//
//class Meta {
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String udc;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String dpId;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String rdsId;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String rdsVer;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String dc;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String mi;
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String mc;
//
//    // Getters and setters
//}
//
//class Skey {
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String ci;
//
//    @JacksonXmlText
//    private String value;
//
//    // Getters and setters
//}
//
//class Data {
//
//    @JacksonXmlProperty(isAttribute = true)
//    private String type;
//
//    @JacksonXmlText
//    private String value;
//
//    // Getters and setters
//}
