package p76.bicycles.service.compatibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.entity.Cassette;
import p76.bicycles.db.entity.FrontWheel;
import p76.bicycles.db.repository.BicycleRepository;
import p76.bicycles.service.BicycleService;

import java.util.*;

import static p76.bicycles.service.compatibility.Messages.*;

@Component
public class CompatibilityService {

    @Autowired
    BicycleRepository repository;

    @Autowired
    BicycleService service;

    @Autowired
    Common common;

    @Autowired
    WheelCompatibilityService wheelCompatibilityService;

    @Autowired
    DrivetrainCompatibilityService drivetrainCompatibilityService;

    @Autowired
    SpeedsCompatibilityService speedsCompatibilityService;

    public List<CompatibilityResult> bicycleCheck(Bicycle bicycle) {
        List<CompatibilityResult> result = new ArrayList();
        result.add(new CompatibilityResult("drivetrainCheck", drivetrainCompatibilityService.drivetrainCheck(bicycle)));
        result.add(new CompatibilityResult("speedsCompatibilityCheck", speedsCompatibilityService.speedsCompatibilityCheck(bicycle)));
        result.add(new CompatibilityResult("wheelCheck", wheelCompatibilityService.wheelCheck(bicycle)));
        return result;
    }

    public List<List<CompatibilityResult>> bicycleCheckAll(){
        List<List<CompatibilityResult>> result = new ArrayList<>();

        List <Bicycle> bicycles = service.findAllBicycles();
        for (Bicycle bicycle : bicycles){
            result.add(bicycleCheck(bicycle));
        }

        return result;
    }



}