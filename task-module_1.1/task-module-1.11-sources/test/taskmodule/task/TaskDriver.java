/**
 * 
 */
package taskmodule.task;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.TreeSelectionModel;

/**
 * Driver for Task getDescription() JTree testing.
 * @author Assaf
 *
 */
public class TaskDriver extends JPanel
						implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = -645174805813369069L;
    
    private static JTree jtree = null;
	private static boolean useSystemLookAndFeel = false;
	/**
	 * 
	 */
	public TaskDriver(JTree jtree) {
		super(new BorderLayout());
		
		jtree.getSelectionModel().setSelectionMode
		(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		JScrollPane treeView = new JScrollPane(jtree);
		treeView.setPreferredSize(new Dimension(200, 200));
		
		add(treeView);
	}
	
	public void actionPerformed(ActionEvent ae) {
		//no-op
	}
	
	private static void createAndShowGUI() {
		if (null == jtree) return;
		if (useSystemLookAndFeel) {
			try {
				UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				System.err.println("Couldn't use system look and feel.");
			}
		}
		
		JFrame frame = new JFrame("TaskDriver");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		TaskDriver newContentPane = new TaskDriver(jtree);
		newContentPane.setOpaque(true);
		frame.add(newContentPane);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void testFlight(JTree jtree_) {
		jtree = jtree_;
		try {
			javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					createAndShowGUI();
				}
			});
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println("Press Any Key to display next..!");
//		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
//		try {
//			stdin.read();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
