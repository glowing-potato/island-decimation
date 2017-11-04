package com.github.glowingpotato.islanddecimation.world.island;

import com.github.glowingpotato.islanddecimation.world.User;

public class Island {
    private int id;
    private User user;
    private Terrain shape;
    private int[] resources = new int[3];
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
    public Terrain getShape() {
        return shape;
    }
    public void setShape(Terrain shape) {
        this.shape = shape;
    }
    public int[] getResources() {
        return resources;
    }
    public void setResources(int[] resources) {
        this.resources = resources;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
}
