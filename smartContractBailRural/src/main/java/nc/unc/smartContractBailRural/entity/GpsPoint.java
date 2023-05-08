package nc.unc.smartContractBailRural.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "gpspoint")
@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class GpsPoint {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private BigInteger longitude;

    @Column
    private BigInteger latitude;

}
