package data;

import static helpers.Artist.*;

public class TileGrid {
    public Tile[][] map;

    private int tileCols = 20;
    private int tileRows = 15;

    private int tileWidth = 64;
    private int tileHeight = 64;

    public TileGrid(){
        map = new Tile[tileCols][tileRows];
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                map[i][j] = new Tile(i * tileWidth, j * tileHeight, tileWidth, tileHeight, TileType.Grass);
            }
        }
    }

    public TileGrid(int[][] loadedMap){
        map = new Tile[tileCols][tileRows];

        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                switch (loadedMap[j][i]){
                    case 0:
                        map[i][j] = new Tile(i * tileWidth, j * tileHeight, tileWidth, tileHeight, TileType.Grass);
                        break;
                    case 1:
                        map[i][j] = new Tile(i * tileWidth, j * tileHeight, tileWidth, tileHeight, TileType.Dirt);
                        break;
                    case 2:
                        map[i][j] = new Tile(i * tileWidth, j * tileHeight, tileWidth, tileHeight, TileType.Water);
                        break;

                    default:
                        map[i][j] = new Tile(i * tileWidth, j * tileHeight, tileWidth, tileHeight, TileType.Default);
                        break;
                }
            }
        }
    }

    public void setTile(int x, int y, TileType tileType){
        map[x][y] = new Tile(x * tileWidth, y * tileHeight, tileWidth, tileHeight, tileType);
    }

    public Tile getTile(int x, int y){
        return map[x][y];
    }

    public void draw(){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                Tile t = map[i][j];
                DrawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHeight());
            }
        }
    }

}
