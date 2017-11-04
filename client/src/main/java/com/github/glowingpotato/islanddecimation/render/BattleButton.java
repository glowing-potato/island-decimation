package com.github.glowingpotato.islanddecimation.render;

import java.io.IOException;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class BattleButton extends Renderer {
    private Texture log;
    
    @Override
    public void render() {
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glColor3d(0.46, 0.09, 1);
        GL11.glVertex2d(0, 0);
        GL11.glVertex2d(1, 0);
        GL11.glVertex2d(1, 0.1);
        GL11.glVertex2d(0, 0.1);
        log.bind();
        GL11.glVertex2d(0, 0);
        GL11.glVertex2d(0, 0.1);
        GL11.glVertex2d(0.1, 0.1);
        GL11.glVertex2d(0.1, 0);
        GL11.glEnd();
    }
    
    public BattleButton() throws IOException {
        this.log = TextureLoader.getTexture("PNG", ClassLoader.getSystemResourceAsStream("log.png"));
    }
}
