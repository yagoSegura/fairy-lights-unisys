package com.unisys.controller.impl;

import com.unisys.controller.IFairyLightImplementor;
import com.unisys.model.FairyLightList;

import java.util.concurrent.*;

public class AlternateAlgorithm implements IFairyLightImplementor {

    public static final int TIMEOUT = 30;

    public void connectFairyLightSet(FairyLightList fairyLightList) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> futureSequence = executor.submit(new FairyLightTask(fairyLightList,new SequenceAlgorithm()));
        Future<Integer> futureColour = executor.submit(new FairyLightTask(fairyLightList,new ColourAlgorithm()));

        try{
            futureSequence.get(TIMEOUT,TimeUnit.SECONDS);
        }catch(TimeoutException e){
            try {
                futureColour.get(TIMEOUT,TimeUnit.SECONDS);
            } catch (InterruptedException e1) {
            } catch (ExecutionException e1) {
            } catch (TimeoutException e1) {
            }
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }
    }

    private class FairyLightTask implements java.util.concurrent.Callable<Integer> {
        private FairyLightList fairyLightList;
        private IFairyLightImplementor implementor;

        public FairyLightTask(FairyLightList fairyLightList,IFairyLightImplementor implementor){
            this.fairyLightList = fairyLightList;
            this.implementor = implementor;
        }
        public Integer call() {
            while(true) {
                implementor.connectFairyLightSet(fairyLightList);
            }
        }
    }
}
