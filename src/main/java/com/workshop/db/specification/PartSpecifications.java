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
import com.workshop.db.entity.Disc;
import com.workshop.db.entity.Fork;
import com.workshop.db.entity.Frame;
import com.workshop.db.entity.FrontDerailleur;
import com.workshop.db.entity.Grips;
import com.workshop.db.entity.Handlebar;
import com.workshop.db.entity.HeadSet;
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
import com.workshop.enums.PartType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PartSpecifications {

    public static final PartSpec<Frame> FRAME_SPEC = new PartSpec<>(PartType.FRAME, Frame.class, "frame", "FRM");
    public static final PartSpec<BottomBracket> BOTTOM_BRACKET_SPEC = new PartSpec<>(PartType.BOTTOM_BRACKET, BottomBracket.class, "bottom_bracket", "BBR");
    public static final PartSpec<BrakeHydraulic> BRAKE_HYDRAULIC_SPEC = new PartSpec<>(PartType.BRAKE_HYDRAULIC, BrakeHydraulic.class, "bottom_bracket", "BBR");
    public static final PartSpec<BrakeCaliper> BRAKE_CALIPER_SPEC = new PartSpec<>(PartType.BRAKE_CALIPER, BrakeCaliper.class, "bottom_bracket", "BBR");
    public static final PartSpec<BrakeLever> BRAKE_LEVER_SPEC = new PartSpec<>(PartType.BRAKE_LEVER, BrakeLever.class, "bottom_bracket", "BBR");
    public static final PartSpec<Fork> FORK_SPEC = new PartSpec<>(PartType.FORK, Fork.class, "bottom_bracket", "BBR");
    public static final PartSpec<Damper> DAMPER_SPEC = new PartSpec<>(PartType.DAMPER, Damper.class, "bottom_bracket", "BBR");
    public static final PartSpec<Disc> DISC_SPEC = new PartSpec<>(PartType.DISC, Disc.class, "bottom_bracket", "BBR");
    public static final PartSpec<Hub> HUB_SPEC = new PartSpec<>(PartType.HUB, Hub.class, "bottom_bracket", "BBR");
    public static final PartSpec<Pedals> PEDALS_SPEC = new PartSpec<>(PartType.PEDALS, Pedals.class, "bottom_bracket", "BBR");
    public static final PartSpec<Rim> RIM_SPEC = new PartSpec<>(PartType.RIM, Rim.class, "bottom_bracket", "BBR");
    public static final PartSpec<Tyre> TYRE_SPEC = new PartSpec<>(PartType.TYRE, Tyre.class, "bottom_bracket", "BBR");
    public static final PartSpec<Wheel> WHEEL_SPEC = new PartSpec<>(PartType.WHEEL, Wheel.class, "bottom_bracket", "BBR");
    public static final PartSpec<Saddle> SADDLE_SPEC = new PartSpec<>(PartType.SADDLE, Saddle.class, "bottom_bracket", "BBR");
    public static final PartSpec<Seatpost> SEATPOST_SPEC = new PartSpec<>(PartType.SEATPOST, Seatpost.class, "bottom_bracket", "BBR");
    public static final PartSpec<SeatpostClamp> SEATPOST_CLAMP_SPEC = new PartSpec<>(PartType.SEATPOST_CLAMP, SeatpostClamp.class, "bottom_bracket", "BBR");
    public static final PartSpec<RearDerailleur> REAR_DERAILLEUR_SPEC = new PartSpec<>(PartType.REAR_DERAILLEUR, RearDerailleur.class, "bottom_bracket", "BBR");
    public static final PartSpec<FrontDerailleur> FRONT_DERAILLEUR_SPEC = new PartSpec<>(PartType.FRONT_DERAILLEUR, FrontDerailleur.class, "bottom_bracket", "BBR");
    public static final PartSpec<Crank> CRANK_SPEC = new PartSpec<>(PartType.CRANK, Crank.class, "bottom_bracket", "BBR");
    public static final PartSpec<Chainring> CHAINRING_SPEC = new PartSpec<>(PartType.CHAINRING, Chainring.class, "bottom_bracket", "BBR");
    public static final PartSpec<Chain> CHAIN_SPEC = new PartSpec<>(PartType.CHAIN, Chain.class, "bottom_bracket", "BBR");
    public static final PartSpec<Cassette> CASSETTE_SPEC = new PartSpec<>(PartType.CASSETTE, Cassette.class, "bottom_bracket", "BBR");
    public static final PartSpec<Shifter> SHIFTER_SPEC = new PartSpec<>(PartType.SHIFTER, Shifter.class, "bottom_bracket", "BBR");
    public static final PartSpec<Grips> GRIPS_SPEC = new PartSpec<>(PartType.GRIPS, Grips.class, "bottom_bracket", "BBR");
    public static final PartSpec<Handlebar> HANDLEBAR_SPEC = new PartSpec<>(PartType.HANDLEBAR, Handlebar.class, "bottom_bracket", "BBR");
    public static final PartSpec<HeadSet> HEADSET_SPEC = new PartSpec<>(PartType.HEADSET, HeadSet.class, "bottom_bracket", "BBR");
    public static final PartSpec<Stem> STEM_SPEC = new PartSpec<>(PartType.STEM, Stem.class, "bottom_bracket", "BBR");
    public static final PartSpec<BicyclePart> COMMON_SPEC = new PartSpec<>(PartType.COMMON, BicyclePart.class, null, null);



}
