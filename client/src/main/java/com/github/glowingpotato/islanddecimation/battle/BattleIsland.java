package com.github.glowingpotato.islanddecimation.battle;

import com.github.glowingpotato.islanddecimation.world.User;
import com.glutilities.util.Vertex3;

public class BattleIsland {
    private int id;
    private User user;
    private Battle battle;
    private Vertex3 position;
    private String code;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Battle getBattle() {
        return battle;
    }
    public void setBattle(Battle battle) {
        this.battle = battle;
    }
    public Vertex3 getPosition() {
        return position;
    }
    public void setPosition(Vertex3 position) {
        this.position = position;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
}
