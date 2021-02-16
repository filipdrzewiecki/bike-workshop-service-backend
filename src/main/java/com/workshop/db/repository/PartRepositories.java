package com.workshop.db.repository;

import com.workshop.enums.PartType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class PartRepositories {

    private final BottomBracketRepository bottomBracketRepository;
    private final BrakeCaliperRepository brakeCaliperRepository;
    private final BrakeHydraulicRepository brakeHydraulicRepository;
    private final BrakeLeverRepository brakeLeverRepository;
    private final CassetteRepository cassetteRepository;
    private final ChainRepository chainRepository;
    private final ChainringRepository chainringRepository;
    private final CrankRepository crankRepository;
    private final DamperRepository damperRepository;
    private final DiscRepository discRepository;
    private final FrameRepository frameRepository;
    private final ForkRepository forkRepository;
    private final FrontDerailleurRepository frontDerailleurRepository;
    private final GripsRepository gripsRepository;
    private final HandlerbarRepository handlerbarRepository;
    private final HeadsetRepository headsetRepository;
    private final HubRepository hubRepository;
    private final PedalsRepository pedalsRepository;
    private final RearDerailleurRepository rearDerailleurRepository;
    private final RimRepository rimRepository;
    private final SaddleRepository saddleRepository;
    private final SeatpostClampRepository seatpostClampRepository;
    private final SeatpostRepository seatpostRepository;
    private final ShifterRepository shifterRepository;
    private final StemRepository stemRepository;
    private final TyreRepository tyreRepository;
    private final WheelRepository wheelRepository;

    public Map<Object, Object> getRepositoryInstance() {
        return Map.ofEntries(
                Map.entry(PartType.BOTTOM_BRACKET, bottomBracketRepository),
                Map.entry(PartType.BRAKE_HYDRAULIC, brakeHydraulicRepository),
                Map.entry(PartType.BRAKE_CALIPER, brakeCaliperRepository),
                Map.entry(PartType.BRAKE_LEVER, brakeLeverRepository),
                Map.entry(PartType.CASSETTE, cassetteRepository),
                Map.entry(PartType.CHAIN, chainRepository),
                Map.entry(PartType.CHAINRING, chainringRepository),
                Map.entry(PartType.CRANK, crankRepository),
                Map.entry(PartType.DAMPER, damperRepository),
                Map.entry(PartType.DISC, discRepository),
                Map.entry(PartType.FRAME, frameRepository),
                Map.entry(PartType.FORK, forkRepository),
                Map.entry(PartType.FRONT_DERAILLEUR, frontDerailleurRepository),
                Map.entry(PartType.GRIPS, gripsRepository),
                Map.entry(PartType.HANDLEBAR, handlerbarRepository),
                Map.entry(PartType.HEADSET, headsetRepository),
                Map.entry(PartType.HUB, hubRepository),
                Map.entry(PartType.PEDALS, pedalsRepository),
                Map.entry(PartType.REAR_DERAILLEUR, rearDerailleurRepository),
                Map.entry(PartType.RIM, rimRepository),
                Map.entry(PartType.SADDLE, saddleRepository),
                Map.entry(PartType.SEATPOST_CLAMP, seatpostClampRepository),
                Map.entry(PartType.SEATPOST, seatpostRepository),
                Map.entry(PartType.SHIFTER, shifterRepository),
                Map.entry(PartType.STEM, stemRepository),
                Map.entry(PartType.TYRE, tyreRepository),
                Map.entry(PartType.WHEEL, wheelRepository));
    }
}
