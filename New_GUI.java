package trial;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;

/////////////////////////////////////////////////////////////////////////////////

public class New_GUI extends JFrame implements ActionListener 
{
/////////////////////////////////////////////////////////////////////////////////

	CompetitorsManager cm = new CompetitorsManager();
	CompetitorsList compList = new CompetitorsList();

/////////////////////////////////////////////////////////////////////////////////

	JFrame frameMain = new JFrame();
	//This is for SubFrame2
	static JTextArea displayList;
	JTextArea details = new JTextArea(7, 30);
	JScrollPane scroll = new JScrollPane(details);
	
	//This is for SubFrame3
	JButton listByID = new JButton("List By ID");
	JButton listByName = new JButton("List By Name");
	JButton listByOS = new JButton("List By Overall Score");
	JTextArea categoryText2 = new JTextArea(20, 30);
	JScrollPane scroll3 = new JScrollPane(categoryText2);
	
	//This is for SubFrame4
	JButton swimmer = new JButton("Swimming");
	JButton chess = new JButton("Chess");
	JButton gaming = new JButton("Gaming");
	JButton basketball = new JButton("Basketball");
	JTextArea categoryText = new JTextArea(20, 30);
	JScrollPane scroll2 = new JScrollPane(categoryText);

/////////////////////////////////////////////////////////////////////////////////

	JTextField idF = new JTextField(5);
	JTextField searchtf = new JTextField(10);
	JLabel result = new JLabel("");

	JTextField scorestf = new JTextField(10);

	static JFrame newframe = new JFrame();
	static JFrame newframe2 = new JFrame();
	static JFrame newframe3 = new JFrame();
	static JFrame newframe4 = new JFrame();

	JButton search = new JButton("Search");
	JTextField searchField = new JTextField(5);
	JTextField ostf = new JTextField(10);
	JLabel nameF = new JLabel("");
	JButton update = new JButton("Update");
	JButton showFullDetail = new JButton("Show Full Details");
	JButton showShortDetail = new JButton("Show Short Details");
	
	JButton viewScores = new JButton("View and Update Scores");
	JButton viewTables = new JButton("View Sorted Tables");
	JButton viewDetails = new JButton("View Details");
	JButton searchDetails = new JButton("View by Category");
	JButton closeTxt = new JButton("Close and Save Text File");

/////////////////////////////////////////////////////////////////////////////////

	public void showMainWindow() 
	{
		//Read the relevant files.
		compList.readFile("Khaled.csv");
		compList.readFile_Minu("Minu.csv");
		compList.readFile_Rayan("Rayan.csv");
		compList.readFile_Aiysha("Aisha.csv");
		
		// Call the Main Frame.
		setupMainFrame();
	}

/////////////////////////////////////////////////////////////////////////////////

	//FRAME MAIN
	private void setupMainFrame()
	{
		
		frameMain.setSize(200, 200);
		frameMain.setLocation(600, 200);
		frameMain.setLayout(new GridLayout(5, 0, 10, 10));

		frameMain.add(viewScores);
		frameMain.add(viewDetails);
		frameMain.add(viewTables);
		frameMain.add(searchDetails);
		frameMain.add(closeTxt);
		
		viewScores.addActionListener(this);
		viewTables.addActionListener(this);
		viewDetails.addActionListener(this);
		searchDetails.addActionListener(this);
		closeTxt.addActionListener(this);

	    // mainframe.setSize(400,200);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.setTitle("Main");
		frameMain.setVisible(true);
		frameMain.pack();
	}

/////////////////////////////////////////////////////////////////////////////////

	// SubFrame 1: View and Update Scores of a Competitor.

	private void setupSubFrame1North() 
	{
		// search panel contains label, text field and button
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new GridLayout(2, 2));
		searchPanel.add(new JLabel("Enter ID"));

		searchPanel.add(searchField);
		// JLabel result = new JLabel("");
		result.setForeground(Color.RED);
		searchPanel.add(result);

		searchPanel.add(search);
		// specify action when button is pressed
		search.addActionListener(this);
		//newframe.setLocationRelativeTo(frameMain);
		newframe.add(searchPanel, BorderLayout.NORTH);
		newframe.setLocation(800, 200);
		newframe.setVisible(true);
		newframe.pack();
	}

	private void setupSubFrame1South() 
	{
		String name_comp = "";
		// Set up the area where the results will be displayed.
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5, 2));
		JLabel idL = new JLabel("ID");
		centerPanel.add(idL);

		idF.setEditable(false);
		centerPanel.add(idF);

		JLabel nameL = new JLabel("Name");
		centerPanel.add(nameL);

		centerPanel.add(nameF);

		JLabel scores = new JLabel("Scores");
		centerPanel.add(scores);

		JScrollPane scrollList;
		scrollList = new JScrollPane(displayList);

		// JTextField scorestf = new JTextField(10);
		scorestf.setEditable(true);
		centerPanel.add(scorestf);

		JLabel dummy = new JLabel("");
		centerPanel.add(dummy);

		update.addActionListener(this);
		update.setEnabled(false);
		centerPanel.add(update);

		JLabel os = new JLabel("Overall Score");
		centerPanel.add(os);
		// JTextField ostf = new JTextField(10);
		ostf.setEditable(false);

		centerPanel.add(ostf);

		// add south panel to the content pane
		newframe.add(centerPanel, BorderLayout.SOUTH);
		newframe.setVisible(true);
		newframe.setTitle("View and Update");
		newframe.pack();
	}

/////////////////////////////////////////////////////////////////////////////////

	//Sub Frame 2: Full and Short details.
	
	public void setupSubFrame2North(){
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new GridLayout(2, 2));

		// 1,1
		JLabel searchL = new JLabel("Search");
		searchPanel.add(searchL);

		// 1,2
		searchtf.setEditable(true);
		searchPanel.add(searchtf);

		// 2,1
		showShortDetail.addActionListener(this);
		// showShortDetail.setEnabled(false);
		searchPanel.add(showShortDetail);

		// 2,2
		showFullDetail.addActionListener(this);
		// showFullDetail.setEnabled(false);
		searchPanel.add(showFullDetail);

		newframe2.setLocation(820, 220);
		newframe2.add(searchPanel, BorderLayout.NORTH);
		newframe2.setVisible(true);
	}

	public void setupSubFrame2South()
	{
		JPanel searchPanel = new JPanel();

		searchPanel.add(scroll);
		newframe2.add(searchPanel, BorderLayout.SOUTH);
		newframe2.setVisible(true);
		newframe2.setTitle("View Details");
		newframe2.pack();

	}

/////////////////////////////////////////////////////////////////////////////////

	//List by id, name and overall score
	public void setupSubFrame3North()
	{
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(2, 2));
		
		JLabel selectL = new JLabel("Select: ");
		gridPanel.add(selectL);
		
		gridPanel.add(listByID);
		gridPanel.add(listByName);
		gridPanel.add(listByOS);

		listByID.addActionListener(this);
		listByName.addActionListener(this);
		listByOS.addActionListener(this);
		
		newframe3.add(gridPanel, BorderLayout.NORTH);
		newframe3.setLocation(233, 200);
		newframe3.pack();
		newframe3.setTitle("Sorted Lists");
		newframe3.setVisible(true);
		
		
	}
	
	public void setupSubFrame3South()
	{
		JPanel textPanel = new JPanel();

		textPanel.add(scroll3);
		newframe3.add(textPanel, BorderLayout.SOUTH);
		newframe3.setVisible(true);
		newframe3.pack();
	}
	
/////////////////////////////////////////////////////////////////////////////////

	//Sub Frame 3: List by Category.
	public void setupSubFrame4North()
	{
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(3, 2));
		
		JLabel selectL = new JLabel("Select: ");
		gridPanel.add(selectL);

		JLabel emptyL = new JLabel("");
		gridPanel.add(emptyL);
		
		gridPanel.add(swimmer);
		gridPanel.add(chess);
		gridPanel.add(gaming);
		gridPanel.add(basketball);

		swimmer.addActionListener(this);
		chess.addActionListener(this);
		gaming.addActionListener(this);
		basketball.addActionListener(this);
		
		newframe4.add(gridPanel, BorderLayout.NORTH);
		newframe4.setLocation(203, 220);
		newframe4.pack();
		newframe4.setTitle("Sort By Category");
		newframe4.setVisible(true);
	}
	
	public void setupSubFrame4South()
	{
		JPanel textPanel = new JPanel();
		
		textPanel.add(scroll2);
		newframe4.add(textPanel, BorderLayout.SOUTH);
		newframe4.setVisible(true);
		newframe4.pack();
	}
/////////////////////////////////////////////////////////////////////////////////

	private void update() 
	{
		// get search text and search staff list (will be found)
		String searchString = searchField.getText().trim();
		Super_Competitor compSup = compList.findById(Integer.parseInt(searchString));
		String[] newScore = scorestf.getText().split(",");
		String[] co = new String[5];
		System.arraycopy(newScore, 0, co, 0, 5);

		int[] scores = new int[5];
		for (int i = 0; i < 5; i++) 
		{
			scores[i] = Integer.parseInt(co[i]);
		}

		compSup.setScores(scores);
		double s = compSup.getOverallScore();

		//compSup.getOverallScore();
		ostf.setText(String.format("%,.2f", s));

		result.setText("updated");
	}

/////////////////////////////////////////////////////////////////////////////////

	private void search() 
	{
		// get search text 
		// setting result text
		String searchString = searchField.getText().trim();
		if (searchString.length() > 0) 
		{
			Super_Competitor compSup = compList.findById(Integer.parseInt(searchString));
			if (compSup != null) 
			{
				String ID = Integer.toString(compSup.getNum());
				idF.setText(ID);
				nameF.setText(compSup.getName().getFirstName());
				int[] scoreL = compSup.getScoreArray();
				String scoreList = "";
				// Iterate till the end of the array
				for (int scoreIndex = 0; scoreIndex < scoreL.length; scoreIndex++) 
				{
					// Append each element of array into the string
					scoreList += scoreL[scoreIndex] + " ";
				}
				// report.length() - 1 is used to eliminate the last space that is appended from
				// the above for loop
				scoreList = scoreList.substring(0, scoreList.length() - 1);
				scoreList = scoreList.replace(' ', ',');

				scorestf.setText(scoreList);
			}
			result.setText("");
			update.setEnabled(true);
		} 
		else 
		{
			result.setText("not found");
			clear();
		}
	}

/////////////////////////////////////////////////////////////////////////////////

	private void clear() 
	{
		nameF.setText("");
		idF.setText("");

		scorestf.setText("");

		update.setEnabled(false);
	}

/////////////////////////////////////////////////////////////////////////////////

	public void actionPerformed(ActionEvent e) 
	{
		//----------Action from Window 0---------//
		if (e.getSource() == viewScores) 
		{
			setupSubFrame1North();
			setupSubFrame1South();
		} 
		else if (e.getSource() == viewDetails)
		{
			setupSubFrame2North();
			setupSubFrame2South();
		}
		else if(e.getSource() == viewTables)
		{
			setupSubFrame3North();
			setupSubFrame3South();
		}
		else if(e.getSource() == searchDetails)
		{
			setupSubFrame4North();
			setupSubFrame4South();
		}
		
		//----------Action from Window 4---------//
		
		else if(e.getSource() == swimmer)
		{
			categoryText.setText(compList.makeAChoice("Swimmer"));
		}
		else if(e.getSource() == chess)
		{
			categoryText.setText(compList.makeAChoice("Chess"));
		}
		else if(e.getSource() == gaming)
		{
			categoryText.setText(compList.makeAChoice("Gaming"));
		}
		else if(e.getSource() == basketball)
		{
			categoryText.setText(compList.makeAChoice("Basketball"));
		}
		
		//----------Action from Window 3---------//
		
		else if (e.getSource() == listByName) 
		{
			compList.sortByName();
			categoryText2.setText(compList.listAllComp());
		}
		else if (e.getSource() == listByID) 
		{
			compList.sortByCN();
			categoryText2.setText(compList.listAllComp());
		}
		else if (e.getSource() == listByOS) 
		{
			compList.sortByOS();
			categoryText2.setText(compList.listAllComp());
		}
		
		//----------Action from Window 2---------//
		
		else if (e.getSource() == showShortDetail) 
		{
			details.setText(compList.findShortDetails(Integer.parseInt(searchtf.getText().trim())));
		}
		else if (e.getSource() == showFullDetail) 
		{
			details.setText(compList.findFullDetails(Integer.parseInt(searchtf.getText().trim())));
		}
		
		//----------Action from Window 1---------//
		
		else if (e.getSource() == search) 
		{
			search();
		}
		else if (e.getSource() == update) 
		{
			update();
		}
		
		//----------Action from Closing Button---------//
		
		else if (e.getSource() == closeTxt) 
		{
			int confirm = JOptionPane.showOptionDialog(null, "Close Application and save to Text File?", 
		             "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirm == 0) 
		    {
				//To write the details to a text file is not working.
				//cm.run();
				Calendar cal = Calendar.getInstance();
		        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				System.out.println("The application has ended at "+sdf.format(cal.getTime()));
				String toFile="\n\n***Details of all the Competitors***\n"+compList.listAllComp()+"\n***"+compList.getMaxScore()+"\n\n***"+compList.getMinScore();
				compList.writeToFile("CompetitorsOut.txt", "\nApplication last accessed: ",sdf.format(cal.getTime())+"\n"+toFile );
				System.exit(0);
		    }
		}
	}
/////////////////////////////////////////////////////////////////////////////////
}