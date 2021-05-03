package com.workshop.db.specification;

import com.workshop.db.entity.BicyclePart;
import com.workshop.db.entity.BottomBracket;
import com.workshop.db.entity.BrakeCaliper;
import com.workshop.db.entity.BrakeHydraulic;
import com.workshop.db.entity.BrakeLever;
import com.workshop.db.entity.Cassette;
import com.workshop.db.entity.Chain;
import com.workshop.db.entity.Chainring;
import com.workshop.db.entity.Crank;
import com.workshop.db.entity.Damper;
import com.workshop.db.entity.BrakeRotor;
import com.workshop.db.entity.Fork;
import com.workshop.db.entity.Frame;
import com.workshop.db.entity.FrontDerailleur;
import com.workshop.db.entity.Grips;
import com.workshop.db.entity.Handlebar;
import com.workshop.db.entity.Headset;
import com.workshop.db.entity.Hub;
import com.workshop.db.entity.Pedals;
import com.workshop.db.entity.RearDerailleur;
import com.workshop.db.entity.Rim;
import com.workshop.db.entity.Saddle;
import com.workshop.db.entity.Seatpost;
import com.workshop.db.entity.SeatpostClamp;
import com.workshop.db.entity.Shifter;
import com.workshop.db.entity.Stem;
import com.workshop.db.entity.Tyre;
import com.workshop.db.entity.Wheel;
import com.workshop.enums.PartPrefix;
import com.workshop.enums.PartType;
import lombok.experimental.UtilityClass;

import java.util.Map;

@UtilityClass
public class PartSpecifications {

    public static final PartSpec FRAME_SPEC = new PartSpec(PartType.FRAME, Frame.class, "frame", PartPrefix.FRM);
    public static final PartSpec BOTTOM_BRACKET_SPEC = new PartSpec(PartType.BOTTOM_BRACKET, BottomBracket.class, "bottom_bracket", PartPrefix.BBR);
    public static final PartSpec BRAKE_HYDRAULIC_SPEC = new PartSpec(PartType.BRAKE_HYDRAULIC, BrakeHydraulic.class, "brake_hydraulic", PartPrefix.BRH);
    public static final PartSpec BRAKE_CALIPER_SPEC = new PartSpec(PartType.BRAKE_CALIPER, BrakeCaliper.class, "brake_caliper", PartPrefix.BRC);
    public static final PartSpec BRAKE_LEVER_SPEC = new PartSpec(PartType.BRAKE_LEVER, BrakeLever.class, "brake_lever", PartPrefix.BRL);
    public static final PartSpec FORK_SPEC = new PartSpec(PartType.FORK, Fork.class, "fork", PartPrefix.FRK);
    public static final PartSpec DAMPER_SPEC = new PartSpec(PartType.DAMPER, Damper.class, "damper", PartPrefix.DMP);
    public static final PartSpec DISC_SPEC = new PartSpec(PartType.DISC, BrakeRotor.class, "disc", PartPrefix.DSC);
    public static final PartSpec HUB_SPEC = new PartSpec(PartType.HUB, Hub.class, "hub", PartPrefix.HUB);
    public static final PartSpec PEDALS_SPEC = new PartSpec(PartType.PEDALS, Pedals.class, "pedals", PartPrefix.PDL);
    public static final PartSpec RIM_SPEC = new PartSpec(PartType.RIM, Rim.class, "rim", PartPrefix.RIM);
    public static final PartSpec TYRE_SPEC = new PartSpec(PartType.TYRE, Tyre.class, "tyre", PartPrefix.TYR);
    public static final PartSpec WHEEL_SPEC = new PartSpec(PartType.WHEEL, Wheel.class, "wheel", PartPrefix.WHL);
    public static final PartSpec SADDLE_SPEC = new PartSpec(PartType.SADDLE, Saddle.class, "saddle", PartPrefix.SDL);
    public static final PartSpec SEATPOST_SPEC = new PartSpec(PartType.SEATPOST, Seatpost.class, "seatpost", PartPrefix.SPT);
    public static final PartSpec SEATPOST_CLAMP_SPEC = new PartSpec(PartType.SEATPOST_CLAMP, SeatpostClamp.class, "seatpost_clamp", PartPrefix.SCP);
    public static final PartSpec REAR_DERAILLEUR_SPEC = new PartSpec(PartType.REAR_DERAILLEUR, RearDerailleur.class, "rear_derailleur", PartPrefix.RDR);
    public static final PartSpec FRONT_DERAILLEUR_SPEC = new PartSpec(PartType.FRONT_DERAILLEUR, FrontDerailleur.class, "front_derailleur", PartPrefix.FDR);
    public static final PartSpec CRANK_SPEC = new PartSpec(PartType.CRANK, Crank.class, "crank", PartPrefix.CRK);
    public static final PartSpec CHAINRING_SPEC = new PartSpec(PartType.CHAINRING, Chainring.class, "chainring", PartPrefix.CHR);
    public static final PartSpec CHAIN_SPEC = new PartSpec(PartType.CHAIN, Chain.class, "chain", PartPrefix.CHN);
    public static final PartSpec CASSETTE_SPEC = new PartSpec(PartType.CASSETTE, Cassette.class, "cassette", PartPrefix.CST);
    public static final PartSpec SHIFTER_SPEC = new PartSpec(PartType.SHIFTER, Shifter.class, "shifter", PartPrefix.SHF);
    public static final PartSpec GRIPS_SPEC = new PartSpec(PartType.GRIPS, Grips.class, "grips", PartPrefix.GRP);
    public static final PartSpec HANDLEBAR_SPEC = new PartSpec(PartType.HANDLEBAR, Handlebar.class, "handlebar", PartPrefix.HBR);
    public static final PartSpec HEADSET_SPEC = new PartSpec(PartType.HEADSET, Headset.class, "headset", PartPrefix.HST);
    public static final PartSpec STEM_SPEC = new PartSpec(PartType.STEM, Stem.class, "stem", PartPrefix.STM);
    public static final PartSpec BICYCLE_PART_SPEC = new PartSpec(PartType.BICYCLE_PART, BicyclePart.class, "bicycle_part", null);

    public static final Map<PartType, PartSpec> PART_SPEC_MAP = Map.ofEntries(
            Map.entry(FRAME_SPEC.getPartType(), FRAME_SPEC),
            Map.entry(BOTTOM_BRACKET_SPEC.getPartType(), BOTTOM_BRACKET_SPEC),
            Map.entry(BRAKE_HYDRAULIC_SPEC.getPartType(), BRAKE_HYDRAULIC_SPEC),
            Map.entry(BRAKE_CALIPER_SPEC.getPartType(), BRAKE_CALIPER_SPEC),
            Map.entry(BRAKE_LEVER_SPEC.getPartType(), BRAKE_LEVER_SPEC),
            Map.entry(FORK_SPEC.getPartType(), FORK_SPEC),
            Map.entry(DAMPER_SPEC.getPartType(), DAMPER_SPEC),
            Map.entry(HUB_SPEC.getPartType(), HUB_SPEC),
            Map.entry(DISC_SPEC.getPartType(), DISC_SPEC),
            Map.entry(PEDALS_SPEC.getPartType(), PEDALS_SPEC),
            Map.entry(RIM_SPEC.getPartType(), RIM_SPEC),
            Map.entry(TYRE_SPEC.getPartType(), TYRE_SPEC),
            Map.entry(WHEEL_SPEC.getPartType(), WHEEL_SPEC),
            Map.entry(SADDLE_SPEC.getPartType(), SADDLE_SPEC),
            Map.entry(SEATPOST_SPEC.getPartType(), SEATPOST_SPEC),
            Map.entry(SEATPOST_CLAMP_SPEC.getPartType(), SEATPOST_CLAMP_SPEC),
            Map.entry(REAR_DERAILLEUR_SPEC.getPartType(), REAR_DERAILLEUR_SPEC),
            Map.entry(FRONT_DERAILLEUR_SPEC.getPartType(), FRONT_DERAILLEUR_SPEC),
            Map.entry(CHAINRING_SPEC.getPartType(), CHAINRING_SPEC),
            Map.entry(CRANK_SPEC.getPartType(), CRANK_SPEC),
            Map.entry(CHAIN_SPEC.getPartType(), CHAIN_SPEC),
            Map.entry(CASSETTE_SPEC.getPartType(), CASSETTE_SPEC),
            Map.entry(SHIFTER_SPEC.getPartType(), SHIFTER_SPEC),
            Map.entry(GRIPS_SPEC.getPartType(), GRIPS_SPEC),
            Map.entry(HANDLEBAR_SPEC.getPartType(), HANDLEBAR_SPEC),
            Map.entry(HEADSET_SPEC.getPartType(), HEADSET_SPEC),
            Map.entry(STEM_SPEC.getPartType(), STEM_SPEC),
            Map.entry(BICYCLE_PART_SPEC.getPartType(), BICYCLE_PART_SPEC)
    );
}
