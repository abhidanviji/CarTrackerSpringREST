package io.egen.rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Priority;
import org.easyrules.annotation.Rule;

@Rule(name = "Coolant Check Engine Light rule",
        description = "Checks for Engine Rule")
public class CoolantEngineRule {
    private boolean coolantLow;
    private boolean engineLight;
    private boolean passOrFail = false;

    @Condition
    public boolean checkPressure() {
        if(coolantLow||engineLight)
            return true;
        return false;
    }

    @Action
    public void chkPressure() throws Exception {
        setPassOrFail(true);
    }

    public boolean isPassOrFail() {
        return passOrFail;
    }

    public void setPassOrFail(boolean passOrFail) {
        this.passOrFail = passOrFail;
    }

    public void setInput(boolean coolantLow,boolean engineLight){
        this.coolantLow = coolantLow;
        this.engineLight = engineLight;
    }

    @Priority
    public int getPriority() {
        return 2;
    }
}
