package wkkp.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import wkkp.exceedvote.controller.Exceed;
import wkkp.exceedvote.model.ProjectDescription;
import wkkp.exceedvote.view.WelcomePage.GoToVote;

/**
 * ProjectList Page contains all of project, project description for user to
 * see the detail of each project
 *
 * @author Kanisorn Wirutkul
 */
public class ProjectListPage extends JFrame {
	private VotePage votePage;
	private WelcomePage welcomePage;
	private JComboBox projectList;
	private JLabel chooseProject, projectName;
	private JTextArea projectDesciption;

	private JButton buttonGoVote, buttonGoWelcomePage;
	private JPanel leftPanel, panel1, panel2, panel3, panel4, panel5;
	private Exceed exceed;

	public ProjectListPage(Exceed exceed) {
		this.exceed = exceed;
		this.setTitle("ProjectList");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		this.pack();
	}

	private void initComponents() {

		projectName = new JLabel("ProjectName");
		projectName.setHorizontalAlignment(JTextField.CENTER);
		projectName.setFont(new Font("Verdana", 15, 20));
		projectDesciption = new JTextArea();
		projectDesciption.setEditable(false);
		projectDesciption.setAlignmentY(CENTER_ALIGNMENT);


		chooseProject = new JLabel("Choose Project");
		chooseProject.setFont(new Font("Verdana", 15, 25));

		ActionListener vo = new GoToVote(exceed);
		buttonGoVote = new JButton("Vote");
		buttonGoVote.addActionListener(vo);

		ActionListener wp = new GoToWelcomePage(exceed);
		buttonGoWelcomePage = new JButton("Home");
		buttonGoWelcomePage.addActionListener(wp);

		ActionListener ac = new SelectProjectListener(exceed);
		projectList = new JComboBox();
		projectList.addActionListener(ac);
		setProjectList();

		Container contents = this.getContentPane();
		contents.setLayout(null);
		contents.setPreferredSize(new Dimension(800, 500));

		chooseProject.setBounds(350, 30, 200, 50);
		projectList.setBounds(40, 230, 200, 50);
		projectName.setBounds(45, 180, 200, 50);
		projectDesciption.setBounds(300, 100, 450, 300);
		buttonGoVote.setBounds(530, 430, 100, 40);
		buttonGoWelcomePage.setBounds(420, 430, 100, 40);
		contents.add(buttonGoVote);
		contents.add(buttonGoWelcomePage);
		contents.add(chooseProject);
		contents.add(projectList);
		contents.add(projectName);
		contents.add(projectDesciption);

	}

	public void run() {
		this.setVisible(true);
	}

	public void close() {
		this.setVisible(false);
	}
	
	public void setProjectDescription(String description) {
		projectDesciption.setText(description);
	}
	
	public void setProjectList() {
		String list [] = exceed.getAllProjectName();
		int i = 0;
		while (i < list.length) {
			projectList.insertItemAt(list[i], i);
			i++;
		}
	}

	class SelectProjectListener implements ActionListener {
		private Exceed exceed;
		public SelectProjectListener(Exceed exceed) {
			this.exceed = exceed;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String a = (String) projectList.getSelectedItem();
			String[] list = exceed.getAllProjectName();
			int i = 0;
			while (i < list.length) {
				if (a.equals(list[i])) {
					System.out.println(a + "-" + list[i]);
					chooseProject.setText(list[i]);
					setProjectDescription(exceed.getProjectDescription(i));
				}
				i++;
			}
		}
	}

	class GoToWelcomePage implements ActionListener {
		private Exceed exceed;

		public GoToWelcomePage(Exceed exceed) {
			this.exceed = exceed;
		}
		@Override
		public void actionPerformed(ActionEvent e) {

			welcomePage = new WelcomePage(exceed);
			welcomePage.run();
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
}