package DataAccessObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Resource {
	
	@Id
	@GeneratedValue
	private int resourceId;
	
	private String resourceName;
	
	@ManyToOne
	private Task forTask;

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public Task getForTask() {
		return forTask;
	}

	public void setForTask(Task forTask) {
		this.forTask = forTask;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
	
}
