package data;

/**
 * Holds list of tiles and their attributes
 *
 * Note: when adding a new tile, it needs to be imported to:
 * 1. be imported to the res folder
 * 2. listed under the enum TileType below
 * 3. added to the TileGrid constructor switch statement;
 */
public enum TileType {
    // These are the different types of tiles that can be drawn
    Default("Default",false),       // id = default
    Grass("grass",true),            // id = 0
    Dirt("dirt",false),             // id = 1
    Water("water",false);           // id = 2

    String textureName;
    boolean buildable;

    /**
     * Create a drawable texture
     * @param textureName the texture neam
     * @param buildable can towers be built on this tile?
     */
    TileType(String textureName, boolean buildable){
        this.textureName = textureName;
        this.buildable = buildable;
    }
}
