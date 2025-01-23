package avaj;

import java.util.ArrayList;
import java.util.List;

public class Tower {

	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable p_Flyable)
	{
		observers.add(p_Flyable);
	}
	public void unregister(Flyable p_Flyable)
	{
		observers.remove(p_Flyable);
	}
	protected void conditionChanged()
	{
		for(int i = 0; i < observers.size(); i++)
		{
			observers.get(i).updateConditions();
		}
	}
}