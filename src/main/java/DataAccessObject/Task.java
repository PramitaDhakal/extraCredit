package DataAccessObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Task {

	@Id
	@GeneratedValue
	private int taskId;

	@Enumerated(EnumType.STRING)
	private Status taskStaus;

	@ManyToOne
	private Project assignedProject;

	@OneToMany(mappedBy = "forTask")
	private List<Resource> listOfResources = new ArrayList<Resource>();

	@Temporal(TemporalType.TIME)
	private Date taskStartDate;

	@Temporal(TemporalType.TIME)
	private Date taskEndDate;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public List<Resource> getListOfResources() {
		return listOfResources;
	}

	public void setListOfResources(List<Resource> listOfResources) {
		this.listOfResources = listOfResources;
	}

	public Date getTaskStartDate() {
		return taskStartDate;
	}

	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public Date getTaskEndDate() {
		return taskEndDate;
	}

	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}

	public Status getTaskStaus() {
		return taskStaus;
	}

	public void setTaskStaus(Status taskStaus) {
		this.taskStaus = taskStaus;
	}

	public Project getAssignedProject() {
		return assignedProject;
	}

	public void setAssignedProject(Project assignedProject) {
		this.assignedProject = assignedProject;
	}

}
