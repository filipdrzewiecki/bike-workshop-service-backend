package p76.bicycles;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import p76.bicycles.db.entity.*;
import p76.bicycles.db.entity.drivetrain.*;
import p76.bicycles.service.BicycleService;
import p76.bicycles.service.compatibility.CompatibilityService;

import javax.persistence.EntityManager;
import java.io.File;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class ApplicationListener {

    @Autowired
    BicycleService service;

    @Autowired
    CompatibilityService compatibility;

    @Autowired
    EntityManager em;

    @Transactional
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        insertTestDataToDatabase(RearDerailleur.class);

        service.addBicycle("Tormenta Lady", "Accent");
        service.addBicycle("Scale Unique", "Scott");
        service.addBicycle("Trans Siberian 2015", "Kross");

        Bicycle bicycle = createBicycle("Sportster 2017", "Scott");

        service.addBicycle(bicycle);

    }

    private Bicycle createBicycle(String name, String manufacturer) {
        Bicycle bicycle = new Bicycle();
        bicycle.setName(name);
        bicycle.setManufacturer(manufacturer);
        return bicycle;
    }

    public <T> void insertTestDataToDatabase(Class<T> type) {
        List<T> list = loadObjectList(type);
        for(T entity : list) {
            em.persist(entity);
        }
    }

    public <T> List<T> loadObjectList(Class<T> type) {
        String fileName = type.getSimpleName() + ".csv";
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader().withColumnSeparator(';');
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues =
                    mapper.readerFor(type).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            log.error("Error occurred while loading object list from file " + fileName, e);
            return Collections.emptyList();
        }
    }
}
