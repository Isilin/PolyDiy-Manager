package logic.user;

import java.util.Collection;

import persistent.abstractclass.Category;
import persistent.abstractclass.Task;
import persistent.abstractclass.list.SetTask;
import persistent.factory.ActivityFactory;
import persistent.factory.CategoryFactory;
import persistent.factory.jdbc.JDBCActivityFactory;
import persistent.factory.jdbc.JDBCCategoryFactory;

public class TaskHandler {
	private SetTask tasks = null;
	private Task task = null;
	
	public TaskHandler() {
	}
	
	public void loadTasks(int idUser) throws Exception {
		ActivityFactory factory = new JDBCActivityFactory();
		this.tasks = factory.buildListTasksFromUser(idUser);
	}
	
	public void loadTask(int idTask) throws Exception {
		ActivityFactory factory = new JDBCActivityFactory();
		this.task = factory.buildTaskFromId(idTask);
	}
	
	public int getNumberOfTasks() {
		return this.tasks.count();
	}
	
	public Collection<Task> getTasks() {
		return this.tasks.getAllElements();
	}
	
	public Task getTask() {
		return this.task;
	}

	public Category getTaskCategory() throws Exception {
		CategoryFactory factory = new JDBCCategoryFactory();
		return factory.buildCategoryById(this.task.getIdCategory());
	}

	public void updateTask(String title, String category, int idUser) throws Exception {
		this.task.setIdCategory(1); // TODO a changer
		this.task.setIdActivity(1); // TODO a changer
		this.task.setIdUser(idUser);
		this.task.setTitle(title);
		if(this.task.getIdTask() == -1) {
			this.task.insert();
		} else {
			this.task.update();
		}
		
	}

	public void deleteTask() throws Exception {
		if(this.task.getIdTask() != -1) {
			this.task.delete();
		}
	}
}
