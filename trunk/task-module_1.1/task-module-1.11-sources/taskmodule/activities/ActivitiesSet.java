/**
 * 
 */
package taskmodule.activities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Assaf
 *
 */
public class ActivitiesSet implements Set<String> {

	private Set<String> activitiesSet = new HashSet<String>(); 
	private static ActivitiesSet instance = null;
	
	private ActivitiesSet() {
	}
	
	public static ActivitiesSet getInstance() {
		if (null == instance) {
			instance = new ActivitiesSet();
		}
		return instance;
	}
	
	@Override
	public boolean add(String t) {
		return activitiesSet.add(t);
	}
	
	@Override
	public boolean addAll(Collection<? extends String> c) {
		return activitiesSet.addAll(c);
	}
	
	@Override
	public void clear() {
		activitiesSet.clear();
	}
	
	@Override
	public boolean contains(Object o) {
		return activitiesSet.contains(o);
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
		return activitiesSet.containsAll(c);
	}
	
	@Override
	public boolean isEmpty() {
		return activitiesSet.isEmpty();
	}
	@Override
	public Iterator<String> iterator() {
		return activitiesSet.iterator();
	}
	@Override
	public boolean remove(Object o) {
		return activitiesSet.remove(o);
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		return activitiesSet.removeAll(c);
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		return activitiesSet.retainAll(c);
	}
	
	@Override
	public int size() {
		return activitiesSet.size();
	}
	@Override
	public Object[] toArray() {
		return activitiesSet.toArray();
	}
	
	@Override
	public <T> T[] toArray(T[] a) {
		return activitiesSet.toArray(a);
	}
	
	public String get(String actvty) throws ActivityNotSupportedException {
		Iterator<String> iter = activitiesSet.iterator();
		while (iter.hasNext()) {
			String currentActivity = iter.next();
			if (currentActivity.equals(actvty)) {
				return currentActivity;
			}
		}
		
		throw new ActivityNotSupportedException("Unknown activity: " + actvty);
	}
}
