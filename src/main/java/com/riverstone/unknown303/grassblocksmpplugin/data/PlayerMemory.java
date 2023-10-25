package com.riverstone.unknown303.grassblocksmpplugin.data;

public class PlayerMemory {
    private int lives = 7;
    private boolean banned = false;

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;

    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }
}
