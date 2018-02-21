package helpers;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

import static org.lwjgl.opengl.GL11.*;

/**
 * This class will help with the nitty-gritty parts of opengl.
 * These parts include:
 * Creating a display;
 * Drawing Quads to the display;
 * Loading Textures;
 *
 */
public class Artist {

    // Screen width and height
    public static final int WIDTH = 1280, HEIGHT = 960;
    // title of the display
    public static final String TITLE = "Top Down 2D Game Outline";

    /**
     * Creates am orthographic display
     */
    public static void BeginSession(){
        // give the display a title bar
        Display.setTitle(TITLE);

        try {
            // sets the dimensions of the display
            Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));

            // show the display
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        // apply the following matrix operations to the projection stack
        glMatrixMode(GL_PROJECTION);

        // set matrix to its default location (identity matrix), no translations or rotations.
        glLoadIdentity();

        // make camera orthographic(2d, no perspective)
        glOrtho(0,WIDTH,HEIGHT,0,1,-1);

        // apply the following matrix operations to the projection stack
        glMatrixMode(GL_MODELVIEW);

        // enable us to draw textures to the screen
        glEnable(GL_TEXTURE_2D);

    }

    /**
     * Draws a simple rectangle to the screen
     * @param x starting x position of the rectangle
     * @param y starting y position of the rectangle
     * @param width width of rectangle
     * @param height height of rectangle
     */
    public static void DrawQuad(float x, float y, float width, float height){
        // quads are drawn in a clockwise direction starting from the top right coordinate

        glBegin(GL_QUADS); // the type of shape that we are drawing is a QUAD
        glVertex2f(x,y); // top left coordinate
        glVertex2f(x + width,y); // top right coordinate
        glVertex2f(x + width,y + height); // bottom right coordinate
        glVertex2f(x,y + height); // bottom left coordinate
        glEnd(); // we have finished marking all the corners of the quad
    }

    /**
     * Draws a texture to the screen
     * @param texture the texture that will be drawn
     * @param x the global x position of the texture
     * @param y the global y position of the texture
     * @param width the width of the texture
     * @param height the height of the texture
     */
    public static void DrawQuadTex(Texture texture, float x, float y, float width, float height){
        // all the following commands will be bound to this texture for the time being
        texture.bind();

        // move the texture to the following global x,y coordinate
        // (afterwards we work with local coordinates starting 0,0 in the top left)
        glTranslatef(x,y,0);

        glBegin(GL_QUADS);// the type of shape that we are drawing is a QUAD

        // glTexCoord2f sets where the texture will begin and end rendering [0,1]
        // glVertex2f sets the min and max coordinates of the texture on the screen(width and height)
        // note: the coordinates are in order starting with top left in a clockwise rotation, ending with bottom left

        // top left
        glTexCoord2f(0,0);
        glVertex2f(0,0);

        // top right
        glTexCoord2f(1,0);
        glVertex2f(width,0);

        // bottom right
        glTexCoord2f(1,1);
        glVertex2f(width,height);

        // bottom left
        glTexCoord2f(0,1);
        glVertex2f(0,height);

        // we are done drawing this texture, stop listing coordinates for this texture
        glEnd();

        glLoadIdentity(); // revert to original matrix, do not keep the modified glTranslatef for the next texture
    }

    /**
     * Loads a Texture object from a specified path
     * @param path the path to the image
     * @param fileType the image extension (png)
     * @return A Texture of the Image at the specified path
     */
    public static Texture LoadTexture(String path, String fileType){
        Texture texture = null;

        // loads the image as a stream
        InputStream in = ResourceLoader.getResourceAsStream(path);

        try {
            // converts the stream into a texture
            texture = TextureLoader.getTexture(fileType,in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return texture;
    }

    /**
     * Creates a texture given only the name of the texture
     * @param nameOfImage what the image is called
     * @return A texture of the image
     */
    public static Texture LoadTexture(String nameOfImage){
        return LoadTexture("res/"+nameOfImage+".png","PNG");
    }

}
