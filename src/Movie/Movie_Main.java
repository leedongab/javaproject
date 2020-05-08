package Movie;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import Login.MakeConnection;
import Meun.Main_Meun;
import Seat.Seat_Main;
import intropage.Intro;

public class Movie_Main extends JFrame implements MouseListener{
	private JPanel jp;
	private ImageIcon icon;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	//-----------------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		new Movie_Main();
	}
	//-----------------------------------------------------------------------------------------------------------------------------------
	public Movie_Main() {
		super("Movie Development Program_Movie");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(650, 0, 600, 1050);
		icon = new ImageIcon("src/Images/Movie_bg.png");
		jp = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, 600, 1050, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}// method end
		}; // panel end

		jp.setLayout(null);
//------------------------------------------------------------------------------------------------------------------------------------
		JLabel jlb_txt = new JLabel("영화 이미지등록");
		jlb_txt.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 20)); // 폰트 설정
		jlb_txt.setBounds(70, 190, 180, 30);

		JLabel jlb_txt2 = new JLabel("영화 정보입력");
		jlb_txt2.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 20)); // 폰트 설정
		jlb_txt2.setBounds(70, 654, 180, 30);

		JButton jlb_등록 = new JButton(new ImageIcon("src/images/movie_lb.png"));
		jlb_등록.setBounds(174, 290, 252, 332);

		JButton jbtn_add = new JButton(new ImageIcon("src/images/movie_btn.png"));// 로그인 버튼
		jbtn_add.setBounds(70, 230, 90, 28);
		jbtn_add.setBorderPainted(false);
		jbtn_add.setFocusPainted(false);
		//-----------------------------------------------------------------------------------------------------------------------------------
		JButton jbtn_save = new JButton(new ImageIcon("src/images/04-movie-page-_btn_save.png"));// 로그인 버튼
		jbtn_save.setBounds(150 - 10, 894, 100, 45);
		jbtn_save.setBorderPainted(false);
		jbtn_save.setFocusPainted(false);

		JButton jbtn_search = new JButton(new ImageIcon("src/images/04-movie-page-_btn_search.png"));// 로그인 버튼
		jbtn_search.setBounds(260 - 10, 894, 100, 45);
		jbtn_search.setBorderPainted(false);
		jbtn_search.setFocusPainted(false);

		JButton jbtn_delete = new JButton(new ImageIcon("src/images/04-movie-page-_btn_delete.png"));// 로그인 버튼
		jbtn_delete.setBounds(370 - 10, 894, 100, 45);
		jbtn_delete.setBorderPainted(false);
		jbtn_delete.setFocusPainted(false);

		JButton jbtn_cancel = new JButton(new ImageIcon(""));
		jbtn_cancel.setBorderPainted(false);
		jbtn_cancel.setFocusPainted(false);
		jbtn_cancel.setContentAreaFilled(false);
		jbtn_cancel.setBounds(80, 50, 80, 80);
		jbtn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_cancel) {
					new Main_Meun();
					dispose();
				}
			}
		});

////	-----------------------------------------------------------------
		textField1 = new JTextField();
		textField1.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField1.setBounds(170, 231, 358, 28); // 입력 크기 위치
		textField1.setForeground(Color.LIGHT_GRAY);
		textField1.addMouseListener(this);

		textField2 = new JTextField("제목");
		textField2.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField2.setBounds(76, 697, 219, 30); // 입력 크기 위치
		textField2.setForeground(Color.LIGHT_GRAY);
		textField2.addMouseListener(this);

		textField3 = new JTextField("장르");
		textField3.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField3.setBounds(311, 697, 219, 30); // 입력 크기 위치
		textField3.setForeground(Color.LIGHT_GRAY);
		textField3.addMouseListener(this);

		textField4 = new JTextField("개봉일(YYMMDD)");
		textField4.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField4.setBounds(76, 737, 219, 30); // 입력 크기 위치
		textField4.setForeground(Color.LIGHT_GRAY);
		textField4.addMouseListener(this);

		textField5 = new JTextField("감독");
		textField5.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField5.setBounds(311, 737, 219, 30); // 입력 크기 위치
		textField5.setForeground(Color.LIGHT_GRAY);
		textField5.addMouseListener(this);

		textField6 = new JTextField("배우");
		textField6.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField6.setBounds(76, 784, 219, 30); // 입력 크기 위치
		textField6.setForeground(Color.LIGHT_GRAY);
		textField6.addMouseListener(this);

		textField7 = new JTextField("관람가");
		textField7.setFont(new Font("나눔스퀘어", Font.PLAIN, 15)); // 폰트 설정
		textField7.setBounds(311, 784, 219, 30); // 입력 크기 위치
		textField7.setForeground(Color.LIGHT_GRAY);
		textField7.addMouseListener(this);

////-----------------------------------------------------------------

		jlb_등록.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jlb_등록) {
					JFileChooser choice = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG", "jpg", "png", "PNG");
					choice.setFileFilter(filter);

					int val = choice.showOpenDialog(null);
					if (val != JFileChooser.APPROVE_OPTION) {
						JOptionPane.showMessageDialog(null, "파일을 선택하세요", "waring", JOptionPane.WARNING_MESSAGE);
						return;
					}
					String filePath = choice.getSelectedFile().getPath();
					textField1.setText(filePath);
					jlb_등록.setIcon(new ImageIcon(filePath));

				}
			}

		});

		jbtn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 버튼 action
				Object key = e.getSource();
				if (key == jbtn_add) {
					JFileChooser choice = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG", "jpg", "png", "PNG");
					choice.setFileFilter(filter);

					int val = choice.showOpenDialog(null);
					if (val != JFileChooser.APPROVE_OPTION) {
						JOptionPane.showMessageDialog(null, "파일을 선택하세요", "waring", JOptionPane.WARNING_MESSAGE);
						return;
					}
					String filePath = choice.getSelectedFile().getPath();
					jlb_등록.setIcon(new ImageIcon(filePath));

					if (filter == new FileNameExtensionFilter("JPG", "jpg", "png", "PNG")) {
						textField1.setText("dsdsd");
					}

				}

			}
		});
		jbtn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 버튼 action
				Object key = e.getSource();
				if (key == jbtn_save) {

						String MOVIE_NAME = textField2.getText();
						String MOVIE_TYPE = textField3.getText();
						String MOVIE_DATE = textField4.getText();
						String DIRECTOR = textField5.getText();
						String ACTOR = textField6.getText();
						String AGE = textField7.getText();
						String image = textField1.getText();
						Connection conn = MakeConnection.getConnection();// 기존 연결설정 가지고 온다.
						PreparedStatement pstmt = null;

						int rs = 0;

						// sql 문
						StringBuffer sb = new StringBuffer(); // 버터 인식
						sb.append("insert into MOVIE ");
						sb.append("values (?,?,?,?,?,?,?) ");

						try {
							pstmt = conn.prepareStatement(sb.toString());
							pstmt.setString(1, MOVIE_NAME);
							pstmt.setString(2, MOVIE_TYPE);
							pstmt.setString(3, MOVIE_DATE);
							pstmt.setString(4, DIRECTOR);
							pstmt.setString(5, ACTOR);
							pstmt.setString(6, AGE);
							pstmt.setString(7, image);

							rs = pstmt.executeUpdate(); // select 문만 이거 쓰고 나머지는 pstmt.executeupdate

							conn.close();
							JOptionPane.showMessageDialog(null, "저장되었습니다.");
							dispose();
							new Movie_Main();
						} catch (SQLException e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(Movie_Main.this, "저장하지 못했습니다.");
						}


				}else {
					JOptionPane.showMessageDialog(Movie_Main.this, "저장하지 못했습니다.");
				}

			}

		});
		jbtn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 버튼 action
				Object key = e.getSource();
				if (key == jbtn_search) {
					new Movie_search();
				}

			}

		});
		jbtn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 버튼 action
				Object key = e.getSource();
				if (key == jbtn_delete) {
					new Movie_Delete();

				}

			}

		});

		add(jp);
		jp.add(jlb_txt);
		jp.add(jlb_txt2);
		jp.add(textField1);
		jp.add(textField2);
		jp.add(textField3);
		jp.add(textField4);
		jp.add(textField5);
		jp.add(textField6);
		jp.add(textField7);
		// ---------------------------
		jp.add(jbtn_cancel);
		jp.add(jbtn_delete);
		jp.add(jbtn_save);
		jp.add(jbtn_search);
		jp.add(jlb_등록);
		jp.add(jbtn_add);
		// ---------------------------
		setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
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
		}else if (key==textField7){
			textField7.setText("");
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
