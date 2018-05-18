package com.unisys.controller.impl;

import com.unisys.controller.IFairyLightImplementor;
import com.unisys.model.Color;
import com.unisys.model.FairyLight;
import com.unisys.model.FairyLightList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;


public class ColourAlgorithm implements IFairyLightImplementor {

    public static final long TIME_TO_SLEEP = 1000L;
    private Map<Color, List<FairyLight>> mapFairyLight = new HashMap<Color, List<FairyLight>>();

    public void connectFairyLightSet(FairyLightList fairyLightList) {
        setFairyLightListToColorMap(fairyLightList);

        switchOnByColor(Color.red);
        switchOnByColor(Color.green);
        switchOnByColor(Color.white);
    }

    private void switchOnByColor(Color color) {
        CountDownLatch latch = new CountDownLatch(mapFairyLight.get(color).size());
        for(FairyLight light : mapFairyLight.get(color)){
            Thread t = new Thread(new ConcurrentLight(light,latch));
            t.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class ConcurrentLight implements Runnable{
        private CountDownLatch latch;
        private FairyLight light;

        public ConcurrentLight(FairyLight light,CountDownLatch latch){
            this.light = light;
            this.latch = latch;
        }

        public void run() {
            light.setOn(true);

            try {
                Thread.sleep(TIME_TO_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            light.setOn(false);
            latch.countDown();
        }
    }



    private void setFairyLightListToColorMap(FairyLightList fairyLightList) {
        mapFairyLight = new HashMap<Color, List<FairyLight>>();
        for (FairyLight light : fairyLightList.getFairyLightList()) {

            if(!mapFairyLight.containsKey(light.getColor())){
                mapFairyLight.put(light.getColor(), new ArrayList<FairyLight>());
            }

            mapFairyLight.get(light.getColor()).add(light);
        }
    }
}
