package dev.smirnov.crudspringproject.model;

import java.io.Serializable;

/**
 * @author pavelsmirnov
 */
public class TestBD implements Serializable {
    private int x;
    private int y;
    String str;

    public TestBD() {
    }

    public TestBD(int x, int y, String str) {
        this.x = x;
        this.y = y;
        this.str = str;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
