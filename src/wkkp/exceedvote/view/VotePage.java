package wkkp.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import wkkp.exceedvote.controller.Exceed;
import wkkp.exceedvote.view.WelcomePage.GoToProjectList;

public class VotePage extends JFrame {
	private ProjectListPage projectListPage;
	private WelcomePage welcomePage;
	private JTextArea teamName1, teamName2, teamName3, teamName4, teamName5;
	private List<JLabel> criteria;
	private List<JCheckBox> checkBox;
	private JCheckBox c1, c2, c3, c4, c5;
	private JPanel panel1, panel2, panel3, panel4, panel5;
	private JTextField enterName;
	private JButton applyButton, cancelButton, buttonGoProjectList,
			buttonGoWelcomePage;
	private Exceed exceed;


	public VotePage(Exceed exceed) {
		this.exceed = exceed;
		this.setTitle("Vote");
		criteria = new ArrayList<JLabel>();
		checkBox = new ArrayList<JCheckBox>();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		this.pack();
	}

	private void initComponents() {
		setCriteria();
		/*
		 * criteria = new JLabel("1.The best Software"); criteria.setFont(new
		 * Font("Angsananew", 15, 40)); criteria.setPreferredSize(new
		 * Dimension(70, 40));
		 */

		ActionListener ab = new Submit(exceed);
		applyButton = new JButton("submit");
		applyButton.addActionListener(ab);

		ActionListener cb = new Cancel();
		cancelButton = new JButton("cancel");
		cancelButton.addActionListener(cb);

		ActionListener pr = new GoToProjectListPage(exceed);
		buttonGoProjectList = new JButton("ProjectList");
		buttonGoProjectList.addActionListener(pr);

		ActionListener wp = new GoToWelcomePage(exceed);
		buttonGoWelcomePage = new JButton("Home");
		buttonGoWelcomePage.addActionListener(wp);

		enterName = new JTextField();
		enterName.setPreferredSize(new Dimension(150, 20));

		teamName1 = new JTextArea();
		teamName2 = new JTextArea();
		teamName3 = new JTextArea();
		teamName4 = new JTextArea();
		teamName5 = new JTextArea();

		for (int i = 0; i < exceed.getCriteriaSize(); i++) {
			setCheckBox(i);
		}

		/*
		 * c1 = new JCheckBox("TeamA"); c1.setFont(new Font("Angsananew", 15,
		 * 25)); c2 = new JCheckBox("TeamB"); c2.setFont(new Font("Angsananew",
		 * 15, 25)); c3 = new JCheckBox("TeamC"); c3.setFont(new
		 * Font("Angsananew", 15, 25)); c4 = new JCheckBox("TeamD");
		 * c4.setFont(new Font("Angsananew", 15, 25)); c5 = new
		 * JCheckBox("TeamE"); c5.setFont(new Font("Angsananew", 15, 25));
		 */
		panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.setPreferredSize(new Dimension(280, 500));

		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.setPreferredSize(new Dimension(280, 200));

		panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		panel3.setPreferredSize(new Dimension(280, 20));

		panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());

		panel5 = new JPanel();
		panel5.setLayout(new FlowLayout());

		Container contents = this.getContentPane();
		contents.setLayout(new BoxLayout(contents, BoxLayout.Y_AXIS));
		contents.setPreferredSize(new Dimension(350, 400));

		for (int i = 0; i < exceed.getCriteriaSize(); i++) {
			panel1.add(criteria.get(i));
			for (int j = 0; j < exceed.getChoiceSize(i); j++) {
				panel1.add(checkBox.get(j));
			}

		}

		/*
		 * panel1.add(c1); panel1.add(c2); panel1.add(c3); panel1.add(c4);
		 * panel1.add(c5);
		 */

		panel2.add(enterName);
		panel2.add(applyButton);
		panel2.add(cancelButton);
		panel2.add(buttonGoProjectList);
		panel2.add(buttonGoWelcomePage);

		panel3.add(buttonGoProjectList);
		panel3.add(buttonGoWelcomePage);

		panel4.add(panel1, BorderLayout.WEST);

		panel5.add(panel3, BorderLayout.CENTER);

		contents.add(panel5);
		contents.add(panel4);
		contents.add(panel2);

	}

	public void run() {
		this.setVisible(true);
	}

	public void close() {
		this.setVisible(false);
	}

	public void setCriteria() {
		String[] criterion = new String[exceed.getCriteriaSize()];
		criterion = exceed.getCriteria();
		for (int i = 0; i < exceed.getCriteria().length; i++) {
			System.out.println(criterion[i]);
			criteria.add(new JLabel(criterion[i]));
		}
	}

	public void setCheckBox(int index) {
		String checkBoxName[] = exceed.getChoiceFromCriteria(index);
		int size = exceed.getChoiceSize(index);
		System.out.println("check box size : " + size);
		for (int i = 0; i < size; i++) {
			checkBox.add(new JCheckBox(checkBoxName[i]));
		}
	}

	class GoToProjectListPage implements ActionListener {
		private Exceed exceed;

		public GoToProjectListPage(Exceed exceed) {
			this.exceed = exceed;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			projectListPage = new ProjectListPage(exceed);
			projectListPage.run();
			close();

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

	class Submit implements ActionListener {
		private Exceed exceed;

		public Submit(Exceed exceed) {
			this.exceed = exceed;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String userName = enterName.getText();
			String prj = "";
			if (userName.equals("")) {
				JOptionPane.showMessageDialog(null,
						"Invalid username/password!.", "Warning",
						JOptionPane.WARNING_MESSAGE);
			} else {
				enterName.setText("");
				JOptionPane.showMessageDialog(null, "Vote Complete.",
						"eXceedVote", JOptionPane.PLAIN_MESSAGE);
				System.out.println(exceed.getCriteriaSize());
				for (int j = 0; j < exceed.getCriteriaSize(); j++) {
					for (int i = 0; i < exceed.getChoiceSize(j); i++) {
						if (checkBox.get(i).isSelected()) {
							prj += " " + checkBox.get(i).getText();
							checkBox.get(i).setSelected(false);
						}
					}
				}
				exceed.saveVote(userName + " has been voted for" + prj);
			}
		}
	}

	class Cancel implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			enterName.setText("");
			for (int j = 0; j < exceed.getCriteriaSize(); j++) {
				for (int i = 0; i < exceed.getChoiceSize(j); i++) {
					if (checkBox.get(i).isSelected())
						checkBox.get(i).setSelected(false);
				}
			}
		}
	}
}
