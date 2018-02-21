package data;

import org.newdawn.slick.opengl.Texture;

import static helpers.Artist.*;

/**
 * Holds general Tile data
 */
public class Tile {
    private float x, y;
    private float width, height;
    private TileType type; // attributes of the tile
    private Texture texture;

    /**
     * Set Essential information of the tile
     * @param x global x position of tile
     * @param y global y position of tile
     * @param width width of tile
     * @param height height of tile
     * @param type the type of tile we are working with (dirt, grass, water, etc...)
     */
    public Tile(float x, float y, float width, float height, TileType type){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
        this.texture = LoadTexture(type.textureName);
    }

    /**
     * Draws the tile to the screen at its current x,y location
     */
    public void draw(){
        DrawQuadTex(texture,x,y,width,height);
    }


    /*
    Getters and Setters
     */

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }
}
