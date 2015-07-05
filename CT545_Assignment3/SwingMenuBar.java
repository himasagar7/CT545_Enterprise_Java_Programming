package assignment3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SwingMenuBar extends JFrame{
	
	private static final long serialVersionUID = 1L;
	public SwingMenuBar() throws Exception {
        super("Menu");
        setSize(200, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar mb = new JMenuBar();
        // create menu
        JMenu mnuFile = new JMenu("File");
        mb.add(mnuFile);
        
     // options in File Menu
        JMenuItem option = new JMenuItem("Open");
        option.setAccelerator( KeyStroke.getKeyStroke("F5"));
        mnuFile.add(option);
        option.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });
             setJMenuBar(mb);

}
	// Method is used to implement user selection of file from any path in computer
	  public void openFile() {
		   JFileChooser chooser = new JFileChooser();
		  int returnVal = chooser.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    	//PersonsManager.readFromFile(chooser.getSelectedFile());
		    	ListPersons p = new ListPersons(chooser.getSelectedFile());
		    	p.setVisible(true);
		    	
		    }
		        
	        
	    }
}
