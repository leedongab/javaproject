package Login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Meun.Main_Meun;

public class AdminLogin extends JFrame implements MouseListener{
	private JPanel jp;
	private JTextField textField;
	private JPasswordField passwordField;
	private ImageIcon icon;
	private JButton jbtn_Login;

	// -----------------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		new AdminLogin();
	}

	// -----------------------------------------------------------------------------------------------------------------------------------
	public AdminLogin() {
		super("Movie Development Program_AdminLogin");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(750, 300, 400, 460);
		// -----------------------------------------------------------------------------------------------------------------------------------
		icon = new ImageIcon("src/Images/Login_main_bg.png");
		jp = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, 400, 450, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}// method end
		}; // panel end

		jp.setLayout(null);
		// -----------------------------------------------------------------------------------------------------------------------------------
		textField = new JTextField("ID");
		textField.setFont(new Font("나눔스퀘어", Font.PLAIN, 17)); // 폰트 설정
		textField.setBounds(65, 140, 265, 40); // 입력 크기 위치
		textField.addMouseListener(this);


		passwordField = new JPasswordField("000000");
		passwordField.setBounds(65, 190, 265, 40);
		passwordField.addMouseListener(this);



		// -----------------------------------------------------------------------------------------------------------------------------------
		JButton jbtn_Login = new JButton(new ImageIcon("src/images/login_main_btn.png"));// 로그인 버튼
		jbtn_Login.setBorderPainted(false);
		jbtn_Login.setFocusPainted(false);
		jbtn_Login.setBounds(115, 250, 160, 40);
		jbtn_Login.addActionListener(new ActionListener() { // 액션 위에 인터페이스 안하고 쓰는방법
			public void actionPerformed(ActionEvent e) {

				String name = textField.getText(); // 텍스트 필드의 내용을 가져온다 get! 보낸다set
				String password = passwordField.getText();
				Connection conn = MakeConnection.getConnection();// 기존 연결설정 가지고 온다.
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				// sql 문
				StringBuffer sb = new StringBuffer(); // sql문 영역
				sb.append("select ID, PASSWORD ");
				sb.append("from LOGIN ");
				sb.append("Where ID = ? ");
				sb.append("and PASSWord = ? ");

				try {
					pstmt = conn.prepareStatement(sb.toString());
					pstmt.setString(1, name);
					pstmt.setString(2, password); // 불러오기 영역

					rs = pstmt.executeQuery(); // select 문만 이거 쓰고 나머지는 pstmt.executeupdate

					if (rs.next()) { // sql 정상적으로 실행 되면 밑에꺼 하세요
						new Main_Meun();
						dispose();
					} else {
						JOptionPane.showMessageDialog(AdminLogin.this, "아이디 및 패스워드 확인하세요", "회원가입하세요",
								JOptionPane.ERROR_MESSAGE);
						textField.setText("");
						passwordField.setText("");
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally { // 닫는거고
					try {
						if (pstmt != null) {
							pstmt.close();

						}
						if (conn != null) {
							conn.close();
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});// key action end
			// -----------------------------------------------------------------------------------------------------------------------------------
		JButton jbtn_SignUp = new JButton(new ImageIcon("src/images/login_main_btn2.png"));// 회원가입 버튼
		jbtn_SignUp.setBorderPainted(false);
		jbtn_SignUp.setFocusPainted(false);
		jbtn_SignUp.setBounds(115, 300, 160, 40);
		jbtn_SignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_SignUp) {
					new ID_Signup();
					dispose();
				}
			}// siup end
		});
		// -----------------------------------------------------------------------------------------------------------------------------------
		JButton jbtn_delete = new JButton(new ImageIcon("src/images/login_main_btn3.png"));// 회원가입 버튼
		jbtn_delete.setBorderPainted(false);
		jbtn_delete.setFocusPainted(false);
		jbtn_delete.setBounds(115, 350, 160, 40);
		jbtn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_delete) {
					new ID_Delete();
					dispose();
				}
			}// siup end
		});
//		jbtn_Login.addKeyListener(new KeyListener() {   //
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				// TODO Auto-generated method stub
//				int key = e.getKeyCode();
//				if (key == KeyEvent.VK_ENTER) {
//					jbtn_Login.doClick(); //
//				}
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//		});
		// -----------------------------------------------------------------------------------------------------------------------------------
		add(jp);

		jp.add(textField);
		jp.add(passwordField);
		jp.add(jbtn_Login);
		jp.add(jbtn_SignUp);
		jp.add(jbtn_delete);

		setVisible(true);

	}// 생성자 end

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object key = e.getSource();


		if (key == textField) {
			textField.setText("");
		}else if (key==passwordField){
			passwordField.setText("");
		}
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
		// TODO Auto-generated method stub

	}

}// class end
