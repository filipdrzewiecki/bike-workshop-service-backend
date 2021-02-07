package com.workshop.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workshop.db.entity.Bicycle;
import com.workshop.db.entity.Frame;
import com.workshop.db.repository.FrameRepository;
import com.workshop.enums.PartType;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;

/** Manages parts added by the user */

@Service
@RequiredArgsConstructor
public class CustomPartService {

    private final CustomBicycleService customBicycleService;
    private final FrameRepository frameRepository;


    @SneakyThrows
    @Transactional
    public Object addPartToBicycle(String userName, String bicycleName, PartType type, String partJson) {
        Bicycle bicycle = customBicycleService.getBicycle(userName, bicycleName);

        if (type == PartType.FRAME) {
            return addFrame(bicycle, partJson);
        }
        return null;
    }

    @Transactional
    public Object addExistingPartToBicycle(String userName, String bicycleName, PartType type, String partId) {
        Bicycle bicycle = customBicycleService.getBicycle(userName, bicycleName);
        if (type == PartType.FRAME) {
            Frame frame = frameRepository.findByProductId(partId).orElseThrow(() -> new EntityNotFoundException("Couldn't find part"));
            bicycle.setFrame(frame);
        }
        return customBicycleService.updateBicycle(bicycle);
    }

    @SneakyThrows
    @Transactional
    public void deleteBicyclePart(String userName, String bicycleName, PartType type) {
        Bicycle bicycle = customBicycleService.getBicycle(userName, bicycleName);

        if (type == PartType.FRAME) {
            deleteFrameOfBicycle(bicycle);
        }
    }

    private Frame addFrame(Bicycle bicycle, String frameJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Frame frame = mapper.readValue(frameJson, Frame.class);
        frameRepository.save(frame);
        bicycle.setFrame(frame);
        customBicycleService.updateBicycle(bicycle);
        return frame;
    }

    private void deleteFrameOfBicycle(Bicycle bicycle) throws IOException {
        Frame frame = bicycle.getFrame();
        bicycle.setFrame(null);
        customBicycleService.updateBicycle(bicycle);
        if (!frame.getIsOfficial()) {
            frameRepository.delete(frame);
        }
    }

    public Object fetchBicyclePart(String userName, String bicycleName, PartType type) {
        Bicycle bicycle = customBicycleService.getBicycle(userName, bicycleName);
        if (type == PartType.FRAME) {
            return bicycle.getFrame();
        }
        return null;
    }
}
