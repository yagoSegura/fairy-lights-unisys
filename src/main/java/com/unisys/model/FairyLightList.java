package com.unisys.model;

import com.unisys.controller.FairyLightImplementor;

import java.util.List;

public class FairyLightList {
    private List<FairyLight> fairyLightList;
    private FairyLightImplementor implementor;

    public List<FairyLight> getFairyLightList() {
        return fairyLightList;
    }

    public void setImplementor(FairyLightImplementor implementor) {
        this.implementor = implementor;
    }
}
