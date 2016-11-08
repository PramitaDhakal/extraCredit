package DataAccessObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Project {
	@Id
	@GeneratedValue
	private int id;
	private String projectName;
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	
	@OneToMany(mappedBy = "project")
	private List<Beneficiary> listOfBeneficiary = new ArrayList<Beneficiary>();
	
	@ElementCollection
	@OneToMany(mappedBy = "assignedProject")
	private List<Task> listOfTasks = new ArrayList<Task>();
	
	@Lob
	private byte[] image;
	
	@Enumerated(EnumType.STRING)
	private Status projectStatus;
	
	
	@OneToMany(mappedBy = "userProject")
	private List<User> userOfProject;	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Beneficiary> getListOfBeneficiary() {
		return listOfBeneficiary;
	}

	public void setListOfBeneficiary(List<Beneficiary> listOfBeneficiary) {
		this.listOfBeneficiary = listOfBeneficiary;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Status getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(Status projectStatus) {
		this.projectStatus = projectStatus;
	}

	public List<Task> getListOfTasks() {
		return listOfTasks;
	}

	public void setListOfTasks(List<Task> listOfTasks) {
		this.listOfTasks = listOfTasks;
	}

	public List<User> getUserOfProject() {
		return userOfProject;
	}

	public void setUserOfProject(List<User> userOfProject) {
		this.userOfProject = userOfProject;
	}
	
	
	
	

}
