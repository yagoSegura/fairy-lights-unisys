package com.unisys.model;

import com.unisys.controller.IFairyLightImplementor;

import java.util.ArrayList;
import java.util.List;

public class FairyLightList {
    private List<FairyLight> fairyLightList = new ArrayList<FairyLight>();
    private IFairyLightImplementor implementor;

    public List<FairyLight> getFairyLightList() {
        return fairyLightList;
    }

    public void setImplementor(IFairyLightImplementor implementor) {
        this.implementor = implementor;
    }

    public IFairyLightImplementor getImplementor() {
        return implementor;
    }

    public void switchOn(){
        while(true) {
            implementor.connectFairyLightSet(this);
        }
    }
}
