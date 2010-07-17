/**
 * 
 */
package taskmodule.task;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import taskmodule.TaskModuleException;
import taskmodule.datamodel.DataObject;
import taskmodule.preconditions.bool.IPreCondition;
import taskmodule.util.Tree;

import java.util.Collection;


/**
 * @author Assaf
 *
 */
public class Task implements ITask, Serializable {

	private static final long serialVersionUID = -4370497749552969051L;

	private String taskName;
	private UUID taskId;
	private Tree<String> taskLayout;
	private Map<String,IPreCondition> preconditionAxioms;
	private Map<Tree<String>, IPreCondition> dynamicConditions;

	public Tree<String> getTaskLayout() {
		return taskLayout;
	}

	public void setTaskLayout(Tree<String> taskLayout) {
		this.taskLayout = taskLayout;
	}
	
	public Task(Tree<String> taskLayout, 
			Map<String, IPreCondition> preconditionAxioms, Map<Tree<String>, IPreCondition> dynamicConditions) {
		this.taskLayout = taskLayout;
		this.preconditionAxioms = preconditionAxioms;
		this.dynamicConditions = dynamicConditions;
	}
	
	public Task(String name) {
		
		this.taskName = name;
		this.taskLayout = new Tree<String>(null);
		this.preconditionAxioms = new HashMap<String, IPreCondition>();
	}
	
	public Map<String, IPreCondition> getPreconditions() {
		return preconditionAxioms;
	}

	public void addPreconditions( String activity, IPreCondition precondition) {
		this.preconditionAxioms.put(activity, precondition);
	}

	public void setName(String taskName) {
		this.taskName = taskName;
	}

	public UUID getTaskId() {
		return taskId;
	}

	public void setTaskId(UUID taskId) {
		this.taskId = taskId;
	}

	@Override
	public JTree getDescription() {
        DefaultMutableTreeNode root = 
                mutableTreeNodeFromTree(taskLayout.getHead(),taskLayout);

        return new JTree(root);
	}

	@Override
	public String getName() {
		return taskName;
	}
	
	public Map<Tree<String>, IPreCondition> getDynamicConditions() {
		return dynamicConditions;
	}
	
	public boolean checkPreCondition(String activity) throws TaskModuleException {
		if (null == activity){
			throw new NullPointerException();
		}
		
		if (!preconditionAxioms.containsKey(activity)){
			return true;
		}
		
		//TODO see if check can be changed not to return Object
		return (Boolean)preconditionAxioms.get(activity).check();
	}
	
	public boolean containsPreCondition(String activity) {
		if (null == activity) 
			throw new NullPointerException();

		return preconditionAxioms.containsKey(activity);
	}
	
    @Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof DataObject)) {
			return false;
		}
		
		Task tobj = (Task)obj;
		
		if (taskName.equals(tobj.getName()) &&
			taskId.equals(tobj.taskId)) {
			return true;
		}
		return false;
	}

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.taskName != null ? this.taskName.hashCode() : 0);
        hash = 29 * hash + (this.taskId != null ? this.taskId.hashCode() : 0);
        return hash;
    }

    private DefaultMutableTreeNode mutableTreeNodeFromTree
            (String root, Tree<String> tree) {

    	String visibleStrOnly = root.substring(0, (root.indexOf("hidden:") != -1 ? root.indexOf("hidden:") : root.length()));
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(visibleStrOnly);
        Collection<String> successors = tree.getSuccessors(root);

        if (null == successors || successors.isEmpty()) {
            return top;
        }

        for (String successor : successors) {
            DefaultMutableTreeNode leaf = mutableTreeNodeFromTree(successor, tree);
            top.add(leaf);
        }

        return top;
    }
    
    @Override
    public String toString() {
    	return (null != taskName ? taskName : "New task");
    }
}
