package edu.arf4.motivationbalance.model.enums;

public enum FactorStatus {
    ACTIVE, REMOVED;

    public FactorStatus getOpposite() {
        return this.name().equals(ACTIVE.name())
                ? REMOVED : ACTIVE;
    }
}
