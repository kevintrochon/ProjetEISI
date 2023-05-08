package nc.unc.smartContractBailRural.webservice.mapper;

import nc.unc.smartContractBailRural.entity.GpsPoint;
import nc.unc.smartContractBailRural.repository.jpa.GpsPointRepository;
import nc.unc.smartContractBailRural.webservice.dto.GpsPointDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GpsPointMapper {

    @Autowired
    private GpsPointRepository gpsPointRepository;

    public GpsPointDto toDto(GpsPoint entity){
        return GpsPointDto.builder()
                .id(entity.getId())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .build();
    }

    public GpsPoint toEntity(GpsPointDto dto){
        return GpsPoint.builder()
                .id(dto.getId())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .build();
    }

    public List<GpsPointDto> toDtos(List<GpsPoint> entities){
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<GpsPoint> toEntities(List<GpsPointDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
