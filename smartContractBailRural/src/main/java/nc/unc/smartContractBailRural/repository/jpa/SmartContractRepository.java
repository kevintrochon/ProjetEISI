package nc.unc.smartContractBailRural.repository.jpa;

import nc.unc.smartContractBailRural.entity.SmartContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartContractRepository extends JpaRepository<SmartContract, Long> {
    SmartContract findByProprietaire(String proprietaire);
}
