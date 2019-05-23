package fr.unilim.iut.spaceinvaders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.Before;

import fr.unilim.iut.spaceinvaders.model.Dimensions;
import fr.unilim.iut.spaceinvaders.model.Position;
import fr.unilim.iut.spaceinvaders.model.SpaceInvaders;
import fr.unilim.iut.spaceinvaders.model.Collision;

public class CollisionTest {

	private SpaceInvaders spaceinvaders;

	@Before
	public void initialisation() {
		spaceinvaders = new SpaceInvaders(15, 10);
	}

	@Test
	public void test_detecterCollisionEntreDeuxSprites() {
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimensions(7, 2), new Position(5, 9), 2);
		spaceinvaders.tirerUnMissile(new Dimensions(3, 2), 2);
		spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimensions(7,2),new Position(5,1), 1);
		
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerMissile();
		
		 assertEquals(true, Collision.detecterCollision(spaceinvaders.recupererMissile().get(0), spaceinvaders.recupererEnvahisseur()));
	}
	@Test
	public void test_détectionColisionMissileHauteurEnvahisseur() {
		spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimensions(7, 2), new Position(5,1), 3);
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimensions(7, 2), new Position(5, 9), 2);
		spaceinvaders.tirerUnMissile(new Dimensions(3, 2), 2);
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerMissile();
	
		assertEquals(true, Collision.sprite1HauteurSprite2(spaceinvaders.recupererMissile().get(0), spaceinvaders.recupererEnvahisseur()));
	}

	@Test
	public void test_détectionColisionMissileCentreEnvahisseur() {
		spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimensions(7, 2), new Position(5,1), 3);
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimensions(7, 2), new Position(5, 9), 2);
		spaceinvaders.tirerUnMissile(new Dimensions(3, 2), 2);
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerMissile();
	
		assertEquals(true, Collision.sprite1DansSprite2(spaceinvaders.recupererMissile().get(0), spaceinvaders.recupererEnvahisseur()));
	}
	
	@Test
	public void test_détecttionColisionMissileGaucheBasEnvahisseur() {
		spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimensions(7, 2), new Position(5,1), 3);
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimensions(7, 2), new Position(2, 9), 2);
		spaceinvaders.tirerUnMissile(new Dimensions(3, 2), 2);
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerMissile();
	
		assertEquals(true, Collision.droiteSprite1DansSprite2(spaceinvaders.recupererMissile().get(0), spaceinvaders.recupererEnvahisseur()));
	}
	
	@Test
	public void test_détecttionColisionMissileDroiteBasEnvahisseur() {
		spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimensions(7, 2), new Position(5,1), 3);
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimensions(7, 2), new Position(8, 9), 2);
		spaceinvaders.tirerUnMissile(new Dimensions(3, 2), 2);
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerMissile();
	
		assertEquals(true, Collision.gaucheSprite1DansSprite2(spaceinvaders.recupererMissile().get(0), spaceinvaders.recupererEnvahisseur()));
	}
	
	@Test
	public void test_pasDeColisionMissileEnvahisseurDroite() {
		spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimensions(7, 2), new Position(2,1), 3);
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimensions(7, 2), new Position(8, 9), 2);
		spaceinvaders.tirerUnMissile(new Dimensions(3, 2), 2);
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerMissile();
	
		assertEquals(false, Collision.detecterCollision(spaceinvaders.recupererMissile().get(0), spaceinvaders.recupererEnvahisseur()));
	}
	
	@Test
	public void test_pasDeColisionMissileEnvahisseurGauche() {
		spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimensions(7, 2), new Position(8,1), 3);
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimensions(7, 2), new Position(2, 9), 2);
		spaceinvaders.tirerUnMissile(new Dimensions(3, 2), 2);
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerMissile();
	
		assertEquals(false, Collision.detecterCollision(spaceinvaders.recupererMissile().get(0), spaceinvaders.recupererEnvahisseur()));
	}

	@Test
	public void test_détecttionColisionMissileGaucheHautEnvahisseur() {
		spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimensions(7, 2), new Position(5,1), 3);
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimensions(7, 2), new Position(2, 9), 2);
		spaceinvaders.tirerUnMissile(new Dimensions(3, 2), 2);
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerEnvahisseurVersLaGauche();
	
		assertEquals(true, Collision.droiteSprite1DansSprite2(spaceinvaders.recupererMissile().get(0), spaceinvaders.recupererEnvahisseur()));
	}
	
	@Test
	public void test_détecttionColisionMissileDroiteHautEnvahisseur() {
		spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimensions(7, 2), new Position(5,1), 3);
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimensions(7, 2), new Position(8, 9), 2);
		spaceinvaders.tirerUnMissile(new Dimensions(3, 2), 2);
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerEnvahisseurVersLaDroite();
	
		assertEquals(true, Collision.gaucheSprite1DansSprite2(spaceinvaders.recupererMissile().get(0), spaceinvaders.recupererEnvahisseur()));
	}
	
}
