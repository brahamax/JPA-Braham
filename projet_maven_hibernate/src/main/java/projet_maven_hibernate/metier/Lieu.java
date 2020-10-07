package projet_maven_hibernate.metier;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

	@Entity
	public class Lieu {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id; // (Clé primaire)
		private String nom;
		@OneToMany
		private Collection<Formation> formation;
		// Getters et Setters
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public Collection<Formation> getFormation() {
			return formation;
		}
		public void setFormation(Collection<Formation> formation) {
			this.formation = formation;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		
		// Constructeur
		public Lieu(String nom) {
			super();
			this.nom = nom;
		}
	}
