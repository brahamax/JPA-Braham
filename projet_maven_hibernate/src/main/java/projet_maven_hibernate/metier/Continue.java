package projet_maven_hibernate.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Continue extends Formation {
private String rythme;
	public Continue(String theme,String rythme) {
		super(theme);
		this.rythme=rythme;
	}
	public String getRythme() {
		return rythme;
	}
	public void setRythme(String rythme) {
		this.rythme = rythme;
	}

}

