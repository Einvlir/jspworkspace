package test;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Test4 extends JFrame{
	JLabel l_id, l_pass, l_check, l_name;
	JPanel p_main;
	JTextField t_id;
	JPasswordField t_pass;
	JPasswordField pass_check;
	JTextField t_name;
	JButton regist;
	public Test4() {
		//생성
		l_id = new JLabel("ID 입력");
		l_pass = new JLabel("비밀번호 입력");
		l_check = new JLabel("비밀번호 확인");
		l_name = new JLabel("이름 입력");
		p_main = new JPanel();
		t_id = new JTextField(20);
		t_pass = new JPasswordField(20);
		pass_check = new JPasswordField(20);
		t_name = new JTextField(20);
		regist = new JButton("등록");
		
		//디자인
		regist.setPreferredSize(new Dimension(100,30));
		
		//부착
		add(l_id);
		add(t_id);
		add(l_pass);
		add(t_pass);
		add(l_check);
		add(pass_check);
		add(l_name);
		add(t_name);
		add(regist);
		
		//
		regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registCheck();
			}
		});
		
		setLayout(new FlowLayout());
		setBounds(0,0,350,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void registCheck() {
		char[] pass = t_pass.getPassword();
		char[] check = pass_check.getPassword();
		if(t_id.getText().length()<1) {
			JOptionPane.showMessageDialog(this, "ID를 입력해주세요");
		}else if(pass.length<1){
			JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요");
		}else if(!(Arrays.toString(pass).equals(Arrays.toString(check)))){
			JOptionPane.showMessageDialog(this, "비밀번호를 올바르게 입력하였는지 확인해주세요");	
		}else if(t_name.getText().length()<1){
			JOptionPane.showMessageDialog(this, "이름을 입력해주세요");	
		}else {
			JOptionPane.showMessageDialog(this, "환영합니다!");	
			
		}
	}
	public static void main(String[] args) {
		new Test4();
	}
}
