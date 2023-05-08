package nc.unc.smartContractBailRural.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "smartcontract")
public class SmartContract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nom",nullable = false)
    private String proprietaire;

    @Column(name = "surface",nullable = false)
    private BigInteger ares;

    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = true)
    private List<GpsPoint> gpsPoints = new ArrayList<>();
}
