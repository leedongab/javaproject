package Movie;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Login.AdminLogin;
import Login.ID_Signup;
import Login.MakeConnection;
import Login.ID_Delete;

public class Movie_search extends JFrame implements MouseListener{
	static AdminLogin frame;
	private JPanel jp;
	private JScrollPane jp2;
	private JTextField textField1;
	private JTable table;
	private ImageIcon icon;

	private String header[] = { "제목", "장르", "개봉일", "감독", "배우", "관람가", "이미지" };
	private DefaultTableModel model = new DefaultTableModel(header, 0);
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	//-----------------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		new Movie_search();
	}
	//-----------------------------------------------------------------------------------------------------------------------------------
	public Movie_search() {
		super("Movie Development Program_Movie_search");
		setDefaultCloseOperation(Movie_search.DISPOSE_ON_CLOSE);
		setBounds(650, 100, 600, 740);
		//-----------------------------------------------------------------------------------------------------------------------------------
		icon = new ImageIcon("src/Images/page_pop_1.png");
		jp = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, 600, 700, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}// method end
		}; // panel end
		jp.setLayout(null);
		jp.setBackground(Color.black);
		jp.setLayout(null);
		table = new JTable(model);

		jp2 = new JScrollPane(table);
		jp2.setBounds(70, 180, 452, 378);
		jp2.setBackground(Color.gray);

		textField1 = new JTextField("영화제목");
		textField1.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField1.setBounds(70, 130, 350, 30); // 입력 크기 위치
		textField1.setForeground(Color.LIGHT_GRAY);
		textField1.addMouseListener(this);

		//-----------------------------------------------------------------------------------------------------------------------------------
		JButton jbtn_cancel = new JButton(new ImageIcon("src/images/04-movie-page-_btn_cancel.png"));
		jbtn_cancel.setBorderPainted(false);
		jbtn_cancel.setFocusPainted(false);
		jbtn_cancel.setContentAreaFilled(false);
		jbtn_cancel.setBounds(250, 580, 100, 40);
		jbtn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_cancel) {
					dispose();
				}
			}
		});

		//-----------------------------------------------------------------------------------------------------------------------------------
		JButton jbtn_Search = new JButton(new ImageIcon("src/images/04-movie-page-_btn_search.png"));
		jbtn_Search.setBorderPainted(false);
		jbtn_Search.setFocusPainted(false);
		jbtn_Search.setBounds(425, 125, 100, 40);
		jbtn_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_Search) {
					Connection conn = MakeConnection.getConnection();// 기존 연결설정 가지고 온다.
					PreparedStatement pstmt = null;
					ResultSet rs = null;

					StringBuffer sb = new StringBuffer(); // 버터 인식

					String MOVIE_NAME = textField1.getText();

					sb.append("select MOVIE_NAME ");
					sb.append("from MOVIE ");
					sb.append("Where MOVIE_NAME = ? ");
					try {
						pstmt = conn.prepareStatement(sb.toString());
						pstmt.setString(1, MOVIE_NAME);

						rs = pstmt.executeQuery();

						for (int i = model.getRowCount() - 1; i >= 0; i--) {

							model.removeRow(i);
							while (rs.next()) {
								String[] row = new String[4];

								row[0] = rs.getString("제목");

								row[1] = rs.getString("장르");

								row[2] = rs.getString("개봉일");

								row[3] = rs.getString("감독");

								row[4] = rs.getString("배우");

								row[5] = rs.getString("관람가");

								row[6] = rs.getString("이미지");

								model.addRow(row);
							}
						}

					} catch (Exception e2) {
					}
				}

			}
		});
		//-----------------------------------------------------------------------------------------------------------------------------------
		add(jp);
		jp.add(jp2);
		jp.add(jbtn_Search);
		jp.add(jbtn_cancel);
		jp.add(textField1);
		setVisible(true);
		select();
	}


	//-----------------------------------------------------------------------------------------------------------------------------------
	private void select() {
		Connection conn = MakeConnection.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer sb = new StringBuffer();

		sb.append("select MOVIE_NAME, MOVIE_TYPE, MOVIE_DATE, DIRECTOR, ACTOR, AGE, IMAGE  ");
		sb.append("from MOVIE ");


		try {
			pstmt = conn.prepareStatement(sb.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("MOVIE_NAME"),
											rs.getString("MOVIE_TYPE"),
											rs.getString("MOVIE_DATE"),
											rs.getString("DIRECTOR"),
											rs.getString("ACTOR"),
											rs.getString("AGE"),
											rs.getString("IMAGE")

				});
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();

			} catch (Exception e2) {

			}
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------------------
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
