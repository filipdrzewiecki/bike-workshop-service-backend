package com.workshop.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CsvPersistanceService {

//    private final BicycleService service;
//    private final EntityManager em;
//    private final BottomBracketRepository bottomBracketRepository;
//    private final BrakeRepository brakeRepository;
//    private final CassetteRepository cassetteRepository;
//    private final ChainRepository chainRepository;
//    private final ChainringRepository chainringRepository;
//    private final CrankRepository crankRepository;
//    private final DiscRepository discRepository;
//    private final ForkRepository forkRepository;
//    private final FrameRepository frameRepository;
//    private final FrontDerailleurRepository frontDerailleurRepository;
//    private final GripsRepository gripsRepository;
//    private final HandlebarRepository handlebarRepository;
//    private final HeadSetRepository headSetRepository;
//    private final HubRepository hubRepository;
//    private final PedalsRepository pedalsRepository;
//    private final RearDerailleurRepository rearDerailleurRepository;
//    private final RimRepository rimRepository;
//    private final SaddleRepository saddleRepository;
//    private final SeatpostRepository seatpostRepository;
//    private final SeatpostClampRepository seatpostClampRepository;
//    private final ShifterLeftRepository shifterLeftRepository;
//    private final ShifterRightRepository shifterRightRepository;
//    private final StemRepository stemRepository;
//    private final TyreRepository tyreRepository;


//    @Transactional
//    @EventListener
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        insertRearDerailleurToDb();
//        insertFrontDerailleurToDb();
//        insertChainringToDb();
//        insertHubsToDb();
//        insertRimToDb();
//        insertShifterLeftToDb();
//        insertShifterRightToDb();
//        insertTyreToDb();
//        insertBottomBracketToDb();
//        insertChainToDb();
//        insertFrameToDb();
//        insertGripsToDb();
//        insertHandlebarToDb();
//        insertHeadSetToDb();
//        insertSaddleToDb();
//        insertSeatpostToDb();
//        insertSeatpostClampToDb();
//        insertStemToDb();
//        insertForkToDb();
//        insertDiscToDb();
//        insertCassetteToDb();
//        insertHydraulicBrakeToDb();
//        insertPedalsToDb();
//        insertCrankToDb();
//        loadBicycles();
//
//    }

//    private void loadBicycles() {
//        List<Bicycle> list = loadObjectList(Bicycle.class);
//        for (Bicycle bicycle : list) {
//            service.addBicycle(bicycle);
//        }
//    }


//    private void insertCrankToDb() {
//        List<Crank> listFromCSV = loadObjectList(Crank.class);
//        for (Crank objectFromCSV : listFromCSV) {
//            Optional<Crank> objectFromDb = crankRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                crankRepository.save(objectFromCSV);
//            } else {
//                crankRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private <T> List<T> loadObjectList(Class<T> type) {
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
//    private void insertBottomBracketToDb() {
//        List<BottomBracket> listFromCSV = loadObjectList(BottomBracket.class);
//        for (BottomBracket objectFromCSV : listFromCSV) {
//            Optional<BottomBracket> objectFromDb = bottomBracketRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                bottomBracketRepository.save(objectFromCSV);
//            } else {
//                bottomBracketRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertHydraulicBrakeToDb() {
//        List<BrakeHydraulic> listFromCSV = loadObjectList(BrakeHydraulic.class);
//        for (BrakeHydraulic objectFromCSV : listFromCSV) {
//            Optional<BrakeHydraulic> objectFromDb = brakeRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                brakeRepository.save(objectFromCSV);
//            } else {
//                brakeRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertCassetteToDb() {
//        List<Cassette> listFromCSV = loadObjectList(Cassette.class);
//        for (Cassette objectFromCSV : listFromCSV) {
//            Optional<Cassette> objectFromDb = cassetteRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                cassetteRepository.save(objectFromCSV);
//            } else {
//                cassetteRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertChainToDb() {
//        List<Chain> listFromCSV = loadObjectList(Chain.class);
//        for (Chain objectFromCSV : listFromCSV) {
//            Optional<Chain> objectFromDb = chainRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                chainRepository.save(objectFromCSV);
//            } else {
//                chainRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertChainringToDb() {
//        List<Chainring> listFromCSV = loadObjectList(Chainring.class);
//        for (Chainring objectFromCSV : listFromCSV) {
//            Optional<Chainring> objectFromDb = chainringRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                chainringRepository.save(objectFromCSV);
//            } else {
//                chainringRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertDiscToDb() {
//        List<Disc> listFromCSV = loadObjectList(Disc.class);
//        for (Disc objectFromCSV : listFromCSV) {
//            Optional<Disc> objectFromDb = discRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                discRepository.save(objectFromCSV);
//            } else {
//                discRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertForkToDb() {
//        List<Fork> listFromCSV = loadObjectList(Fork.class);
//        for (Fork objectFromCSV : listFromCSV) {
//            Optional<Fork> objectFromDb = forkRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                forkRepository.save(objectFromCSV);
//            } else {
//                forkRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertFrameToDb() {
//        List<Frame> listFromCSV = loadObjectList(Frame.class);
//        for (Frame objectFromCSV : listFromCSV) {
//            Optional<Frame> objectFromDb = frameRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                frameRepository.save(objectFromCSV);
//            } else {
//                frameRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertFrontDerailleurToDb() {
//        List<FrontDerailleur> listFromCSV = loadObjectList(FrontDerailleur.class);
//        for (FrontDerailleur objectFromCSV : listFromCSV) {
//            Optional<FrontDerailleur> objectFromDb = frontDerailleurRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                frontDerailleurRepository.save(objectFromCSV);
//            } else {
//                frontDerailleurRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertGripsToDb() {
//        List<Grips> listFromCSV = loadObjectList(Grips.class);
//        for (Grips objectFromCSV : listFromCSV) {
//            Optional<Grips> objectFromDb = gripsRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                gripsRepository.save(objectFromCSV);
//            } else {
//                gripsRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertHandlebarToDb() {
//        List<Handlebar> listFromCSV = loadObjectList(Handlebar.class);
//        for (Handlebar objectFromCSV : listFromCSV) {
//            Optional<Handlebar> objectFromDb = handlebarRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                handlebarRepository.save(objectFromCSV);
//            } else {
//                handlebarRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertHeadSetToDb() {
//        List<HeadSet> listFromCSV = loadObjectList(HeadSet.class);
//        for (HeadSet objectFromCSV : listFromCSV) {
//            Optional<HeadSet> objectFromDb = headSetRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                headSetRepository.save(objectFromCSV);
//            } else {
//                headSetRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertHubsToDb() {
//        List<Hub> listFromCSV = loadObjectList(Hub.class);
//        for (Hub objectFromCSV : listFromCSV) {
//            Optional<Hub> objectFromDb = hubRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                hubRepository.save(objectFromCSV);
//            } else {
//                hubRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertPedalsToDb() {
//        List<Pedals> listFromCSV = loadObjectList(Pedals.class);
//        for (Pedals objectFromCSV : listFromCSV) {
//            Optional<Pedals> objectFromDb = pedalsRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                pedalsRepository.save(objectFromCSV);
//            } else {
//                pedalsRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertRearDerailleurToDb() {
//        List<RearDerailleur> listFromCSV = loadObjectList(RearDerailleur.class);
//        for (RearDerailleur objectFromCSV : listFromCSV) {
//            Optional<RearDerailleur> objectFromDb = rearDerailleurRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                rearDerailleurRepository.save(objectFromCSV);
//            } else {
//                rearDerailleurRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertRimToDb() {
//        List<Rim> listFromCSV = loadObjectList(Rim.class);
//        for (Rim objectFromCSV : listFromCSV) {
//            Optional<Rim> objectFromDb = rimRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                rimRepository.save(objectFromCSV);
//            } else {
//                rimRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertSaddleToDb() {
//        List<Saddle> listFromCSV = loadObjectList(Saddle.class);
//        for (Saddle objectFromCSV : listFromCSV) {
//            Optional<Saddle> objectFromDb = saddleRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                saddleRepository.save(objectFromCSV);
//            } else {
//                saddleRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertSeatpostClampToDb() {
//        List<SeatpostClamp> listFromCSV = loadObjectList(SeatpostClamp.class);
//        for (SeatpostClamp objectFromCSV : listFromCSV) {
//            Optional<SeatpostClamp> objectFromDb = seatpostClampRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                seatpostClampRepository.save(objectFromCSV);
//            } else {
//                seatpostClampRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertSeatpostToDb() {
//        List<Seatpost> listFromCSV = loadObjectList(Seatpost.class);
//        for (Seatpost objectFromCSV : listFromCSV) {
//            Optional<Seatpost> objectFromDb = seatpostRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                seatpostRepository.save(objectFromCSV);
//            } else {
//                seatpostRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertShifterLeftToDb() {
//        List<Shifter> listFromCSV = loadObjectList(Shifter.class);
//        for (Shifter objectFromCSV : listFromCSV) {
//            Optional<Shifter> objectFromDb = shifterLeftRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                shifterLeftRepository.save(objectFromCSV);
//            } else {
//                shifterLeftRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertShifterRightToDb() {
//        List<ShifterRight> listFromCSV = loadObjectList(ShifterRight.class);
//        for (ShifterRight objectFromCSV : listFromCSV) {
//            Optional<ShifterRight> objectFromDb = shifterRightRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                shifterRightRepository.save(objectFromCSV);
//            } else {
//                shifterRightRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertStemToDb() {
//        List<Stem> listFromCSV = loadObjectList(Stem.class);
//        for (Stem objectFromCSV : listFromCSV) {
//            Optional<Stem> objectFromDb = stemRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                stemRepository.save(objectFromCSV);
//            } else {
//                stemRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private void insertTyreToDb() {
//        List<Tyre> listFromCSV = loadObjectList(Tyre.class);
//        for (Tyre objectFromCSV : listFromCSV) {
//            Optional<Tyre> objectFromDb = tyreRepository.findByProductId(objectFromCSV.getProductId());
//            if (objectFromDb.isPresent()) {
//                objectFromCSV.setId(objectFromDb.get().getId());
//                tyreRepository.save(objectFromCSV);
//            } else {
//                tyreRepository.save(objectFromCSV);
//            }
//        }
//    }
//
//    private <T> void insertPartsToDb(Class<T> type) {
//        List<T> list = loadObjectList(type);
//        for (T entity : list) {
//            em.persist(entity);
//        }
//    }
}
