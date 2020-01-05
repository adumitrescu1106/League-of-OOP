package champions;

import abilities.Visitor;


import java.util.ArrayList;

public class Champion implements Visitable {
    private int hp;
    private int xp;
    private int level;
    private int xPosition;
    private int yPosition;
    private int paralysis;
    private int overtimeDuration;
    private String overtimeType;
    private int overtimeDmg;
    private Character position;
    private int backstabIndex;
    private int damageDeflect;
    private String state;
    private boolean fight;
    private float kFirstModifier;
    private float kSecondModifier;
    private float pFirstModifier;
    private float pSecondModifier;
    private float rFirstModifier;
    private float rSecondModifier;
    private float wFirstModifier;
    private float wSecondModifier;

    public Champion() {
        this.xp = 0;
        this.level = 0;
    }

    public Champion(final int x, final int y, final ArrayList<ArrayList<Character>> arena) {
        this.xp = 0;
        this.level = 0;
        this.paralysis = 0;
        this.xPosition = x;
        this.yPosition = y;
        this.position = arena.get(x).get(y);
        this.overtimeDuration = 0;
        this.backstabIndex = 0;
        this.overtimeDmg = 0;
        this.overtimeType = "nimic";
        this.damageDeflect = 0;
        this.state = "alive";
        this.fight = true;
        this.kFirstModifier = 0;
        this.kSecondModifier = 0;
        this.pFirstModifier = 0;
        this.pSecondModifier = 0;
        this.rFirstModifier = 0;
        this.rSecondModifier = 0;
        this.wFirstModifier = 0;
        this.wSecondModifier = 0;
    }

    public final Character getPosition() {
        return position;
    }

    public final void setPosition(final Character position) {
        this.position = position;
    }

    public final int getParalysis() {
        return paralysis;
    }

    public final void setParalysis(final int paralysis) {
        this.paralysis = paralysis;
    }

    public final int getHp() {
        return hp;
    }
    public final int getXp() {
        return xp;
    }

    public final int getLevel() {
        return level;
    }

    public final void setLevel(final int level) {
        this.level = level;
    }

    public final void setHp(final int hp) {
        this.hp = hp;
    }
    public void levelUp() {
    }

    public final void setXp(final int xp) {
        this.xp = xp;
    }

    public final int getxPosition() {
        return xPosition;
    }

    public final void setxPosition(final int xPosition) {
        this.xPosition = xPosition;
    }

    public final int getyPosition() {
        return yPosition;
    }

    public final void setyPosition(final int yPosition) {
        this.yPosition = yPosition;
    }

    public final void takeDmg(final int dmg) {
        this.setHp(this.getHp() - dmg);
    }

    public final void heal(final int heal) {
        this.setHp(this.getHp() + heal);
    }

    public final int getOvertimeDuration() {
        return overtimeDuration;
    }

    public final void setOvertimeDuration(final int overtimeEffect) {
        this.overtimeDuration = overtimeEffect;
    }

    public final String getOvertimeType() {
        return overtimeType;
    }

    public final void setOvertimeType(final String overtimeType) {
        this.overtimeType = overtimeType;
    }

    public final int getBackstabIndex() {
        return backstabIndex;
    }

    public final void setBackstabIndex(final int backstabIndex) {
        this.backstabIndex = backstabIndex;
    }

    public final int getOvertimeDmg() {
        return overtimeDmg;
    }

    public final void setOvertimeDmg(final int overtimeDmg) {
        this.overtimeDmg = overtimeDmg;
    }

    public final int getdamageDeflect() {
        return damageDeflect;
    }

    public final void setdamageDeflect(final int damageDeflected) {
        this.damageDeflect = damageDeflected;
    }

    public final void resetdamageDeflect() {
        this.damageDeflect = 0;
    }

    public final void addDamageDeflect(final int damage) {
        this.damageDeflect = this.damageDeflect + damage;
    }

    public final int getDamageDeflect() {
        return damageDeflect;
    }

    public final void setDamageDeflect(final int damageDeflect) {
        this.damageDeflect = damageDeflect;
    }

    public final String getState() {
        return state;
    }

    public final void setState(final String state) {
        this.state = state;
    }

    public final boolean isFight() {
        return fight;
    }

    public final void setFight(final boolean fight) {
        this.fight = fight;
    }

    public final float getkFirstModifier() {
        return kFirstModifier;
    }

    public final void setkFirstModifier(float kFirstModifier) {
        this.kFirstModifier = kFirstModifier;
    }

    public final float getkSecondModifier() {
        return kSecondModifier;
    }

    public final void setkSecondModifier(float kSecondModifier) {
        this.kSecondModifier = kSecondModifier;
    }

    public final float getpFirstModifier() {
        return pFirstModifier;
    }

    public final void setpFirstModifier(float pFirstModifier) {
        this.pFirstModifier = pFirstModifier;
    }

    public final float getpSecondModifier() {
        return pSecondModifier;
    }

    public final void setpSecondModifier(float pSecondModifier) {
        this.pSecondModifier = pSecondModifier;
    }

    public final float getrFirstModifier() {
        return rFirstModifier;
    }

    public final void setrFirstModifier(float rFirstModifier) {
        this.rFirstModifier = rFirstModifier;
    }

    public final float getrSecondModifier() {
        return rSecondModifier;
    }

    public final void setrSecondModifier(float rSecondModifier) {
        this.rSecondModifier = rSecondModifier;
    }

    public final float getwFirstModifier() {
        return wFirstModifier;
    }

    public final void setwFirstModifier(float wFirstModifier) {
        this.wFirstModifier = wFirstModifier;
    }

    public final float getwSecondModifier() {
        return wSecondModifier;
    }
    public final void increaseKfirst(float increase) {
        this.setkFirstModifier(this.getkFirstModifier() + increase);
    }
    public final void increaseKsecond(float increase) {
        this.setkSecondModifier(this.getkSecondModifier() + increase);
    }
    public final void increaseRfirst(float increase) {
        this.setrFirstModifier(this.getrFirstModifier() + increase);
    }
    public final void increaseRsecond(float increase) {
        this.setrSecondModifier(this.getrSecondModifier() + increase);
    }
    public final void increasePfirst(float increase) {
        this.setpFirstModifier(this.getpFirstModifier() + increase);
    }
    public final void increasePsecond(float increase) {
        this.setpSecondModifier(this.getpSecondModifier() + increase);
    }
    public final void increaseWfirst(float increase) {
        this.setwFirstModifier(this.getwFirstModifier() + increase);
    }
    public final void increaseWsecond(float increase) {
        this.setwSecondModifier(this.getwSecondModifier() + increase);
    }
    public final void increaseAll(float percentage) {
        this.increaseKfirst(percentage);
        this.increaseKsecond(percentage);
        this.increasePfirst(percentage);
        this.increasePsecond(percentage);
        this.increaseRfirst(percentage);
        this.increaseRsecond(percentage);
        this.increaseWfirst(percentage);
        this.increaseWsecond(percentage);
    }

    public final void decreaseAll(float percentage) {
        this.decreaseKfirst(percentage);
        this.decreaseKsecond(percentage);
        this.decreasePfirst(percentage);
        this.decreasePsecond(percentage);
        this.decreaseRfirst(percentage);
        this.decreaseRsecond(percentage);
        this.decreaseWfirst(percentage);
        this.decreaseWsecond(percentage);
    }
    public final void decreaseKfirst(float decrease) {
        this.setkFirstModifier(this.getkFirstModifier() - decrease);
    }
    public final void decreaseKsecond(float decrease) {
        this.setkSecondModifier(this.getkSecondModifier() - decrease);
    }
    public final void decreaseRfirst(float decrease) {
        this.setrFirstModifier(this.getrFirstModifier() - decrease);
    }
    public final void decreaseRsecond(float decrease) {
        this.setrSecondModifier(this.getrSecondModifier() - decrease);
    }
    public final void decreasePfirst(float decrease) {
        this.setpFirstModifier(this.getpFirstModifier() - decrease);
    }
    public final void decreasePsecond(float decrease) {
        this.setpSecondModifier(this.getpSecondModifier() - decrease);
    }
    public final void decreaseWfirst(float decrease) {
        this.setwFirstModifier(this.getwFirstModifier() - decrease);
    }
    public final void decreaseWsecond(float decrease) {
        this.setwSecondModifier(this.getwSecondModifier() - decrease);
    }

    public final void setwSecondModifier(float wSecondModifier) {
        this.wSecondModifier = wSecondModifier;
    }

    // pentru get-ul tipului de erou, initializat in constructorii claselor lo
    public String getType() {
        return "a";
    }
    public String getLongType() {
        return "a";
    }
    @Override
    public void accept(final Visitor v) {

    }

    // functie pentru add experience (dupa o batalie)
    public final void addXp(final int xpGained) {
        this.xp = this.xp + xpGained;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "hp=" + hp +
                ", xp=" + xp +
                ", level=" + level +
                ", xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", paralysis=" + paralysis +
                ", overtimeDuration=" + overtimeDuration +
                ", overtimeType='" + overtimeType + '\'' +
                ", overtimeDmg=" + overtimeDmg +
                ", position=" + position +
                ", backstabIndex=" + backstabIndex +
                ", damageDeflect=" + damageDeflect +
                ", state='" + state + '\'' +
                ", fight=" + fight +
                ", kFirstModifier=" + kFirstModifier +
                ", kSecondModifier=" + kSecondModifier +
                ", pFirstModifier=" + pFirstModifier +
                ", pSecondModifier=" + pSecondModifier +
                ", rFirstModifier=" + rFirstModifier +
                ", rSecondModifier=" + rSecondModifier +
                ", wFirstModifier=" + wFirstModifier +
                ", wSecondModifier=" + wSecondModifier +
                '}';
    }
}
