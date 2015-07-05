package assignment3;

import java.awt.Container;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;

import assignment3.PersonsManager.PersonRecord;

public class ListPersons extends JFrame{

	private static final long serialVersionUID = 1L;

	public ListPersons(File path) {
	        super("List Of Persons");

	        Container c = getContentPane();

	      //To define the table heading 
	        Vector<String> headings = new Vector<String>();
	        headings.add("Forename");
	        headings.add("Surname");
	        headings.add("street");
	        headings.add("houseNumber");
	        headings.add("city");
	        headings.add("emailAddress");
	        
	        // To define the table rows
	        Vector<Vector<String>> rows = new Vector<Vector<String>>();
	         List<PersonRecord> list = new ArrayList<PersonRecord>();
	         // Returns list after reading from file
	             list = PersonsManager.readFromFile(path);
	        //TreeMap<String,String> words = Dictionary.getWords();
	        //for(String word :  words.keySet()) {
	         for(PersonRecord item :  list) {
	             Vector<String> row= new Vector<String>();
	             row.add(item.getForeName());
	             row.add(item.getSurName());
	             row.add(item.getHouseNumber());
	             row.add(item.getStreet());
	             row.add(item.getCity());
	             row.add(item.getEmailAddress());
	             //row.add( words.get(word));
	             rows.add(row);
	        }

	        JTable wordstable = new JTable(rows,headings);

	        JScrollPane sp = new JScrollPane(wordstable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	        c.add(sp);
	        pack(); // get requried size based on components
	    }

}
