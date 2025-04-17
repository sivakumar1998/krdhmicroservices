package in.cadac.auth.auth.error;

public class LKNotFoundException extends Exception {
    public LKNotFoundException(String clientLicenseKeyNotFound) {
        super(clientLicenseKeyNotFound);
    }
}
