package io.egen.rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Priority;
import org.easyrules.annotation.Rule;

@Rule(name = "Fuel Volume rule",
        description = "Checks for Fuel Volume Level")
public class FuelVolumeRule {
    private double currFuelLevel;
    private double vehicleMaxFuel;
    private boolean passOrFail = false;

    @Condition
    public boolean checkFuel() {
        if(currFuelLevel < (vehicleMaxFuel * 0.1))
            return true;
        return false;
    }

    @Action
    public void chkFuel() throws Exception {
        setPassOrFail(true);
    }

    public boolean isPassOrFail() {
        return passOrFail;
    }

    public void setPassOrFail(boolean passOrFail) {
        this.passOrFail = passOrFail;
    }

    public void setInput(double currFuelLevel, double vehicleMaxFuel){
        this.currFuelLevel = currFuelLevel;
        this.vehicleMaxFuel = vehicleMaxFuel;
    }

    @Priority
    public int getPriority() {
        return 1;
    }


}