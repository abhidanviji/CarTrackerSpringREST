package io.egen.rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Priority;
import org.easyrules.annotation.Rule;

@Rule(name = "TirePressure rule",
        description = "Checks for Vehicle TirePressure")
public class TirePressureRule {
    private int tireFL;
    private int tireFR;
    private int tireRL;
    private int tireRR;
    private boolean passOrFail = false;

    @Condition
    public boolean checkPressure() {
        if(tireRR<32||tireRR>32||tireRL<32||tireRL>32||tireFR<32||tireFR>32||tireFL<32||tireFL>32)
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

    public void setInput(int tireFL, int tireFR, int tireRL, int tireRR){
        this.tireFL = tireFL;
        this.tireFR = tireFR;
        this.tireRL = tireRL;
        this.tireRR = tireRR;
    }

    @Priority
    public int getPriority() {
        return 2;
    }
}
