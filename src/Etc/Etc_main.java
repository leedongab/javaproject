package Etc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Login.AdminLogin;
import Login.MakeConnection;
import Meun.Main_Meun;

public class Etc_main extends JFrame {
	//지역변수
	private JPanel jp;
	private JScrollPane jp2;
	private JScrollPane jp3;
	private ImageIcon icon;
	private JTable table;
	private JTable table2;
	private String header[]= {"시설명","점검내용","비고"};

	//db config

	private DefaultTableModel model = new DefaultTableModel(header, 0);
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;



	private String header2[]= {"물품","갯수","한도","비고"};
	private DefaultTableModel model2 = new DefaultTableModel(header2, 0);
	private PreparedStatement pstmt2 = null;
	private ResultSet es = null;

	public static void main(String[] args) {
		new Etc_main();
	}



	public Etc_main() {
		super("Movie Development Program_Etc");
		setDefaultCloseOperation(EXIT_ON_CLOSE); //프레임 x 표를 누르면 꺼지는 기능
		setBounds(650, 0, 600, 1050); // 프레임 창 크기를 set 로 입력하는 기능
		icon = new ImageIcon("src/Images/08_etc_page_design_bg.png"); //이미지icon
		jp = new JPanel() {

			public void paintComponent(Graphics g) { //awt 메소드 상속
				g.drawImage(icon.getImage(), 0, 0, 600, 1050, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}// method end
		}; // panel end
		jp.setLayout(null); //패널의  레이아웃을 null 로 지정

		table = new JTable(model);// 테이블 객체에 매개변수로 model 받아서 사용
		table2 = new JTable(model2); //위랑 같은 요소



		jp2 = new JScrollPane(table);
		jp2.setBounds(75, 260, 452, 200); //jscrollpane config 위치 크기 지정
		jp2.setBackground(Color.gray); //색상지정

		jp3 = new JScrollPane(table2);
		jp3.setBounds(75, 540, 452, 400);
		jp3.setBackground(Color.gray);

		JButton jbtn_cancel = new JButton(); //인스턴스 메모리에 올림
		jbtn_cancel.setBorderPainted(false); //테두리 기능 off
		jbtn_cancel.setFocusPainted(false);//포커스 기능 off
		jbtn_cancel.setContentAreaFilled(false); //컨텐츠 테두리 off
		jbtn_cancel.setBounds(80, 50, 80, 80); //위치 크기 지정 앞에 x,y,w,h  순

		jbtn_cancel.addActionListener(new ActionListener() { //리스너 추가 //액션 리스너 할당
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_cancel) {
					new Main_Meun();
					dispose();
				}
			}
		});

		// ---------------------------
		add(jp); // 패널을 프레임에 붙인다
		jp.add(jp2);//jp 패널에 jp2 패널 붙이기
		jp.add(jp3);//jp 패널에 jp3 패널 붙이기
		jp.add(jbtn_cancel);//jp 패널에 돌아가는 버튼 붙이기

		setVisible(true);
		select(); //메소드 불러서 바로 실행 void는 바로 실행된다
		select2();//메소드 불러서 사용
	}
	private void select() {
		Connection conn = MakeConnection.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer sb = new StringBuffer();

		sb.append("select CHECKNAME, CONTENTS, ETC ");
		sb.append(" from MOVIE_CHECKLIST ");

		try {
			pstmt = conn.prepareStatement(sb.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("CHECKNAME"),
						rs.getString("CONTENTS"), rs.getString("ETC"),

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
	private void select2() {
		Connection conn = MakeConnection.getConnection();
		//dd
		PreparedStatement pstmt = null;
		ResultSet es = null;

		StringBuffer sb = new StringBuffer();

		sb.append("select NAME, NUM, USE, ETC ");
		sb.append(" from MOVIE_SNACK ");

		try {
			pstmt = conn.prepareStatement(sb.toString());

			es = pstmt.executeQuery();

			while (es.next()) {
				model2.addRow(new Object[] { es.getString("NAME"),
						es.getString("NUM"), es.getString("USE"),
						es.getString("ETC")

				});
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		} finally {
			try {
				es.close();
				pstmt2.close();
				conn.close();

			} catch (Exception e2) {

			}
		}
	}


}
