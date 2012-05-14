package com.javagroup.game.graphics.image;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.HashMap;


public class Art {
	
	private static HashMap<Integer, Texture> textures = new HashMap<Integer, Texture>();
	private static SpriteSheet tileSheet;

	public static void init() {
		
	}
	
	/**
	 * Creates a GraphicsConfiguration object
	 * @return Returns the GraphicsConfiguration object
	 */
	public static GraphicsConfiguration getConfig() {
		GraphicsConfiguration config = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		return config;
	}
	
	/**
	 * Creates a new image in a screen compatible format
	 * @param width Width of the new image
	 * @param height Height of the new image
	 * @param transparency Transparency of the new image
	 * @return Returns the new BufferedImage
	 */
	public static BufferedImage createCompatibleImage(int width, int height, int transparency) {
		BufferedImage image = getConfig().createCompatibleImage(width, height, transparency);
		return image;
	}
	
	/**
	 * Converts an image to a screen compatible format
	 * @param src Image to be converted
	 * @return Returns the converted image
	 */
	public static BufferedImage toCompatibleImage(BufferedImage src) {
		BufferedImage image = createCompatibleImage(src.getWidth(), src.getHeight(), Transparency.TRANSLUCENT);
		Graphics g = image.getGraphics();
		g.drawImage(src, 0, 0, src.getWidth(), src.getHeight(), null);
		g.dispose();
		return image;
	}
	
	/**
	 * Returns a the texture specified by the id
	 * @param id Cell number of the image
	 * @return Returns the image
	 */
	public static Texture getTextureByID(int id) {
		if (textures.get(id) == null) {
			textures.put(id, new Texture(id));
		}
		
		return textures.get(id);
	}
	
	public static SpriteSheet getTileSheet() {
		return tileSheet;
	}
}
