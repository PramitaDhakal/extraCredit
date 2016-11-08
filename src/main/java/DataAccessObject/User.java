package DataAccessObject;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int userId;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Role hasRole;
	
	@ManyToOne
	private Project userProject;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getHasRole() {
		return hasRole;
	}

	public void setHasRole(Role hasRole) {
		this.hasRole = hasRole;
	}

	public Project getAssignedProject() {
		return userProject;
	}

	public void setAssignedProject(Project userProject) {
		this.userProject = userProject;
	}
	
	

}
