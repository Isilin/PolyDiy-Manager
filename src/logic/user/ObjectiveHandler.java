package logic.user;

import java.util.Collection;

import persistent.abstractclass.Category;
import persistent.abstractclass.Objective;
import persistent.abstractclass.list.SetObjective;
import persistent.factory.ActivityFactory;
import persistent.factory.CategoryFactory;
import persistent.factory.jdbc.JDBCActivityFactory;
import persistent.factory.jdbc.JDBCCategoryFactory;

public class ObjectiveHandler {
	private SetObjective objectives = null;
	private Objective objective = null;
	
	public ObjectiveHandler() {
	}
	
	public void loadObjectives(int idUser) throws Exception {
		ActivityFactory factory = new JDBCActivityFactory();
		this.objectives = factory.buildListObjectivesFromUser(idUser);
	}
	
	public void loadObjective(int idObjective) throws Exception {
		ActivityFactory factory = new JDBCActivityFactory();
		this.objective = factory.buildObjectiveFromId(idObjective);
	}
	
	public int getNumberOfObjectives() {
		return this.objectives.count();
	}
	
	public Collection<Objective> getObjectives() {
		return this.objectives.getAllElements();
	}
	
	public Objective getObjective() {
		return this.objective;
	}

	public Category getObjectiveCategory() throws Exception {
		CategoryFactory factory = new JDBCCategoryFactory();
		return factory.buildCategoryById(this.objective.getIdCategory());
	}

	public void updateObjective(String title,String description, String deadline,
								String category, int idUser) throws Exception {
		this.objective.setTitle(title);
		this.objective.setDescription(description);
		this.objective.setDeadline(deadline);
		this.objective.setFacultativIdActivity(1); // TODO a changer
		this.objective.setIdCategory(1); // TODO a changer
		this.objective.setIdUser(idUser);
		if(this.objective.getIdObjective() == -1) {
			this.objective.insert();
		} else {
			this.objective.update();
		}
		
	}

	public void deleteObjective() throws Exception {
		if(this.objective.getIdObjective() != -1) {
			this.objective.delete();
		}
	}
}
