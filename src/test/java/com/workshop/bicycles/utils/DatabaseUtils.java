package com.workshop.bicycles.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.workshop.bicycles.IntegrationTest;
import com.workshop.enums.PartType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.workshop.db.entity.BicyclePart;
import com.workshop.db.entity.Frame;
import com.workshop.db.repository.BicyclePartRepository;

import java.nio.file.Paths;
import java.util.List;


@SpringBootTest
class DatabaseUtils extends IntegrationTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BicyclePartRepository bicyclePartRepository;

    @Test
    @Disabled
    void saveFrames() throws Exception {
        List<BicyclePart> frames = bicyclePartRepository.findAllByIsOfficialTrueAndProduct(PartType.FRAME.getCommonName());

        objectMapper.writeValueAsString(frames);

        objectMapper.writeValue(Paths.get("src/test/resources/db/frames.json").toFile(), frames);
    }

    @Test
    @Disabled
    void saveRearDerailleur() throws Exception {
        List<BicyclePart> derailleurs = bicyclePartRepository.findAllByIsOfficialTrueAndProduct(PartType.REAR_DERAILLEUR.getCommonName());

        objectMapper.writeValueAsString(derailleurs);

        objectMapper.writeValue(Paths.get("src/test/resources/db/derailleurs.json").toFile(), derailleurs);
    }

    @Test
    @Disabled
    void saveFork() throws Exception {
        List<BicyclePart> forks = bicyclePartRepository.findAllByIsOfficialTrueAndProduct(PartType.FORK.getCommonName());

        objectMapper.writeValueAsString(forks);

        objectMapper.writeValue(Paths.get("src/test/resources/db/fork.json").toFile(), forks);
    }

    @Test
    @Disabled
    void saveAll() throws Exception {
        List<BicyclePart> all = bicyclePartRepository.findAll();

        objectMapper.writeValueAsString(all);

        objectMapper.writeValue(Paths.get("src/test/resources/db/parts.json").toFile(), all);
    }

    @Test
    @Disabled
    void deleteFrames() throws Exception {
        //frameRepository.deleteAll();
    }

    @Test
    @Disabled
    void addFrames() throws Exception {
        String json = resourceAsJson("db/frames.json");
        List<Frame> frames = objectMapper.readValue(json, new TypeReference<List<Frame>>() {});
        bicyclePartRepository.saveAll(frames);
    }

    @Test
    @Disabled
    void getAllParts() throws Exception {
        PartType enumz = PartType.valueOfName("frame");
        List<BicyclePart> parts = bicyclePartRepository.findAll();
    }
}
