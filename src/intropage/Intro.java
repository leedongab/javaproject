package intropage;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Login.AdminLogin;

public class Intro extends JFrame {
	static Intro frame;
	private JLabel jlb_img01;
	private JLabel jlb_txt01;
	private JPanel jp;


	public Intro() {

		super("Movie Development Program_Intro");
		// 프로그램 이름
		setBounds(650, 100, 600, 800);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.WHITE);

		jp = new JPanel();
		jp.setBounds(0, 0, 600, 800);
		jp.setBackground(Color.WHITE);
		jp.setLayout(null);

		jlb_img01 = new JLabel(new ImageIcon("src/Images/main_bg.png"));
		jlb_img01.setBounds(-10, 150, 600, 350);
		jlb_txt01 = new JLabel("Press the Enter key");

		jlb_txt01.setFont(new Font("나눔스퀘어", Font.PLAIN, 22));
		jlb_txt01.setBounds(190, 300, 500, 500);

		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {

				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					new AdminLogin();
					dispose(); // 이전 창 끄기 이전창 : gui
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO 자동 생성된 메소드 스텁

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO 자동 생성된 메소드 스텁

			}
		});

		add(jp);
		jp.add(jlb_img01);
		jp.add(jlb_txt01);

		setVisible(true); // J프레임안에 있는 정보 가져 오기

	}// 생성자end

	public static void main(String[] args) {
		new Intro();
	}
}
