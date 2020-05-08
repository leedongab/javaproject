package Seat;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Meun.Main_Meun;

public class Seat_Main extends JFrame implements ActionListener{
	private JPanel jp;
	private JPanel jp2;

	private ImageIcon icon;
	static JButton[] jbtn = new JButton[40];

	public Seat_Main() {
		super("Movie Development Program_Seat_Main");

		final String[] btn_Title = { "A1", "A2", "A3", "A4", "A5", "B1", "B2", "B3", "B4", "B5", "C1", "C2", "C3", "C4",
				"C5", "D1", "D2", "D3", "D4", "D5", "E1", "E2", "E3", "E4", "E5", "F1", "F2", "F3", "F4", "F5", "G1",
				"G2", "G3", "G4", "G5", "H1", "H2", "H3", "H4", "H5", };

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(650, 0, 600, 1050);
		icon = new ImageIcon("src/Images/05-seat-page_bg.png");
		jp = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, 600, 1050, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}// method end
		}; // panel end
		jp.setLayout(null);

		jp2 = new JPanel();
		jp2.setBackground(Color.WHITE);
		jp2.setBounds(120, 370, 380, 500);
		jp2.setLayout(new GridLayout(8, 5, 20, 20));

		JLabel lb1 = new JLabel("A");
		lb1.setBounds(77, 375, 30, 30);
		lb1.setFont(new Font("a큐브G", Font.PLAIN, 18));

		JLabel lb2 = new JLabel("B");
		lb2.setBounds(77, 440, 30, 30);
		lb2.setFont(new Font("a큐브G", Font.PLAIN, 20));
		JLabel lb3 = new JLabel("C");
		lb3.setBounds(77, 440 + 65, 30, 30);
		lb3.setFont(new Font("a큐브G", Font.PLAIN, 20));
		JLabel lb4 = new JLabel("D");
		lb4.setBounds(77, (440 + 65 + 65), 30, 30);
		lb4.setFont(new Font("a큐브G", Font.PLAIN, 20));
		JLabel lb5 = new JLabel("E");
		lb5.setBounds(77, (440 + 65 + 65 + 65), 30, 30);
		lb5.setFont(new Font("a큐브G", Font.PLAIN, 20));
		JLabel lb6 = new JLabel("F");
		lb6.setBounds(77, (440 + 65 + 65 + 65 + 65), 30, 30);
		lb6.setFont(new Font("a큐브G", Font.PLAIN, 20));
		JLabel lb7 = new JLabel("G");
		lb7.setBounds(77, (440 + 65 + 65 + 65 + 65 + 65), 30, 30);
		lb7.setFont(new Font("a큐브G", Font.PLAIN, 20));
		JLabel lb8 = new JLabel("H");
		lb8.setBounds(77, (440 + 65 + 65 + 65 + 65 + 65 + 65), 30, 30);
		lb8.setFont(new Font("a큐브G", Font.PLAIN, 20));

		JLabel jlb_txt = new JLabel("MOVIE FILM 1 상영관");
		jlb_txt.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 20)); // 폰트 설정
		jlb_txt.setBounds(72, 218, 220, 30);


		JLabel lb_sum = new JLabel("총:40석");
		lb_sum.setBounds(170, (440 + 65 + 65 + 65 + 65 + 65 + 65+65), 500, 30);
		lb_sum.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 18));

		JLabel Normal = new JLabel("일반석:00");
		Normal.setBounds(250, (440 + 65 + 65 + 65 + 65 + 65 + 65+65), 500, 30);
		Normal.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 18));

		JLabel vip = new JLabel("VIP석:00");
		vip.setBounds(350, (440 + 65 + 65 + 65 + 65 + 65 + 65+65), 500, 30);
		vip.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 18));

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


		for (int i = 0; i < btn_Title.length; i++) {
			jp2.add(jbtn[i] = new JButton(btn_Title[i]));
			jbtn[i].setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 10));
			jbtn[i].setForeground(new Color(28, 28, 28));
			jbtn[i].setBackground(Color.WHITE);
			jbtn[i].addActionListener(this);
			jbtn[i].setFocusPainted(false);
		}



		add(jp);
		jp.add(jlb_txt);
		jp.add(jp2);
		jp.add(lb1);
		jp.add(lb2);
		jp.add(lb3);
		jp.add(lb4);
		jp.add(lb5);
		jp.add(lb6);
		jp.add(lb7);
		jp.add(lb8);
		jp.add(Normal);
		jp.add(vip);
		jp.add(lb_sum);
		jp.add(jbtn_cancel);
		setVisible(true);
	} // 생성자 end

	public static void main(String[] args) {
		new Seat_Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// TODO Auto-generated method stub
		for(int i = 0; i <=39 ; i++) {
			if(obj == jbtn[i])
				new Seat_authority(i);
		}


	}
}
