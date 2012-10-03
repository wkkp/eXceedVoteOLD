package wkkp.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import wkkp.exceedvote.view.WelcomePage.GoToVote;

public class ProjectListPage extends JFrame {
	private VotePage votePage;
	private WelcomePage welcomePage;
	private JComboBox projectList;
	private JLabel chooseProject, projectName;
	private JTextArea projectDesciption;

	private JButton buttonGoVote, buttonGoWelcomePage;
	private JPanel panel1, panel2, panel3, panel4, panel5;
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
		projectDesciption = new JTextArea();
		projectDesciption.setEditable(false);
		//projectDesciption.setHorizontalAlignment(JTextArea.CENTER);


		chooseProject = new JLabel("Choose Project...");
		chooseProject.setFont(new Font("Angsananew", 15, 40));

		ActionListener vo = new GoToVote(exceed);
		buttonGoVote = new JButton("Vote!!");
		buttonGoVote.addActionListener(vo);

		ActionListener wp = new GoToWelcomePage(exceed);
		buttonGoWelcomePage = new JButton("Home");
		buttonGoWelcomePage.addActionListener(wp);

		ActionListener ac = new SelectProjectListener(exceed);
		projectList = new JComboBox();
		projectList.addActionListener(ac);
		/*projectList.insertItemAt("TeamA", 0);
		projectList.insertItemAt("TeamB", 1);
		projectList.insertItemAt("TeamC", 2);
		projectList.insertItemAt("TeamD", 3);
		projectList.insertItemAt("TeamE", 4);*/
		setProjectList();

		panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());

		panel3 = new JPanel();

		panel4 = new JPanel();

		panel5 = new JPanel();
		panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));

		Container contents = this.getContentPane();
		contents.setLayout(new BorderLayout());
		contents.setPreferredSize(new Dimension(650, 400));

		panel1.add(chooseProject);
		panel1.add(projectList);

		panel2.add(buttonGoWelcomePage);
		panel2.add(buttonGoVote);

		panel3.add(projectName);

		panel4.add(projectDesciption);

		panel5.add(panel1);
		panel5.add(panel2);

		contents.add(panel5, BorderLayout.WEST);
		contents.add(panel3, BorderLayout.NORTH);
		contents.add(panel4, BorderLayout.CENTER);

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