package in.cadac.auth.auth.repositories;

import in.cadac.auth.auth.entity.ClientLicenseKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientLKRepository extends JpaRepository<ClientLicenseKey, Integer> {
    ClientLicenseKey findByClientLk(String clientLk);

    boolean existsByClientLkAndSa(String clientLk,String sa);


}
