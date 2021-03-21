package com.workshop.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workshop.db.entity.Bicycle;
import com.workshop.db.entity.Frame;
import com.workshop.db.repository.BottomBracketRepository;
import com.workshop.db.repository.FrameRepository;
import com.workshop.db.repository.GenericPartRepository;
import com.workshop.db.repository.PartRepositories;
import com.workshop.db.specification.GenericSpecification;
import com.workshop.db.specification.Specifications;
import com.workshop.enums.PartType;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

/** Manages parts added by the user */

@Service
@RequiredArgsConstructor
public class PersonalPartService {

    private final PersonalBicycleService personalBicycleService;
    private final FrameRepository frameRepository;
    private final PartRepositories repositories;
    private final GenericPartRepository genericPartRepository;
    private final BottomBracketRepository bottomBracketRepository;



    @SneakyThrows
    @Transactional
    public Object getUserParts(GenericSpecification spec, Pageable pageable, String userName) {
        if (spec.getPartType() == null || spec.getPartType() == PartType.COMMON) {
            return repositories.findAllParts(spec, pageable);
        }
        return getParts(spec.getPartType(), pageable, spec);
    }

    @SneakyThrows
    public Object getParts(PartType type, Pageable pageable, GenericSpecification genericSpec) {
        Specification specification = Specifications.buildSpecification(genericSpec);

        Object[] parameters = {specification, pageable};
        Object repositoryInstance = repositories.getRepositoryInstance().get(type);

        Class<?> clazz = repositoryInstance.getClass();

        Method method = clazz.getMethod("findAll", Specification.class, Pageable.class);
        return method.invoke(repositoryInstance, parameters);
    }

    @SneakyThrows
    @Transactional
    public Object addPartToBicycle(String userName, String bicycleName, PartType type, String partJson) {
        Bicycle bicycle = personalBicycleService.getBicycle(userName, bicycleName);

        if (type == PartType.FRAME) {
            return addFrame(bicycle, partJson);
        }
        return null;
    }

    @Transactional
    public Object addExistingPartToBicycle(String userName, String bicycleName, PartType type, String partId) {
        Bicycle bicycle = personalBicycleService.getBicycle(userName, bicycleName);
        if (type == PartType.FRAME) {
            Frame frame = frameRepository.findByProductId(partId).orElseThrow(() -> new EntityNotFoundException("Couldn't find part"));
            bicycle.setFrame(frame);
        }
        return personalBicycleService.updateBicycle(bicycle);
    }

    @SneakyThrows
    @Transactional
    public void deleteBicyclePart(String userName, String bicycleName, PartType type) {
        Bicycle bicycle = personalBicycleService.getBicycle(userName, bicycleName);

        if (type == PartType.FRAME) {
            deleteFrameOfBicycle(bicycle);
        }
    }

    private Frame addFrame(Bicycle bicycle, String frameJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Frame frame = mapper.readValue(frameJson, Frame.class);
        frameRepository.save(frame);
        bicycle.setFrame(frame);
        personalBicycleService.updateBicycle(bicycle);
        return frame;
    }

    private void deleteFrameOfBicycle(Bicycle bicycle) throws IOException {
        Frame frame = bicycle.getFrame();
        bicycle.setFrame(null);
        personalBicycleService.updateBicycle(bicycle);
        if (!frame.getIsOfficial()) {
            frameRepository.delete(frame);
        }
    }

    public Object fetchBicyclePart(String userName, String bicycleName, PartType type) {
        Bicycle bicycle = personalBicycleService.getBicycle(userName, bicycleName);
        if (type == PartType.FRAME) {
            return bicycle.getFrame();
        }
        return null;
    }
}
