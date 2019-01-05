package com.zerulus.game.entity;

import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.util.AABB;
import com.zerulus.game.util.Vector2f;
import com.zerulus.game.util.TileCollision;

import java.awt.Graphics2D;

public abstract class GameObject {

    protected Sprite sprite;
    protected AABB bounds;
    protected Vector2f pos;
    protected int size;
    protected int spriteX;
    protected int spriteY;

    protected float dx;
    protected float dy;

    protected float maxSpeed = 4f;
    protected float acc = 2f;
    protected float deacc = 0.3f;
    protected float force = 25f;
    
    protected boolean teleported = false;
    protected TileCollision tc;

    public GameObject(Sprite sprite, Vector2f origin, int spriteX, int spriteY, int size) {
        this.bounds = new AABB(origin, size, size);
        this.sprite = sprite;
        this.pos = origin;
        this.size = size;
    }

    public void setPos(Vector2f pos) { 
        this.pos = pos;
        this.bounds = new AABB(pos, size, size);
        teleported = true;
    }
    public void setSprite(Sprite sprite) { this.sprite = sprite; }
    public void setSize(int i) { size = i; }
    public void setMaxSpeed(float f) { maxSpeed = f; }
    public void setAcc(float f) { acc = f; }
    public void setDeacc(float f) { deacc = f; }


    public float getDeacc() { return deacc; }
    public float getAcc() { return acc; }
    public float getMaxSpeed() { return maxSpeed; }
    public float getDx() { return dx; }
    public float getDy() { return dy; }
    public AABB getBounds() { return bounds; }
    public int getSize() { return size; }

    public void addForce(float a, boolean vertical) {
        if(!vertical) {
            dx -= a; 
        } else {
            dy -= a;
        }
    }

    public void update() {

    }

    public void render(Graphics2D g) {
        g.drawImage(sprite.getSprite(spriteX, spriteY, size, size), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
    }

}