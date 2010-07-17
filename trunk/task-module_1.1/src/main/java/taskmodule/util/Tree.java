/**
 * 
 */
package taskmodule.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


/**
 * @author Assaf
 *
 * @param <T>
 *          Object's type in the tree.
 */
public class Tree<T> implements Serializable {

	private static final long serialVersionUID = 6471979703472859197L;

	private T head;

	private ArrayList<Tree<T>> leafs = new ArrayList<Tree<T>>();

	private Tree<T> parent = null;

	private HashMap<T, Tree<T>> locate = new HashMap<T, Tree<T>>();
	
	public Tree(T head) {
		this.head = head;
		locate.put(head, this);
	}

	public void addLeaf(T root, T leaf) {
		if (locate.containsKey(root)) {
			locate.get(root).addLeaf(leaf);
		} else {
			addLeaf(root).addLeaf(leaf);
		}
	}

	public Tree<T> addLeaf(T leaf) {
		Tree<T> t = new Tree<T>(leaf);
		leafs.add(t);
		t.parent = this;
		t.locate = this.locate;
		locate.put(leaf, t);
		return t;
	}

	public boolean addSubTree(Tree<T> subtree) {
		if (null == subtree || this == subtree ||
				subtree.locate.containsKey(head)) {
			return false;
		}
		subtree.setAsParent(this);
		return true;
	}
	
	public Tree<T> setAsParent(Tree<T> parent) {
        if (!parent.leafs.contains(this)) {
            parent.leafs.add(this);
        }

		this.parent = parent;
        parent.locate.putAll(this.locate);

        if (!parent.locate.containsKey(this.head)) {
            parent.locate.put(head, this);
        }

        if (!parent.locate.containsKey(parent.head)) {
            parent.locate.put(parent.head, parent);
        }
		
		return parent;
	}

	public T getHead() {
		return head;
	}

	public Tree<T> getTree(T element) {
		return locate.get(element);
	}

	public Tree<T> getParent() {
		return parent;
	}

	public Collection<T> getSuccessors(T root) {
		Collection<T> successors = new ArrayList<T>();
		Tree<T> tree = getTree(root);
		if (null != tree) {
			for (Tree<T> leaf : tree.leafs) {
				successors.add(leaf.head);
			}
		}
		return successors;
	}

	public Collection<Tree<T>> getSubTrees() {
		return leafs;
	}

	public static <T> Collection<T> getSuccessors(T of, Collection<Tree<T>> in) {
		for (Tree<T> tree : in) {
			if (tree.locate.containsKey(of)) {
				return tree.getSuccessors(of);
			}
		}
		return new ArrayList<T>();
	}

	@Override
	public String toString() {
		return printTree(0);
	}

	private static final int indent = 2;

	private String printTree(int increment) {
		String s = "";
		String inc = "";
		for (int i = 0; i < increment; ++i) {
			inc = inc + " ";
		}
		s = inc + head;
		for (Tree<T> child : leafs) {
			s += "\n" + child.printTree(increment + indent);
		}
		return s;
	}
	
	// Need to supply an empty list of T's
	public void getBottomLeafs(List<T> bottomLeafs) {
		if(this.leafs.size() == 0) {
			bottomLeafs.add(this.head);
			return;
		}

		for (Tree<T> child : leafs) {
			child.getBottomLeafs(bottomLeafs);
		}
	}
	
	
	public boolean containsNode(T key) {
		return locate.containsKey(key);
	}
	
	public Tree<T> getSubTree(T key) {
		return locate.get(key);
	}
	
	public Tree<T> clone() {
		Tree<T> ret = new Tree<T>(this.head);
		
		if (leafs.isEmpty()) {
			return ret;
		}
		
		for (Tree<T> subtree : leafs) {
			ret.addSubTree(subtree.clone());
		}
		
		ret.parent = this.parent;
		return ret;
	}
}
