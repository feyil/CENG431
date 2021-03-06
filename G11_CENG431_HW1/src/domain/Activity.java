package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Activity {

	private int number;
	private String description;
	private String startDate;
	private String deliverable;
	private List<Task> taskList;
	
	
	public Activity(String aDescription, String aStartDate, String aDeliverable) {
		setDescription(aDescription);
		setStartDate(aStartDate);
		setDeliverable(aDeliverable);
		setTaskList(new ArrayList<Task>());

	}
	
	public void addTask(Activity activity,String tDescription,String tStartDate,int tHours) {
		Task task = new Task(tDescription,tStartDate,tHours);
		assignNumber(activity,task);
		activity.getTaskList().add(task);
	}
	
	public void assignNumber(Activity activity,Task task) {
		int tNumber;
		if(activity.getTaskList().size() != 0) {
			tNumber = activity.getTaskList().get(-1).getNumber();
		}
		else {
			tNumber = 0;
		}
		
		task.setNumber(tNumber+1);
	}
	
	public List<Task> getTaskList() {
		return taskList;
	}
	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int aNumber) {
		this.number = aNumber;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDeliverable() {
		return deliverable;
	}
	public void setDeliverable(String deliverable) {
		this.deliverable = deliverable;
	}
	public int getHours() //Iterate in tasklist and return total duration
	{
		return 0;
	}
	public int calculateActivity() {
		int totalHours = 0;
		for(int i = 0; i < getTaskList().size(); i++) {
			totalHours += getTaskList().get(i).calculateTask();
		}
		System.out.println("Activity total hour:" + totalHours);
		return totalHours;
	}
	
	public int calculateTask(int tId) {
		return findTask(tId).calculateTask();
	}
	
	public Task findTask(int tId) {
		for(int i = 0; i < getTaskList().size(); i++) {
			Task tmp = getTaskList().get(i);
			if(tmp.getNumber() == tId) {
				return tmp;
			}
		}
		return null;
	}

	public Task assignResource(Project project,int aNum,int tNum,int rId) {
		Task task = null;
		for(int i=0;i<this.getTaskList().size();i++) {
			if(this.getTaskList().get(i).getNumber() == tNum) {
				task = this.getTaskList().get(i);
			}
		}
		task.assignResource(rId);
		
		return task;
	}
	
	public Task unassignResource(Project project,int aNum,int tNum,int rId) {
		Task task = null;
		for(int i=0;i<this.getTaskList().size();i++) {
			if(this.getTaskList().get(i).getNumber() == tNum) {
				task = this.getTaskList().get(i);
			}
		}
		task.unassignResource(rId);
		
		return task;
	}
	
	public Set<Integer> countActivityResouce() {
		Set<Integer> rId = new HashSet<Integer>();
		for(int i = 0; i < getTaskList().size(); i++) {	
			rId.add(getTaskList().get(i).countTaskResource());
		}
		return rId;
	}
	
	public int countTaskResource(int tId) {
		return findTask(tId).countTaskResource();
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[" + this.getNumber() + "," + this.getDescription() + "," + this.getStartDate() + "," + this.getDeliverable() + "," + this.getHours() + " : ");  
		for(int i=0;i<this.getTaskList().size();i++) {
			str.append("\n\t\t" + this.getTaskList().get(i).toString());
		}
		
		return str.toString(); 
	}
	
	
}
