package Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ID_Signup extends JFrame implements MouseListener{
	static ID_Signup frame;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JPanel jp;
	ImageIcon icon;
//-----------------------------------------------------------------------------------------------------------------------------------
	public ID_Signup() {
		super("Movie Development Program_ID_Signup");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(750, 300, 400, 545);
		icon = new ImageIcon("src/Images/sign-up_bg.png");
		jp = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, 400, 545, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}// method end
		}; // panel end
		jp.setLayout(null);
//-----------------------------------------------------------------------------------------------------------------------------------
		textField1 = new JTextField("이름");
		textField1.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField1.setBounds(65, 150, 265, 30); // 입력 크기 위치
		textField1.setForeground(Color.LIGHT_GRAY);
		textField1.addMouseListener(this);

		textField2 = new JTextField("ID");
		textField2.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField2.setBounds(65, 190, 265, 30); // 입력 크기 위치
		textField2.setForeground(Color.LIGHT_GRAY);
		textField2.addMouseListener(this);

		textField3 = new JTextField("PASSWORD");
		textField3.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField3.setBounds(65, 230, 265, 30); // 입력 크기 위치
		textField3.setForeground(Color.LIGHT_GRAY);
		textField3.addMouseListener(this);

		textField4 = new JTextField("나이");
		textField4.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField4.setBounds(65, 270, 265, 30); // 입력 크기 위치
		textField4.setForeground(Color.LIGHT_GRAY);
		textField4.addMouseListener(this);

		textField5 = new JTextField("E-MAIL");
		textField5.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField5.setBounds(65, 310, 265, 30); // 입력 크기 위치
		textField5.setForeground(Color.LIGHT_GRAY);
		textField5.addMouseListener(this);


		textField6 = new JTextField("전화번호");
		textField6.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField6.setBounds(65, 350, 265, 30); // 입력 크기 위치
		textField6.setForeground(Color.LIGHT_GRAY);
		textField6.addMouseListener(this);

//-----------------------------------------------------------------------------------------------------------------------------------
		JButton jbtn_join = new JButton(new ImageIcon("src/images/login_sign-up_join.png"));// 로그인 버튼
		jbtn_join.setBorderPainted(false);
		jbtn_join.setFocusPainted(false);
		jbtn_join.setBounds(60, 400, 136, 43);
		jbtn_join.addActionListener(new ActionListener() { // 가입하기 action
			public void actionPerformed(ActionEvent e) {
				int status=0;
				Object key = e.getSource();
				if (key == jbtn_join) {
					String name = textField1.getText();
					String id = textField2.getText();
					String password = textField3.getText();
					String age = textField4.getText();
					String email = textField5.getText();
					String tel = textField6.getText();
					Connection conn = MakeConnection.getConnection();// 기존 연결설정 가지고 온다.
					PreparedStatement pstmt = null;
					int rs = 0;

					StringBuffer sb = new StringBuffer();

					sb.append("insert into Login ");
					sb.append("values (?,?,?,?,?,?) ");


					try {

						pstmt = conn.prepareStatement(sb.toString());
						pstmt.setString(1, name);
						pstmt.setString(2, id);
						pstmt.setString(3, password);
						pstmt.setString(4, age);
						pstmt.setString(5, email);
						pstmt.setString(6, tel);

						rs = pstmt.executeUpdate();
						conn.close();
						new AdminLogin();
						dispose();
						JOptionPane.showMessageDialog(null, "회원가입을 축하합니다.");
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");



				}

				}else{
					JOptionPane.showMessageDialog(ID_Signup.this,"Sorry, unable to save!");
				}

			}
		});// key action end
//-----------------------------------------------------------------------------------------------------------------------------------
		JButton jbtn_cancel = new JButton(new ImageIcon("src/images/login_sign-up_cancel.png"));// 로그인 버튼
		jbtn_cancel.setBorderPainted(false);
		jbtn_cancel.setFocusPainted(false);
		jbtn_cancel.setBounds(200, 400, 136, 43);
		jbtn_cancel.addActionListener(new ActionListener() { // 가입하기
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_cancel) {
					new AdminLogin();
					dispose();
				}

			}
		});// key action end
//-----------------------------------------------------------------------------------------------------------------------------------
		add(jp);
		jp.add(textField1);
		jp.add(textField2);
		jp.add(textField3);
		jp.add(textField4);
		jp.add(textField5);
		jp.add(textField6);
		jp.add(jbtn_join);
		jp.add(jbtn_cancel);

		setVisible(true);

	}//생성자 end
//-----------------------------------------------------------------------------------------------------------------------------------
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Object key = e.getSource();


		if (key == textField1) {
			textField1.setText("");
		}else if (key==textField2){
			textField2.setText("");
		}else if (key==textField3){
			textField3.setText("");
		}else if (key==textField4){
			textField4.setText("");
		}else if (key==textField5){
			textField5.setText("");
		}else if (key==textField6){
			textField6.setText("");
		}

//-----------------------------------------------------------------------------------------------------------------------------------
	}
}
