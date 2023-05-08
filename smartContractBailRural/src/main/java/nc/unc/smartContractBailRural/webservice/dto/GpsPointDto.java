package nc.unc.smartContractBailRural.webservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
public class GpsPointDto {
    private Long id;
    private BigInteger longitude;
    private BigInteger latitude;
}
