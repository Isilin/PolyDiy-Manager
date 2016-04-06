package persistent.abstractclass.list;

import common.set.SetWithKey;
import persistent.abstractclass.Objective;
import persistent.common.InterfaceModel;

/**
 * an aggregate of Objective accessible by keys
 * @author loicd_000
 *
 */
public abstract class SetObjective extends SetWithKey<Objective>implements InterfaceModel {
	protected int idUser = -1;

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}
