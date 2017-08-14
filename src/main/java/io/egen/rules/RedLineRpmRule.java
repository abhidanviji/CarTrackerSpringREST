package io.egen.rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Priority;
import org.easyrules.annotation.Rule;

@Rule(name = "RedLineRpm rule",
        description = "Checks for Vehicle RedLineRpm")
public class RedLineRpmRule {

    private int currRpm;
    private int vehicleRpm;
    private boolean passOrFail = false;

    @Condition
    public boolean checkRpm() {
        if(currRpm > vehicleRpm)
            return true;
        return false;
    }

    @Action
    public void chkRpm() throws Exception {
        setPassOrFail(true);
    }

    public boolean isPassOrFail() {
        return passOrFail;
    }

    public void setPassOrFail(boolean passOrFail) {
        this.passOrFail = passOrFail;
    }

    public void setInput(int currRpm, int vehicleRpm){
        this.currRpm = currRpm;
        this.vehicleRpm = vehicleRpm;
    }

    @Priority
    public int getPriority() {
        return 0;
    }


}
