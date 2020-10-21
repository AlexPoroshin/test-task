package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.repository.AirplaneRepository;
import com.mcb.creditfactory.service.car.CarAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AirplaneServiceImpl implements AirplaneService{
    @Autowired
    private ExternalApproveService approveService;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Override
    public boolean approve(AirplaneDto dto) {
        return approveService.approve(new AirplaneAdapter(dto)) == 0;
    }

    @Override
    public Airplane save(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public Optional<Airplane> load(Long id) {
        return airplaneRepository.findById(id);
    }

    @Override
    public Airplane fromDto(AirplaneDto dto) {
        return new Airplane(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getPower(),
                dto.getYear(),
                dto.getValue()
        );
    }

    @Override
    public AirplaneDto toDTO(Airplane airplane) {
        return new AirplaneDto(
                airplane.getId(),
                airplane.getBrand(),
                airplane.getModel(),
                airplane.getPower(),
                airplane.getYear(),
                airplane.getValue()
        );
    }

    @Override
    public Long getId(Airplane airplane) {
        return airplane.getId();
    }
}
