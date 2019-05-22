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
		
		 assertEquals(true, Collision.detecterCollision(spaceinvaders.recupererMissile(), spaceinvaders.recupererEnvahisseur()));
	}
}
