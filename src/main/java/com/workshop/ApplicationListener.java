package com.workshop;

import com.workshop.config.security.entity.Role;
import com.workshop.config.security.repository.RoleRepository;
import com.workshop.db.entity.Bicycle;
import com.workshop.db.repository.PedalsRepository;
import com.workshop.service.PersonalBicycleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApplicationListener {

    private final PersonalBicycleService service;
    private final EntityManager em;
    private final PedalsRepository pedalsRepository;
    private final RoleRepository roleRepository;

    @Transactional
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Optional<Role> admin = roleRepository.findByRoleName("ADMIN");
        if (admin.isEmpty()) {
            roleRepository.save(new Role("ADMIN"));
        }
        Optional<Role> customer = roleRepository.findByRoleName("CUSTOMER");
        if (admin.isEmpty()) {
            roleRepository.save(new Role("CUSTOMER"));
        }

//        insertPartsToDb(RearDerailleur.class);
//        insertPartsToDb(FrontDerailleur.class);
//        insertPartsToDb(Chainring.class);
//        insertPartsToDb(Hub.class);
//        insertPartsToDb(Rim.class);
//        insertPartsToDb(Shifter.class);
//        insertPartsToDb(ShifterRight.class);
//        insertPartsToDb(Tyre.class);
//        insertPartsToDb(BottomBracket.class);
//        insertPartsToDb(Chain.class);
//        insertPartsToDb(Frame.class);
//        insertPartsToDb(Grips.class);
//        insertPartsToDb(Handlebar.class);
//        insertPartsToDb(HeadSet.class);
//        insertPartsToDb(Saddle.class);
//        insertPartsToDb(Seatpost.class);
//        insertPartsToDb(SeatpostClamp.class);
//        insertPartsToDb(Stem.class);
//        insertPartsToDb(Fork.class);
//        insertPartsToDb(Disc.class);
//        insertPartsToDb(Cassette.class);
//        insertPartsToDb(BrakeHydraulic.class);
//        insertPedalsToDb();
//        loadParts();
//        loadBicycles();

    }

    private Bicycle createBicycle(String name, String manufacturer) {
        Bicycle bicycle = new Bicycle();
        return bicycle;
    }


//    public void loadBicycles() {
//        List<Bicycle> list = loadObjectList(Bicycle.class);
//        for(Bicycle bicycle : list) {
//            service.addBicycle(bicycle);
//        }
//    }


//
//    public <T> void insertPartsToDb(Class<T> type) {
//        List<T> list = loadObjectList(type);
//        for(T entity : list) {
//            em.persist(entity);
//        }
//    }
//
//    public <T> void insertRearDerailleurToDb(Class<T> type) {
//        List<T> list = loadObjectList(type);
//        for(T entity : list) {
//            em.persist(entity);
//        }
//    }
//
//    public <T> List<T> loadObjectList(Class<T> type) {
//        String fileName = type.getSimpleName() + ".csv";
//        try {
//            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader().withColumnSeparator(';');
//            CsvMapper mapper = new CsvMapper();
//
//            File file = new ClassPathResource(fileName).getFile();
//            MappingIterator<T> readValues =
//                    mapper.readerFor(type).with(bootstrapSchema).readValues(file);
//            return readValues.readAll();
//        } catch (Exception e) {
//            log.error("Error occurred while loading object list from file " + fileName, e);
//            return Collections.emptyList();
//        }
//    }
//
//
//    public void insertPedalsToDb() {
//        List<Pedals> pedals = loadObjectList(Pedals.class);
//        for(Pedals pedal : pedals ) {
//            if(!pedalsRepository.existsByProductId(pedal.getProductId())) {
//                em.persist(pedal);
//            }
//        }
//    }

}
