package Mem;

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
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Login.AdminLogin;
import Login.MakeConnection;
import Meun.Main_Meun;
import Movie.Movie_Delete;
import Movie.Movie_Main;

public class Mem_main extends JFrame implements MouseListener, ActionListener {
	private JPanel jp;
	private JScrollPane jp2;
	private JTable table;
	private ImageIcon icon;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	// ---------------------------------
	private JTextField seatch_textField1;
	private JTextField seatch_textField2;
	// ---------------------------------
	private JTextField delete_textField1;
	private JTextField delete_textField2;

	private JButton jbtn_save;
	private JButton jbtn_delete;
	private JButton jbtn_seatch;

	private Connection conn = MakeConnection.getConnection();

	String header[] = { "사원이름", "사원번호", "직책", "급여", "입사일", "부서번호", };

	private DefaultTableModel model = new DefaultTableModel(header, 0);

	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

//------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		new Mem_main();
	}

	// ------------------------------------------------------------------------------------------------------
	public Mem_main() {
		super("Movie Development Program_Movie");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(650, 0, 600, 1050);

		icon = new ImageIcon("src/Images/06_Men_page_desgn_bg.png");
		jp = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, 600, 1050, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}// method end
		}; // panel end
		jp.setLayout(null);
//--------------------------------------------------------------------------------------------------------------------------
		table = new JTable(model);

		jp2 = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jp2.setBounds(75, 470, 452, 190);
		jp2.setBackground(Color.gray);
		// --------------------------------------------------------------------------------------------------------------------------
		jbtn_save = new JButton(new ImageIcon("src/images/06_btn1.png"));
		jbtn_save.setBounds(238, 360, 125, 30);
		jbtn_save.setBorderPainted(false);
		jbtn_save.setFocusPainted(false);

		jbtn_seatch = new JButton(new ImageIcon("src/images/06_btn2.png"));// 로그인 버튼
		jbtn_seatch.setBounds(345, 755, 125, 30);
		jbtn_seatch.setBorderPainted(false);
		jbtn_seatch.setFocusPainted(false);

		jbtn_delete = new JButton(new ImageIcon("src/images/06_btn3.png"));// 로그인 버튼
		jbtn_delete.setBounds(345, 885, 125, 30);
		jbtn_delete.setBorderPainted(false);
		jbtn_delete.setFocusPainted(false);
		// --------------------------------------------------------------------------------------------------------------------------
		// save_textField1;
		textField1 = new JTextField("사원이름");
		textField1.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField1.setBounds(105, 273, 125, 25); // 입력 크기 위치
		textField1.setForeground(Color.LIGHT_GRAY);
		textField1.addMouseListener(this);

		textField2 = new JTextField("사원번호");
		textField2.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField2.setBounds(238, 273, 125, 25); // 입력 크기 위치
		textField2.setForeground(Color.LIGHT_GRAY);
		textField2.addMouseListener(this);

		textField3 = new JTextField("직책");
		textField3.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField3.setBounds(371, 273, 125, 25); // 입력 크기 위치
		textField3.setForeground(Color.LIGHT_GRAY);
		textField3.addMouseListener(this);

		textField4 = new JTextField("급여");
		textField4.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField4.setBounds(105, 311, 125, 25); // 입력 크기 위치
		textField4.setForeground(Color.LIGHT_GRAY);
		textField4.addMouseListener(this);

		textField5 = new JTextField("입사일");
		textField5.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField5.setBounds(238, 311, 125, 25); // 입력 크기 위치
		textField5.setForeground(Color.LIGHT_GRAY);
		textField5.addMouseListener(this);

		textField6 = new JTextField("부서번호");
		textField6.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField6.setBounds(371, 311, 125, 25); // 입력 크기 위치
		textField6.setForeground(Color.LIGHT_GRAY);
		textField6.addMouseListener(this);

		// --------------------------------------------------------------------------------------------------------------------
		// seatch_textField1;
		seatch_textField1 = new JTextField("사원이름");
		seatch_textField1.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		seatch_textField1.setBounds(75, 757, 125, 25); // 입력 크기 위치
		seatch_textField1.setForeground(Color.LIGHT_GRAY);
		seatch_textField1.addMouseListener(this);

		seatch_textField2 = new JTextField("사원번호");
		seatch_textField2.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		seatch_textField2.setBounds(207, 757, 125, 25); // 입력 크기 위치
		seatch_textField2.setForeground(Color.LIGHT_GRAY);
		seatch_textField2.addMouseListener(this);

		// --------------------------------------------------------------------------------------------------------------------
		// delete_textField1;
		delete_textField1 = new JTextField("사원이름");
		delete_textField1.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		delete_textField1.setBounds(75, 888, 125, 25); // 입력 크기 위치
		delete_textField1.setForeground(Color.LIGHT_GRAY);

		delete_textField2 = new JTextField("사원번호");
		delete_textField2.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		delete_textField2.setBounds(207, 888, 125, 25); // 입력 크기 위치
		delete_textField2.setForeground(Color.LIGHT_GRAY);

		// --------------------------------------------------------------------------------------------------------------------
		JButton jbtn_cancel = new JButton(new ImageIcon(""));
		jbtn_cancel.setBorderPainted(false);
		jbtn_cancel.setFocusPainted(false);
		jbtn_cancel.setContentAreaFilled(false);
		jbtn_cancel.setBounds(80, 50, 80, 80);

		// --------------------------------------------------------------------------------------------------------------------
		jbtn_save.addActionListener(new ActionListener() { // 저장
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_save) {
					String ENAME = textField1.getText();
					String EMPNO = textField2.getText();
					String JOB = textField3.getText();
					String SAL = textField4.getText();
					String HIRDATE = textField5.getText();
					String DEPTNO = textField6.getText();
					Connection conn = MakeConnection.getConnection();// 기존 연결설정 가지고 온다.
					PreparedStatement pstmt = null;

					int rs = 0;

					// sql 문
					StringBuffer sb = new StringBuffer(); // 버터 인식
					sb.append("insert into MOVIE_EMP ");
					sb.append("values (?,?,?,?,?,?) ");
					try {
						pstmt = conn.prepareStatement(sb.toString());
						pstmt.setString(1, ENAME);
						pstmt.setString(2, EMPNO);
						pstmt.setString(3, JOB);
						pstmt.setString(4, SAL);
						pstmt.setString(5, HIRDATE);
						pstmt.setString(6, DEPTNO);

						rs = pstmt.executeUpdate(); // pstmt.executeupdate



						conn.close();
						JOptionPane.showMessageDialog(null, "사원정보가 저장되었습니다.");
						dispose();
						new Mem_main();
					} catch (SQLException e1) {
						e1.printStackTrace();
						System.out.println("null값있습니다");
						JOptionPane.showMessageDialog(Mem_main.this, "저장하지 못했습니다.");
					}

				} else {
					JOptionPane.showMessageDialog(Mem_main.this, "삭제불가");
				}

			}
		});// key action
			// --------------------------------------------------------------------------------------------------------------------
		jbtn_seatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_seatch) {

				}

			}
		});// key action

		jbtn_delete.addActionListener(this);// key action

		jbtn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_cancel) {
					new Main_Meun();
					dispose();
				}
			}
		});

		// ---------------------------
		add(jp);
		jp.add(jp2);
		jp.add(jbtn_save);
		jp.add(jbtn_seatch);
		jp.add(jbtn_delete);
		jp.add(jbtn_cancel);

		jp.add(textField1);
		jp.add(textField2);
		jp.add(textField3);
		jp.add(textField4);
		jp.add(textField5);
		jp.add(textField6);

		jp.add(seatch_textField1);
		jp.add(seatch_textField2);

		jp.add(delete_textField1);
		jp.add(delete_textField2);
		select();
		setVisible(true);
	}

	private void select() {
		Connection conn = MakeConnection.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer sb = new StringBuffer();

		sb.append("select ENAME, EMPNO, JOB, SAL, HIRDATE, DEPTNO ");
		sb.append(" from MOVIE_EMP ");

		try {
			pstmt = conn.prepareStatement(sb.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("ENAME"), rs.getString("EMPNO"), rs.getString("JOB"),
						rs.getString("SAL"), rs.getString("HIRDATE"), rs.getString("DEPTNO")

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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object key = e.getSource();
		if (key == textField1) {
			textField1.setText("");
		} else if (key == textField2) {
			textField2.setText("");
		} else if (key == textField3) {
			textField3.setText("");
		} else if (key == textField4) {
			textField4.setText("");
		} else if (key == textField5) {
			textField5.setText("");
		} else if (key == textField6) {
			textField6.setText("");
		} else if (key == seatch_textField1) {
			seatch_textField1.setText("");
		}
	}

//-------------------------------------------------------------------------------------------------------------------------------
	// Mouse event
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

//----------------------------------------------------------------------------------------------------------------------------------
	// action event
	@Override
	public void actionPerformed(ActionEvent e) {
		Object key = e.getSource();
		if (key == jbtn_delete) {
			if (key == jbtn_delete) {

				String ENAME = delete_textField1.getText();
				String EMPNO = delete_textField2.getText();

				Connection conn = MakeConnection.getConnection();// 기존 연결설정 가지고 온다.
				PreparedStatement pstmt = null;
				int rs = 0;

				StringBuffer sb = new StringBuffer();

				sb.append("delete from MOVIE_EMP ");
				sb.append("where ENAME =? and EMPNO =? ");

				try {
					pstmt = conn.prepareStatement(sb.toString());
					pstmt.setString(1, ENAME);
					pstmt.setString(2, EMPNO);

					rs = pstmt.executeUpdate();
					conn.close();
					JOptionPane.showMessageDialog(null, "사원 삭제했습니다.");
					new Mem_main();
				} catch (Exception e1) {

					JOptionPane.showMessageDialog(Mem_main.this, "삭제불가");
				}

			} else {
				JOptionPane.showMessageDialog(Mem_main.this, "삭제불가");
			}
		}

	}

}
