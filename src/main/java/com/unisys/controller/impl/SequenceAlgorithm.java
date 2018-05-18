package com.unisys.controller.impl;

import com.unisys.controller.IFairyLightImplementor;
import com.unisys.model.FairyLight;
import com.unisys.model.FairyLightList;

public class SequenceAlgorithm implements IFairyLightImplementor {
    public void connectFairyLightSet(FairyLightList fairyLightList) {
           for (FairyLight fairyLight : fairyLightList.getFairyLightList()) {
               fairyLight.setOn(true);
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   System.err.println("Error : " + fairyLight);
               }
               fairyLight.setOn(false);
           }

    }
}
