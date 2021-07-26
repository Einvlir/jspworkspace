package springBasic.gui;

import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

import lombok.Setter;

@Setter
public class MyFrame extends JFrame{
	private JComponent t_id;
	private JComponent t_pass;
	private JComponent t_name;
	private JComponent bt;
	
	public void init() {
		setLayout(new FlowLayout());
		
		add(t_id);
		add(t_pass);
		add(t_name);
		add(bt);
		
		setVisible(true);
		setSize(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
