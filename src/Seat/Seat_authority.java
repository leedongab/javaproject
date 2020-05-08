package Seat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Seat_authority extends JFrame implements ActionListener {
	private JPanel jp;
	private ImageIcon icon;
	JLabel jlb1, jlb2, jlb3, jlb4;
	JRadioButton jbtn_Radio1, jbtn_Radio2, jbtn_Radio3;

	public Seat_authority(int i) {
		super("Movie Development Program_Seat_authority");
		setDefaultCloseOperation(Seat_authority.DISPOSE_ON_CLOSE);
		setBounds(650, 300, 600, 410);
		icon = new ImageIcon("src/Images/05-seat-page_popup.png");
		jp = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, 600, 400, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}// method end
		}; // panel end
		jp.setLayout(null);

		jbtn_Radio1 = new JRadioButton("VIP");
		jbtn_Radio1.setBounds(100, 100, 100, 100);
		jbtn_Radio1.setBackground(Color.WHITE);
		jbtn_Radio1.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 20)
				);
		jbtn_Radio1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				Seat_Main.jbtn[i].setBackground(new Color(255,255,0));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});



		jbtn_Radio2 = new JRadioButton("일반석");
		jbtn_Radio2.setBounds(250, 100, 100, 100);
		jbtn_Radio2.setBackground(Color.WHITE);
		jbtn_Radio2.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 20));
		jbtn_Radio2.addMouseListener(new MouseListener() {

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
				Seat_Main.jbtn[i].setBackground(Color.WHITE);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}



		});


		jbtn_Radio3 = new JRadioButton("이용불가");
		jbtn_Radio3.setBounds(400, 100, 200, 100);
		jbtn_Radio3.setBackground(Color.WHITE);
		jbtn_Radio3.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 20));
		jbtn_Radio3.addMouseListener(new MouseListener() {

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
				Seat_Main.jbtn[i].setBackground(new Color(165,50,60));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}



		});





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
			}// siup end
		});

		JButton jbtn_save = new JButton(new ImageIcon("src/images/04-movie-page-_btn_save.png"));
		jbtn_save.setBorderPainted(false);
		jbtn_save.setFocusPainted(false);
		jbtn_save.setBounds(190, 200, 100, 40);
		jbtn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_save) {

					if (jbtn_Radio1.getFocusTraversalKeysEnabled() && jbtn_Radio2.getFocusTraversalKeysEnabled()
							&& jbtn_Radio3.getFocusTraversalKeysEnabled()) {

					}
					JOptionPane.showMessageDialog(Seat_authority.this, "저장했습니다.");
					dispose();
				} else {
					JOptionPane.showMessageDialog(Seat_authority.this, "저장하지 못하였습니다.", "다시하세요",
							JOptionPane.ERROR_MESSAGE);
				}
			}// siup end
		});

//-------------------------------------------------------------------------------------------------------------------------

		add(jp);
		jp.add(jbtn_Radio1);
		jp.add(jbtn_Radio2);
		jp.add(jbtn_Radio3);

		jp.add(jbtn_save);
		jp.add(jbtn_cancel);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
