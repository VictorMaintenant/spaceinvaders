package fr.unilim.iut.spaceinvaders.model;

public class Collision {
	
	public static boolean detecterCollision(Sprite missile, Sprite envahisseur) {
		if (missileDansEnvahisseur(missile, envahisseur)) {
			return true;
		}
		return false;
	}

	public static boolean missileDansEnvahisseur(Sprite missile, Sprite envahisseur) {
		return leMissileEstAHauteurDeLEnvahisseur(missile,envahisseur) && (droiteDuMissileDansEnvahisseur(missile, envahisseur)
				|| leMissileEstAHauteurDeLEnvahisseur(missile,envahisseur) && gaucheDuMissileDansEnvahisseur(missile, envahisseur));
	}

	public static boolean gaucheDuMissileDansEnvahisseur(Sprite missile, Sprite envahisseur) {
		return (envahisseur.abscisseLaPlusADroite() > missile.abscisseLaPlusAGauche()) && (envahisseur.abscisseLaPlusAGauche() < missile.abscisseLaPlusAGauche());
	}

	public static boolean droiteDuMissileDansEnvahisseur(Sprite missile, Sprite envahisseur) {
		return (envahisseur.abscisseLaPlusADroite() > missile.abscisseLaPlusADroite()) && (envahisseur.abscisseLaPlusAGauche() < missile.abscisseLaPlusADroite());
	}

	public static boolean leMissileEstAHauteurDeLEnvahisseur(Sprite missile, Sprite envahisseur) {
		if (missile.ordonneeLaPlusBasse() < envahisseur.ordonneeLaPlusHaute()) 
			return true;
		return false;
	}
}
