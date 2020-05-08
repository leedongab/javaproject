package Meun;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Etc.Etc_main;
import Login.AdminLogin;
import Mem.Mem_main;
import Movie.Movie_Main;
import Seat.Seat_Main;
import Ticket.Ticket_main;

public class Main_Meun extends JFrame {
	static Main_Meun frame;
	private JPanel jp_meun_icon;
	ImageIcon icon;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new  Main_Meun();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Main_Meun() {
		super("Movie Development Program_Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 100, 450, 740);
		icon = new ImageIcon("src/Images/menu.png");
		jp_meun_icon = new JPanel(){
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, 450, 700, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}// method end
		}; // panel end
		jp_meun_icon.setLayout(null);


		JButton jbtn_Movie = new JButton(new ImageIcon("src/images/manu_icon_1.png"));
		jbtn_Movie.setBorderPainted(false);
		jbtn_Movie.setFocusPainted(false);
		jbtn_Movie.setBounds(70, 160, 150, 150);
		jbtn_Movie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_Movie) {
					new Movie_Main();
					dispose();
				} // act 넣어야할 곳// act 넣어야할 곳
			}
		});
		JButton jbtn_Seat = new JButton(new ImageIcon("src/images/manu_icon_2.png"));
		jbtn_Seat.setBorderPainted(false);
		jbtn_Seat.setFocusPainted(false);
		jbtn_Seat.setBounds(230, 160, 150, 150);
		jbtn_Seat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_Seat) {
					new Seat_Main();
					dispose();
				} // act 넣어야할 곳
			}
		});
		JButton jbtn_Mem = new JButton(new ImageIcon("src/images/manu_icon_3.png"));
		jbtn_Mem.setBorderPainted(false);
		jbtn_Mem.setFocusPainted(false);
		jbtn_Mem.setBounds(70, 320, 150, 150);
		jbtn_Mem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_Mem) {
					new Mem_main();
					dispose();
				} // act 넣어야할 곳// act 넣어야할 곳
			}
		});
		JButton jbtn_Copon = new JButton(new ImageIcon("src/images/manu_icon_4.png"));
		jbtn_Copon.setBorderPainted(false);
		jbtn_Copon.setFocusPainted(false);
		jbtn_Copon.setBounds(230, 320, 150, 150);
		jbtn_Copon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_Copon) {
					new Ticket_main();
					dispose();
				} // act 넣어야할 곳// act 넣어야할 곳
			}
		});

		JButton jbtn_Snack = new JButton(new ImageIcon("src/images/manu_icon_5.png"));
		jbtn_Snack.setBorderPainted(false);
		jbtn_Snack.setFocusPainted(false);
		jbtn_Snack.setBounds(70, 480, 150, 150);


		jbtn_Snack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_Snack) {
					new Etc_main();
					dispose();
				} // act 넣어야할 곳// act 넣어야할 곳
			}
		});
		JButton jbtn_back = new JButton(new ImageIcon("src/images/manu_icon_6.png"));
		jbtn_back.setBorderPainted(false);
		jbtn_back.setFocusPainted(false);
		jbtn_back.setBounds(230, 480, 150, 150);
		jbtn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == jbtn_back) {
					new AdminLogin();
					dispose();
				} // act 넣어야할 곳// act 넣어야할 곳
			}
		});


		add(jp_meun_icon);
		jp_meun_icon.add(jbtn_Movie);
		jp_meun_icon.add(jbtn_Seat);
		jp_meun_icon.add(jbtn_Mem);
		jp_meun_icon.add(jbtn_Copon);
		jp_meun_icon.add(jbtn_Snack);
		jp_meun_icon.add(jbtn_back);
		setVisible(true);
	}// 생성자 end

}
