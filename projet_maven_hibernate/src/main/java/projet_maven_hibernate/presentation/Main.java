package projet_maven_hibernate.presentation;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import projet_maven_hibernate.metier.Alternance;
import projet_maven_hibernate.metier.Continue;
import projet_maven_hibernate.metier.Formation;
import projet_maven_hibernate.metier.Lieu;

public class Main {

	public static void main(String[] args) {
		// 1 : Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-pu");
		EntityManager em = emf.createEntityManager();
		
		// 2 : Ouverture transaction 
		// Transaction: une échange -> soit tout réussi soit rien ne se passe entre le begin et le commit
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		
		// 3 : Instanciation Objet métier
		Formation formation = new Formation("JPA");
		Lieu lieu = new Lieu("ENSUP");
		Collection<Formation> c =new ArrayList<Formation>();
		c.add(formation);
		lieu.setFormation(c);
		formation.setLieu(lieu);
		Formation formationb = new Alternance("JPAA","2 semaine");
		Formation formationc = new Continue("JPAAA","3 semaine");
		// 4 : Persistance Objet/Relationnel : création d'un enregistrement en base
		 em.persist(formation);
		 em.persist(lieu);
		 em.persist(formationb);
		 em.persist(formationc);
		// 5 : Fermeture transaction 
		 tx.commit();
		
		// 6 : Fermeture unité de travail JPA 
		em.close();
		emf.close();
	}
}
