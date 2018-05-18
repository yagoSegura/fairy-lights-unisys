package com.unisys.application;

import com.unisys.controller.impl.AlternateAlgorithm;
import com.unisys.controller.impl.ColourAlgorithm;
import com.unisys.controller.impl.SequenceAlgorithm;
import com.unisys.model.Color;
import com.unisys.model.FairyLight;
import com.unisys.model.FairyLightList;

import java.util.Random;

public class FairyLightGame {

    private final static int NUMBER_OF_LIGHTS = 20;

    private final static int SEQUENCE_ALGORITHM_INDEX = 0;
    private final static int COLOUR_ALGORITHM_INDEX = 1;
    private final static int ALTERNATE_ALGORITHM_INDEX = 2;

    public static void main(String[] args) throws Exception {
        FairyLightList fairyLightList = buildSampleRandomFairyLightList(Integer.parseInt(args[0]));
        fairyLightList.switchOn();
    }

    private static FairyLightList buildSampleRandomFairyLightList(int algorithm) throws Exception {
        FairyLightList fairyLights= new FairyLightList();

        for (int iter = 0; iter < NUMBER_OF_LIGHTS; iter++) {
            Random rnd = new Random();
            Color randomColor = Color.values()[rnd.nextInt(Color.values().length)];

            fairyLights.getFairyLightList().add(new FairyLight(randomColor, false, iter));
        }

        switch (algorithm) {
            case SEQUENCE_ALGORITHM_INDEX:
                fairyLights.setImplementor(new SequenceAlgorithm());
                break;
            case COLOUR_ALGORITHM_INDEX:
                fairyLights.setImplementor(new ColourAlgorithm());
                break;
            case ALTERNATE_ALGORITHM_INDEX:
                fairyLights.setImplementor(new AlternateAlgorithm());
                break;
            default :
                throw new Exception("Not registered algorithm index");
        }

        return fairyLights;
    }
}
