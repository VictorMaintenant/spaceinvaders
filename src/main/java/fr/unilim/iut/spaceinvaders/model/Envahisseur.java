package fr.unilim.iut.spaceinvaders.model;

public class Envahisseur extends Sprite {
	
	private String direction;

	public Envahisseur(Dimensions dimension, Position positionOrigine, int vitesse) {
		super(dimension, positionOrigine, vitesse);
		this.direction="droite";
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String sensDeDeplacement() {
		return direction;
	}

	
}

