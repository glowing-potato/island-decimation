package com.github.glowingpotato.islanddecimation.battle;

public class Battle {
    private int id;
    private long time;
    private int winnerID;
    public Battle(int id, long time, int winnerID) {
	this.id = id;
	this.time = time;
	this.winnerID = winnerID;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    public int getWinnerID() {
        return winnerID;
    }
    public void setWinnerID(int winnerID) {
        this.winnerID = winnerID;
    }
}
