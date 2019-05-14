package fr.unilim.iut.spaceinvaders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import fr.unilim.iut.spaceinvaders.model.Dimensions;
import fr.unilim.iut.spaceinvaders.model.Position;
import fr.unilim.iut.spaceinvaders.model.Vaisseau;
import fr.unilim.iut.spaceinvaders.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.MissileException;

public class VaisseauTest {

	 @Test(expected = MissileException.class)
		public void test_LongueurMissileSuperieureALongueurVaisseau_UneExceptionEstLevee() throws Exception {
			Vaisseau vaisseau = new Vaisseau(new Dimensions(5,2),new Position(5,9), 1);
			vaisseau.tirerUnMissile(new Dimensions(7,2),1);
		}
}
