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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ID_Delete extends JFrame implements MouseListener,ActionListener{
	static ID_Signup frame;
	private JTextField textField1;
	private JTextField textField2;
	private JPanel jp;
	JButton jbtn_delete;
	ImageIcon icon;
	//-----------------------------------------------------------------------------------------------------------------------------------
	public ID_Delete() {
		super("Movie Development Program_ID_Delete");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(750, 300, 400, 405);
		icon = new ImageIcon("src/Images/Login_delete_bg.png");
		jp = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, 400, 405, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}// method end
		}; // panel end
		jp.setLayout(null);

		textField1 = new JTextField("ID");
		textField1.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField1.setBounds(65, 190, 265, 30); // 입력 크기 위치
		textField1.setForeground(Color.LIGHT_GRAY);
		textField1.addMouseListener(this);

		textField2 = new JTextField("PW");
		textField2.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField2.setBounds(65, 230, 265, 30); // 입력 크기 위치
		textField2.setForeground(Color.LIGHT_GRAY);
		textField2.addMouseListener(this);

		//-----------------------------------------------------------------------------------------------------------------------------------
		jbtn_delete = new JButton(new ImageIcon("src/images/login_main_btn_4.png"));// 로그인 버튼
		jbtn_delete.setBorderPainted(false);
		jbtn_delete.setFocusPainted(false);
		jbtn_delete.setBounds(60, 280, 136, 43);
		jbtn_delete.addActionListener(this);// key action end
		//-----------------------------------------------------------------------------------------------------------------------------------
		JButton jbtn_cancel = new JButton(new ImageIcon("src/images/login_sign-up_cancel.png"));// 로그인 버튼
		jbtn_cancel.setBorderPainted(false);
		jbtn_cancel.setFocusPainted(false);
		jbtn_cancel.setBounds(200, 280, 136, 43);
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
		jp.add(jbtn_delete);
		jp.add(jbtn_cancel);
		setVisible(true);
		//-----------------------------------------------------------------------------------------------------------------------------------
	}

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
		// TODO Auto-generated method stub
		Object key = e.getSource();
		if (key == textField1) {
			textField1.setText("");
		}else if (key==textField2){
			textField2.setText("");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object key = e.getSource();
		if (key == jbtn_delete) {

			String id = textField1.getText();
			String Password = textField2.getText();

			Connection conn = MakeConnection.getConnection();// 기존 연결설정 가지고 온다.
			PreparedStatement pstmt = null;
			int rs = 0;

			StringBuffer sb = new StringBuffer();

			sb.append("delete from LOGIN ");
			sb.append("where id =? and password=? ");

			try {
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, id);
				pstmt.setString(2, Password);

				rs = pstmt.executeUpdate();
				conn.close();
				JOptionPane.showMessageDialog(ID_Delete.this, "아이디 삭제했습니다.");
				new AdminLogin();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "삭제를 못하였습니다.");

			}

		} else {
			JOptionPane.showMessageDialog(ID_Delete.this, "삭제불가,관리자에게 문의");
		}



	}//if끝 else 시작 가능

}
