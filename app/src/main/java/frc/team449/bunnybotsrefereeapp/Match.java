package frc.team449.bunnybotsrefereeapp;

public class Match {

    private int redFouls;
    private int blueFouls;
    private int redTechFouls;
    private int blueTechFouls;
    private int matchNum;

    private final int TECH_FOUL_PENALTY = 20;
    private final int FOUL_PENALTY = 5;

    public Match(int matchNum) {
        this.redFouls = 0;
        this.blueFouls = 0;
        this.redTechFouls = 0;
        this.blueTechFouls = 0;
        this.matchNum = matchNum;
    }

    public int getRedFouls() {
        return redFouls;
    }

    public void setRedFouls(int redFouls) {
        this.redFouls = redFouls;
    }

    public int getBlueFouls() {
        return blueFouls;
    }

    public void setBlueFouls(int blueFouls) {
        this.blueFouls = blueFouls;
    }

    public int getRedTechFouls() {
        return redTechFouls;
    }

    public void setRedTechFouls(int redTechFouls) {
        this.redTechFouls = redTechFouls;
    }

    public int getBlueTechFouls() {
        return blueTechFouls;
    }

    public void setBlueTechFouls(int blueTechFouls) {
        this.blueTechFouls = blueTechFouls;
    }

    public int getBlueFoulPoints() {
        return this.blueFouls * FOUL_PENALTY + this.blueTechFouls * TECH_FOUL_PENALTY;
    }

    public int getRedFoulPoints() {
        return this.redFouls * FOUL_PENALTY + this.redTechFouls * TECH_FOUL_PENALTY;
    }

    public String toString() {
        return "Match " + this.matchNum;
    }
}
