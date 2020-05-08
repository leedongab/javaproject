package Ticket;

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

public class Ticket_main extends JFrame implements ActionListener {
	private JPanel jp;
	private JScrollPane jp2;
	private ImageIcon icon;
	private JTable table;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
//	---------------------------------
	private JTextField delete_textField1;
	private JTextField delete_textField2;
	private JButton jbtn_delete;
	private JButton jbtn_create;

	private Connection conn = MakeConnection.getConnection();
	String header[] = { "티켓고유번호", "티켓이름", "티켓내용", "티켓발급날짜" };
	private DefaultTableModel model = new DefaultTableModel(header, 0);

	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public static void main(String[] args) {
		new Ticket_main();
	}

	public Ticket_main() {
		super("Movie Development Program_Copoun");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(650, 0, 600, 1050);
		icon = new ImageIcon("src/Images/07_Copon_page_design_bg.png");
		jp = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, 600, 1050, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}// method end
		}; // panel end


		table = new JTable(model);

		jp2 = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jp2.setBounds(75, 570, 452, 190);
		jp2.setBackground(Color.gray);

		jp.setLayout(null);

		jbtn_create = new JButton(new ImageIcon("src/images/07.create.png"));
		jbtn_create.setBounds(75, 437, 125, 30);
		jbtn_create.setBorderPainted(false);
		jbtn_create.setFocusPainted(false);

		JButton jbtn_edit = new JButton(new ImageIcon("src/images/07.edit.png"));
		jbtn_edit.setBounds(217, 437, 125, 30);
		jbtn_edit.setBorderPainted(false);
		jbtn_edit.setFocusPainted(false);
		jbtn_edit.setEnabled(true);

		jbtn_delete = new JButton(new ImageIcon("src/images/06_btn3.png"));
		jbtn_delete.setBounds(345, 857, 125, 30);
		jbtn_delete.setBorderPainted(false);
		jbtn_delete.setFocusPainted(false);

		JButton jbtn_cancel = new JButton(new ImageIcon(""));
		jbtn_cancel.setBorderPainted(false);
		jbtn_cancel.setFocusPainted(false);
		jbtn_cancel.setContentAreaFilled(false);
		jbtn_cancel.setBounds(80, 50, 80, 80);

		textField1 = new JTextField("고유번호");
		textField1.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField1.setBounds(75, 273, 455, 25); // 입력 크기 위치
		textField1.setForeground(Color.LIGHT_GRAY);

		textField2 = new JTextField("티켓이름");
		textField2.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField2.setBounds(75, 311,  455, 25); // 입력 크기 위치
		textField2.setForeground(Color.LIGHT_GRAY);

		textField3 = new JTextField("티켓내용");
		textField3.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField3.setBounds(75, 348,  455, 25); // 입력 크기 위치
		textField3.setForeground(Color.LIGHT_GRAY);

		textField4 = new JTextField("YYMMDD");
		textField4.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField4.setBounds(75, 386,  455, 25); // 입력 크기 위치
		textField4.setForeground(Color.LIGHT_GRAY);

		delete_textField1 = new JTextField("고유번호");
		delete_textField1.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		delete_textField1.setBounds(75, 860, 125, 25); // 입력 크기 위치
		delete_textField1.setForeground(Color.LIGHT_GRAY);

		delete_textField2 = new JTextField("티켓이름");
		delete_textField2.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		delete_textField2.setBounds(207, 860, 125, 25); // 입력 크기 위치
		delete_textField2.setForeground(Color.LIGHT_GRAY);

		jbtn_delete.addActionListener(this);
		jbtn_create.addActionListener(this);

		jbtn_edit.addActionListener(new ActionListener() { // 가입하기
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_edit) {
				}

			}
		});// key action



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
		jp.add(textField1);
		jp.add(textField2);
		jp.add(textField3);
		jp.add(textField4);
		jp.add(jbtn_cancel);

		jp.add(jbtn_delete);
		jp.add(jbtn_create);
		jp.add(jbtn_edit);

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

		sb.append("select TICKETNO, TICKETNAME, TICKETCONTENTS, TICKETDATE ");
		sb.append(" from MOVIE_TICKET ");

		try {
			pstmt = conn.prepareStatement(sb.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("TICKETNO"), rs.getString("TICKETNAME"),
						rs.getString("TICKETCONTENTS"), rs.getString("TICKETDATE")

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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object key = e.getSource();
		if (key == jbtn_delete) {
			System.out.println("확인");
			String TICKETNO = textField1.getText();
			String TICKETNAME = textField2.getText();

			Connection conn = MakeConnection.getConnection();// 기존 연결설정 가지고 온다.
			PreparedStatement pstmt = null;
			int rs = 0;

			StringBuffer sb = new StringBuffer();

			sb.append("delete from MOVIE_TICKET ");
			sb.append("where  TICKETNO = ? and  TICKETNAME = ? ");

			try {
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, TICKETNO);
				pstmt.setString(2, TICKETNAME);
				rs = pstmt.executeUpdate();
				conn.close();

				JOptionPane.showMessageDialog(null, "티켓 삭제");

			} catch (Exception e1) {
				// TODO: handle exception
			}

		} else if (key == jbtn_create) {
			System.out.println("확인");
			String TICKETNO = textField1.getText();
			String TICKETNAME = textField2.getText();
			String TICKETCONTENTS = textField3.getText();
			String TICKETDATE = textField4.getText();

			Connection conn = MakeConnection.getConnection();// 기존 연결설정 가지고 온다.
			PreparedStatement pstmt = null;

			int rs = 0;

			// sql 문
			StringBuffer sb = new StringBuffer(); // 버터 인식
			sb.append("insert into MOVIE_TICKET ");
			sb.append("values (?,?,?,?) ");

			try {
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, TICKETNO);
				pstmt.setString(2, TICKETNAME);
				pstmt.setString(3, TICKETCONTENTS);
				pstmt.setString(4, TICKETDATE);

				rs = pstmt.executeUpdate(); // select 문만 이거 쓰고 나머지는 pstmt.executeupdate

				conn.close();
				dispose();
				new Ticket_main();

				JOptionPane.showMessageDialog(null, "저장되었습니다.");
			} catch (SQLException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(Ticket_main.this, "저장하지 못했습니다.");
			}

		}else{
			JOptionPane.showMessageDialog(Ticket_main.this, "삭제불가");
		}

	}

}