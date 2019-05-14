package fr.unilim.iut.spaceinvaders.model;

import fr.unilim.iut.spaceinvaders.utils.MissileException;

public class Vaisseau extends Sprite {

	public Vaisseau(Dimensions dimension, Position positionOrigine, int vitesse) {
		super(dimension, positionOrigine, vitesse);
	}

	public Missile tirerUnMissile(Dimensions dimensionMissile, int vitesseMissile) {
		if(this.dimension.longueur < dimensionMissile.longueur) {
			throw new MissileException("La longueur du missile est supérieure à celle du vaisseau.");
		}
		Position positionOrigineMissile = calculerLaPositionDuTirDuMissile(dimensionMissile);
		return new Missile(dimensionMissile, positionOrigineMissile, vitesseMissile);
			
		
	}

	private Position calculerLaPositionDuTirDuMissile(Dimensions dimensionMissile) {
		int abscisseMilieuVaisseau = this.abscisseLaPlusAGauche() + (this.longueur() / 2);
		int abscisseOrigineMissile = abscisseMilieuVaisseau - (dimensionMissile.longueur() / 2);

		int ordonneeeOrigineMissile = this.ordonneeLaPlusBasse() - 1;
		Position positionOrigineMissile = new Position(abscisseOrigineMissile, ordonneeeOrigineMissile);
		return positionOrigineMissile;
	}
}