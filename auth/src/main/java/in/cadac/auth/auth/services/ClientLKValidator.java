package in.cadac.auth.auth.services;

import in.cadac.auth.auth.entity.ClientLicenseKey;
import in.cadac.auth.auth.repositories.ClientLKRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientLKValidator {
    @Autowired
    private  ClientLKRepository clientLKRepository;

    public ClientLicenseKey getClientLicenseKey(String clientLk) {
        return clientLKRepository.findByClientLk(clientLk);
    }

    public boolean isActive(String clientLk,String sa,ClientLicenseKey licenseKey) {

        return licenseKey.getSa().equals(sa) && licenseKey.getClient_lk().equals(clientLk) && licenseKey.isIs_active();

    }
    public boolean isLKFound(String clientLk,String sa,ClientLicenseKey licenseKey) {
        return clientLKRepository.existsByClientLkAndSa(clientLk,sa);
    }


}
