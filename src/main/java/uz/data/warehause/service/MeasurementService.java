package uz.data.warehause.service;

import org.springframework.stereotype.Service;
import uz.data.warehause.entity.Measurement;
import uz.data.warehause.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;
@Service
public class MeasurementService {
    final MeasurementRepository measurementRepository;

    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public List<Measurement> getAllMeasurement(){
        return measurementRepository.findAll();
    }

    public Measurement getMeasurementById(Integer id){
        Optional<Measurement> byId = measurementRepository.findById(id);
        return byId.orElse(null);
    }

    public Result createMeasurment(Measurement dto){
        if (measurementRepository.existsMeasurementByName(dto.getName())){
            return new Result("This Measurement already exists!",false);
        }else {
            measurementRepository.save(dto);
            return new Result("Successfule added!",true);
        }
    }

    public Result updateMeasurement(Measurement dto,Integer id){
        Optional<Measurement> byId = measurementRepository.findById(id);
        if (byId.isEmpty()) return new Result("Measurement not found!",false);
        else {
            if (measurementRepository.existsMeasurementByName(dto.getName())){
                return new Result("This Measurement already exists!",false);
            } else {
                Measurement measurement=byId.get();
                measurement.setName(dto.getName());
                measurement.setStatus(dto.getStatus());
                measurementRepository.save(measurement);
                return new Result("Successfully updated!",true);
            }
        }
    }

    public Result deleteMeasurement(Integer id){
        Optional<Measurement> byId = measurementRepository.findById(id);
        if (byId.isEmpty()) return new Result("Measurement not found!",false);
        else {
            measurementRepository.deleteById(id);
            return new Result("Successfuly deleted!",true);
        }
    }
}
