package fr.unilim.iut.spaceinvaders.model;

public class Collision {
	private Sprite sprite1;
	private Sprite sprite2;
	
	
	
	public Collision(Sprite sprite1, Sprite sprite2) {
		super();
		this.sprite1 = sprite1;
		this.sprite2 = sprite2;
	}

	public static boolean detecterCollision(Sprite sprite1, Sprite sprite2) {
		if (sprite1DansSprite2(sprite1, sprite2)) {
			return true;
		}
		return false;
	}

	public static boolean sprite1DansSprite2(Sprite sprite1, Sprite sprite2) {
		return touchertAGauche(sprite1, sprite2) || toucherADroite(sprite1, sprite2);
	}

	private static boolean toucherADroite(Sprite sprite1, Sprite sprite2) {
		return sprite1HauteurSprite2(sprite1,sprite2) && gaucheSprite1DansSprite2(sprite1, sprite2);
	}

	private static boolean touchertAGauche(Sprite sprite1, Sprite sprite2) {
		return sprite1HauteurSprite2(sprite1,sprite2) && droiteSprite1DansSprite2(sprite1, sprite2);
	}

	public static boolean gaucheSprite1DansSprite2(Sprite sprite1, Sprite sprite2) {
		return (sprite2.abscisseLaPlusADroite() > sprite1.abscisseLaPlusAGauche()) && (sprite2.abscisseLaPlusAGauche() < sprite1.abscisseLaPlusAGauche());
	}

	public static boolean droiteSprite1DansSprite2(Sprite sprite1, Sprite sprite2) {
		return (sprite2.abscisseLaPlusADroite() > sprite1.abscisseLaPlusADroite()) && (sprite2.abscisseLaPlusAGauche() < sprite1.abscisseLaPlusADroite());
	}

	public static boolean sprite1HauteurSprite2(Sprite sprite1, Sprite sprite2) {
		if (sprite1.ordonneeLaPlusBasse() <= sprite2.ordonneeLaPlusHaute() && sprite1.ordonneeLaPlusBasse() >= sprite2.ordonneeLaPlusBasse()) 
			return true;
		return false;
	}
}
