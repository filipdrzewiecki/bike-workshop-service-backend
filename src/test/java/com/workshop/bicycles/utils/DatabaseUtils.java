package com.workshop.bicycles.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.workshop.bicycles.IntegrationTest;
import com.workshop.db.entity.RearDerailleur;
import com.workshop.db.repository.RearDerailleurRepository;
import com.workshop.enums.PartType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.workshop.db.entity.BicyclePart;
import com.workshop.db.entity.Frame;
import com.workshop.db.repository.BicyclePartRepository;
import com.workshop.db.repository.FrameRepository;

import java.nio.file.Paths;
import java.util.List;


@SpringBootTest
class DatabaseUtils extends IntegrationTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FrameRepository frameRepository;

    @Autowired
    private RearDerailleurRepository rearDerailleurRepository;

    @Autowired
    private BicyclePartRepository bicyclePartRepository;

    @Test
    @Disabled
    void saveFrames() throws Exception {
        List<Frame> frames = frameRepository.findAllByIsOfficialTrue();

        objectMapper.writeValueAsString(frames);

        objectMapper.writeValue(Paths.get("src/test/resources/db/frames.json").toFile(), frames);
    }

    @Test
    @Disabled
    void saveRearDerailleur() throws Exception {
        List<RearDerailleur> derailleurs = rearDerailleurRepository.findAllByIsOfficialTrue();

        objectMapper.writeValueAsString(derailleurs);

        objectMapper.writeValue(Paths.get("src/test/resources/db/derailleurs.json").toFile(), derailleurs);
    }

    @Test
    @Disabled
    void deleteFrames() throws Exception {
        frameRepository.deleteAll();
    }

    @Test
    @Disabled
    void addFrames() throws Exception {
        String json = resourceAsJson("db/frames.json");
        List<Frame> frames = objectMapper.readValue(json, new TypeReference<List<Frame>>() {});
        frameRepository.saveAll(frames);
    }

    @Test
    @Disabled
    void getAllParts() throws Exception {
        PartType enumz = PartType.valueOfName("frame");
        List<BicyclePart> parts = bicyclePartRepository.findAll();
    }
}
