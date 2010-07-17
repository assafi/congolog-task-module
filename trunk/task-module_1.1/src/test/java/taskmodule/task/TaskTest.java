/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package taskmodule.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.swing.JTree;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import taskmodule.util.Tree;

/**
 *
 * @author sogood
 */
public class TaskTest {

    private static Tree<String> tree = null;
    @BeforeClass
    public static void setUpClass() throws Exception {
        tree = new Tree<String>("Label - 1");

        Tree<String> subtree1 = new Tree<String>("Sublabel - 1");
        subtree1.addLeaf("Activity a");
        subtree1.addLeaf("Activity b");
        Tree<String> subtree2 = new Tree<String>("Sublabel - 2");
        subtree2.addLeaf("Activity c");

        tree.addSubTree(subtree1);
        tree.addSubTree(subtree2);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setName method, of class Task.
     */
    @Test
    public void testSetName() {
        ITask task = new Task(tree,null,null);
        task.setName("Task 1");
        assertEquals("Task 1", task.getName());
    }

    /**
     * Test of getDescription method, of class Task.
     */
    @Test
    public void testGetDescription() throws Exception {
        Task task = new Task(tree,null,null);
        task.setName("Task 1");
        JTree description = task.getDescription();
        assertNotNull(description);
        TaskDriver.testFlight(description);
    }
}