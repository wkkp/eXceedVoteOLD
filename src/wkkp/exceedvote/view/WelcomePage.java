package wkkp.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.crypto.spec.OAEPParameterSpec;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import wkkp.exceedvote.controller.Exceed;
import wkkp.exceedvote.model.ProjectList;

/**
 * Welcome page of the program
 * 
 * @author Kanisorn Wirutkul
 */
public class WelcomePage extends JFrame{
	private VotePage votePage;
	private ProjectListPage projectListPage;
	private JLabel welcomeText; 
	private JButton buttonGoProjectList,buttonGoVote;
	private JPanel panel1,panel2,panel3;
	private Exceed exceed;
	
	public WelcomePage(Exceed exceed) {
		this.exceed = exceed;
		this.setTitle("ExceedVote");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        this.pack();
	}

	public void isExceedNull() {
		if (this.exceed.equals(null))
			System.out.println("duck");
	}
	private void initComponents(){
		welcomeText = new JLabel("eXceed Vote");
		welcomeText.setPreferredSize(new Dimension(400,100));
		welcomeText.setFont(new Font("Verdana",15,45));
		welcomeText.setHorizontalAlignment(JLabel.CENTER);
		
		
		ActionListener pr = new GoToProjectList(exceed);
		buttonGoProjectList = new JButton("Project");
		buttonGoProjectList.setPreferredSize(new Dimension(170,50));
		buttonGoProjectList.setFont(new Font("Verdana", 15, 20));
		buttonGoProjectList.addActionListener(pr);
		
		ActionListener vo = new GoToVote(exceed);
		buttonGoVote = new JButton("Vote");
		buttonGoVote.setPreferredSize(new Dimension(170,50));
		buttonGoVote.setFont(new Font("Verdana", 15, 20));
		buttonGoVote.addActionListener(vo);	
		
		panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.setPreferredSize(new Dimension(350, 80));
        panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.setPreferredSize(new Dimension(350, 50));
		panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        panel3.setPreferredSize(new Dimension(350, 50));
		
		
		Container contents = this.getContentPane();
		contents.setLayout(new BoxLayout(contents,BoxLayout.Y_AXIS));
		//contents.setLayout(new BorderLayout());
		contents.setPreferredSize(new Dimension(350,300));
		
		panel1.add(welcomeText);
		panel2.add(buttonGoProjectList);
		panel3.add(buttonGoVote);
		
		contents.add(panel1);
		contents.add(panel2);
		contents.add(panel3);
		//contents.add(welcomeText,"North");
		//contents.add(buttonGoProjectList,"Center");
		//contents.add(buttonGoVote,"South");
	}
	
	class GoToProjectList implements ActionListener {
		private Exceed exceed;
		public GoToProjectList(Exceed exceed) {
			this.exceed = exceed;
		}
        @Override
        public void actionPerformed(ActionEvent e) {
        	projectListPage = new ProjectListPage(exceed);
        	projectListPage.run();
        	close();
        }
    }
	
	class GoToVote implements ActionListener {
		private Exceed exceed;
		public GoToVote(Exceed exceed) {
			this.exceed = exceed;
		}
        @Override
        public void actionPerformed(ActionEvent e) {
            votePage = new VotePage(exceed);
            votePage.run();
            close();
            
        }
    }

	public void run() {
		this.setVisible(true);
	}
	public void close(){
		this.setVisible(false);
	}

}
