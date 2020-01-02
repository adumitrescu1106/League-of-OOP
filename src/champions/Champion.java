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

    // pentru get-ul tipului de erou, initializat in constructorii claselor lo
    public String getType() {
        return "a";
    }

    @Override
    public void accept(final Visitor v) {

    }

    // functie pentru add experience (dupa o batalie)
    public final void addXp(final int xpGained) {
        this.xp = this.xp + xpGained;
    }
}
