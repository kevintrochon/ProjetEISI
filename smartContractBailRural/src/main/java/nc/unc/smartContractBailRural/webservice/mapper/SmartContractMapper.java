package nc.unc.smartContractBailRural.webservice.mapper;

import nc.unc.smartContractBailRural.entity.SmartContract;
import nc.unc.smartContractBailRural.webservice.dto.SmartContractDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SmartContractMapper {

    @Autowired
    private GpsPointMapper gpsPointMapper;

    public SmartContractDto toDto(SmartContract entity){
        return SmartContractDto.builder()
                .proprietaire(entity.getProprietaire())
                .ares(entity.getAres())
                .gpsPoint(gpsPointMapper.toDtos(entity.getGpsPoints()))
                .build();
    }

    public SmartContract toEntity(SmartContractDto dto){
        return SmartContract.builder()
                .proprietaire(dto.getProprietaire())
                .ares(dto.getAres())
                .gpsPoints(gpsPointMapper.toEntities(dto.getGpsPoint()))
                .build();
    }

    public List<SmartContractDto> toDtos(List<SmartContract> entities){
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

}
