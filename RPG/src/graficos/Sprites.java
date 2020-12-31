package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprites {
	private final int ancho;
	private final int alto;
	public final int[] pixeles;

	// Fondos
	public static Sprites fondo1 = new Sprites("/texturas/fondo1.png", 832, 640);
	public static Sprites fondo2 = new Sprites("/texturas/fondo2.png", 832, 640);
	// Animaciones
	// Fuego
	public static Sprites fuego0 = new Sprites("/texturas/anim/fuego0.png", 64, 64);
	public static Sprites fuego1 = new Sprites("/texturas/anim/fuego1.png", 64, 64);
	public static Sprites fuego2 = new Sprites("/texturas/anim/fuego2.png", 64, 64);
	public static Sprites fuego3 = new Sprites("/texturas/anim/fuego3.png", 64, 64);
	public static Sprites fuego4 = new Sprites("/texturas/anim/fuego4.png", 64, 64);
	public static Sprites fuego5 = new Sprites("/texturas/anim/fuego5.png", 64, 64);
	public static Sprites fuego6 = new Sprites("/texturas/anim/fuego6.png", 64, 64);
	public static Sprites fuego7 = new Sprites("/texturas/anim/fuego7.png", 64, 64);
	public static Sprites fuego8 = new Sprites("/texturas/anim/fuego8.png", 64, 64);
	public static Sprites fuego9 = new Sprites("/texturas/anim/fuego9.png", 64, 64);
	public static Sprites fuego10 = new Sprites("/texturas/anim/fuego10.png", 64, 64);
	public static Sprites fuego11 = new Sprites("/texturas/anim/fuego11.png", 64, 64);
	public static Sprites fuego12 = new Sprites("/texturas/anim/fuego12.png", 64, 64);
	public static Sprites fuego13 = new Sprites("/texturas/anim/fuego13.png", 64, 64);
	public static Sprites fuego14 = new Sprites("/texturas/anim/fuego14.png", 64, 64);

	// Fin de la colecci�n

	public Sprites(final String ruta, final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;

		pixeles = new int[ancho * alto];

		BufferedImage imagen;

		try {
			imagen = ImageIO.read(Sprites.class.getResourceAsStream(ruta));
			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int getAncho() {
		return ancho;
	}

}