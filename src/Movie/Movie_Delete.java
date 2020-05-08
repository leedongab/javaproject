package Movie;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Login.AdminLogin;
import Login.ID_Signup;
import Login.MakeConnection;
import Seat.Seat_authority;
import Login.ID_Delete;

public class Movie_Delete extends JFrame implements MouseListener {
	static AdminLogin frame;
	private JPanel jp;
	JTextField textField1;
	JPasswordField passwordField;
	ImageIcon icon;

	public static void main(String[] args) {
		new Movie_Delete();
	}

	public Movie_Delete() {
		super("Movie Development Program_Movie_Delete");
		setDefaultCloseOperation(Movie_Delete.DISPOSE_ON_CLOSE);
		setBounds(650, 300, 600, 400);
		icon = new ImageIcon("src/Images/Movie_bg_영화정보-삭제.png");
		jp = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, 600, 400, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}// method end
		}; // panel end
		jp.setLayout(null);

		textField1 = new JTextField("영화제목");
		textField1.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField1.setBounds(100, 130, 390, 30); // 입력 크기 위치
		textField1.setForeground(Color.LIGHT_GRAY);
		textField1.addMouseListener(this);

		JButton jbtn_cancel = new JButton(new ImageIcon("src/images/04-movie-page-_btn_cancel.png"));
		jbtn_cancel.setBorderPainted(false);
		jbtn_cancel.setFocusPainted(false);
		jbtn_cancel.setBounds(300, 200, 100, 40);
		jbtn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_cancel) {
					dispose();
				}
			}
		});

		JButton jbtn_delete = new JButton(new ImageIcon("src/images/04-movie-page-_btn_delete.png"));
		jbtn_delete.setBorderPainted(false);
		jbtn_delete.setFocusPainted(false);
		jbtn_delete.setBounds(190, 200, 100, 40);
		jbtn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_delete) {

					String MOVIE_NAME = textField1.getText();

					Connection conn = MakeConnection.getConnection();// 기존 연결설정 가지고 온다.
					PreparedStatement pstmt = null;
					int rs = 0;

					StringBuffer sb = new StringBuffer();

					sb.append("delete from MOVIE ");
					sb.append("where  MOVIE_NAME = ?  ");

					try {
						pstmt = conn.prepareStatement(sb.toString());
						pstmt.setString(1, MOVIE_NAME);

						rs = pstmt.executeUpdate();
						conn.close();
						JOptionPane.showMessageDialog(null, "상영영화 삭제했습니다.");
						dispose();


					} catch (Exception e1) {
						// TODO: handle exception
					}

				} else {
					JOptionPane.showMessageDialog(Movie_Delete.this, "삭제불가");
				}

			}
		});
//----------------------------------------------

		add(jp);
		jp.add(jbtn_delete);
		jp.add(jbtn_cancel);
		jp.add(textField1);
		setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object key = e.getSource();
		if (key == textField1) {
			textField1.setText("");
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
}