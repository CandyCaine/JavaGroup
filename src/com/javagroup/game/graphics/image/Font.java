package com.javagroup.game.graphics.image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Font {

	private BufferedImage font;
	private final int fontSize = 70;
	private String characters;
	
	private static Font xfont = new Font();
	
	public static Font getFont(){
		return xfont;
	}
	
	private Font(){ 
		characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		try {
			font = ImageIO.read(Font.class.getResource("/lego_font.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int y = 0; y < font.getHeight(); y++) {
			for (int x = 0; x < font.getWidth(); x++) {
				if (font.getRGB(x, y) == 0xFFFF00FF) {
					font.setRGB(x, y, 0x00000000);
				}
			}
		}
	}
	
	public BufferedImage getLetters(String chars) {
		BufferedImage image = new BufferedImage(fontSize * chars.length(), fontSize, BufferedImage.TYPE_INT_ARGB);
		Graphics g = image.getGraphics();

		for (int i = 0; i < chars.length(); i++) {
			for (int j = 0; j < characters.length(); j++) {
                                if (characters.charAt(j) == chars.charAt(i)) {
					g.drawImage(font.getSubimage((j * fontSize), 0, fontSize, fontSize), (i * fontSize), 0, fontSize, fontSize, null);
				}
			}
		}
		g.dispose();
		return image;
	}
}
