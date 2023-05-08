package nc.unc.smartContractBailRural.repository.jpa;

import nc.unc.smartContractBailRural.entity.GpsPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GpsPointRepository extends JpaRepository<GpsPoint, Long> {
}
