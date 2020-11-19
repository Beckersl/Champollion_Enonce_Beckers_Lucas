package champollion;

import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
        Salle s;
        Intervention inter,inter2,inter3;
        Date today;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");
                s = new Salle("b102",30);
                today = new Date();
                inter = new Intervention(s, uml, untel, today,2, TypeIntervention.CM );
                inter2 = new Intervention(s, uml, untel, today,3, TypeIntervention.TD  );
                inter3 = new Intervention(s, uml, untel, today,4, TypeIntervention.TP  );
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
        @Test
        public void testHeuresPrevues(){
            untel.ajouteEnseignement(uml, 0, 10, 0);
            untel.ajouteEnseignement(java, 2, 10, 0);
            
            assertEquals(23 , untel.heuresPrevues(),"L'enseignant doit avoir 23 heures prévues au total");
        }
        @Test
        public void testAjouteIntervention(){
            untel.ajouteIntervention(inter);
            untel.ajouteIntervention(inter2);
            untel.ajouteIntervention(inter3);
            
            assertEquals( 2+3+4, untel.heuresPlannifiees(),"L'enseignant doit avoir 9 heures planifiées au total");
        }
        @Test
        public void testEnSousServiceTrue(){
            untel.ajouteIntervention(inter);
            untel.ajouteIntervention(inter2);
            untel.ajouteIntervention(inter3);
            
            untel.ajouteEnseignement(uml, 2, 0, 4);
            untel.ajouteEnseignement(java, 0, 3, 0);
            
            assertTrue(untel.enSousService());
        }
        @Test
        public void testEnSousServiceFalce(){
            untel.ajouteIntervention(inter);
            untel.ajouteIntervention(inter2);
            untel.ajouteIntervention(inter3);
            
            untel.ajouteEnseignement(uml, 2, 6, 4);
            
            assertFalse(untel.enSousService());
        }
        
	
}
