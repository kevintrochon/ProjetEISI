package nc.unc.smartContractBailRural.webservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class SmartContractDto {
    private String proprietaire;
    private BigInteger ares;
    private List<GpsPointDto> gpsPoint = new ArrayList<>();
}
