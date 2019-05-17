package fr.unilim.iut.spaceinvaders.model;

public class Collision {
	
	private boolean touche;
	
	public Collision () {
		this.touche = false;
	}

	public boolean isTouche() {
		return this.touche;
	}

	public void setTouche(boolean touche) {
		this.touche = touche;
	}
	
	
}
