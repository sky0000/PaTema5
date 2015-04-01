
import javax.swing.JEditorPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
 
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
 






import java.net.URL;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

public class TreeDemo extends JPanel  {
	 private static boolean useSystemLookAndFeel = false;
    private JTree tree;
    private JEditorPane Panel;
    static ColectieFilme f= new ColectieFilme();
    public TreeDemo()
    {
    	tree= new JTree(createTree());
    	tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    	
    	Panel = new JEditorPane();
        Panel.setEditable(false);
        Panel.setFont(new Font("Consolas",Font.BOLD,13));
        
        
    	tree.addTreeSelectionListener(new TreeSelectionListener() {
    		public void valueChanged(TreeSelectionEvent e)
    		{
    			DefaultMutableTreeNode node= (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
    			
    			Object userObject=node.getUserObject();
    			
    			if(userObject.equals("Comedie"))  Panel.setText(f.toString("Comedie"));
    			else
    				if (userObject.equals("Romantica"))  Panel.setText(f.toStringGen("Romantica")); 
    				else if(userObject.equals("Tragicomedie"))  Panel.setText(f.toStringGen("Tragicomedie"));  
    				else if(userObject.equals("Action")) Panel.setText(f.toString("Action"));
    				else if(userObject.equals("Drama"))  Panel.setText(f.toStringGen("Drama")); 
    				else if(userObject.equals("Thriller"))  Panel.setText(f.toStringGen("Thriller")); 
    				else if(userObject.equals("Crime"))  Panel.setText(f.toStringGen("Crime"));
    				else if(userObject.equals("Western"))  Panel.setText(f.toStringGen("Western")); 
    				else if(userObject.equals("Aventure"))  Panel.setText(f.toString("Aventure")); 
    				else if (userObject.equals("Filme")) Panel.setText(f.toString());
    		}
    	});
    	
    	
    	

        JScrollPane panel = new JScrollPane(Panel);
    	setLayout(new BorderLayout());
    	JScrollPane treeView1 = new JScrollPane(tree);
    	 
    	
    	//Add the scroll panes to a split pane.
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(treeView1);
        splitPane.setBottomComponent(panel);
        splitPane.setBounds(850, 100, 500, 500);
 
        Dimension minimumSize = new Dimension(100, 400);
        panel.setMinimumSize(minimumSize);
        treeView1.setMinimumSize(minimumSize);
        splitPane.setDividerLocation(100); 
        splitPane.setPreferredSize(new Dimension(700, 600));
 
        //Add the split pane to this panel.
        add(splitPane);
    }
 
    
    public DefaultMutableTreeNode createTree()
    {
    	DefaultMutableTreeNode top= new DefaultMutableTreeNode("Filme");
    	//DefaultMutableTreeNode exit=new DefaultMutableTreeNode("Exit");
    	
    	DefaultMutableTreeNode branch1= new DefaultMutableTreeNode("Comedie");
    	DefaultMutableTreeNode server1= new DefaultMutableTreeNode("Romantica");
    	DefaultMutableTreeNode server2= new DefaultMutableTreeNode("Tragicomedie");
    	
    	DefaultMutableTreeNode branch2= new DefaultMutableTreeNode("Action");
    	DefaultMutableTreeNode server3= new DefaultMutableTreeNode("Drama");
    	DefaultMutableTreeNode server5= new DefaultMutableTreeNode("Crime");
    	DefaultMutableTreeNode server4= new DefaultMutableTreeNode("Thriller");
    	DefaultMutableTreeNode server6= new DefaultMutableTreeNode("Western");
    	
    	DefaultMutableTreeNode branch3= new DefaultMutableTreeNode("Aventure");
    	
    	branch1.add(server1);
    	branch1.add(server2);
    	
    	branch2.add(server3);
    	branch2.add(server4);
    	branch2.add(server5);
    	branch2.add(server6);
    	
    	top.add(branch1);
    	top.add(branch2);
    	top.add(branch3);
    	
    	return top;
	
    }
    static void createAndShowGUI() {
        if (useSystemLookAndFeel) {
            try {
                UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("Couldn't use system look and feel.");
            }
        }
        //Create and set up the window.
        JFrame frame = new JFrame("TreeDemo");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
 
        //Add content to the window.
        frame.add(new TreeDemo());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    	

}
    