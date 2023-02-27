package view;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class CaraCoroaWindowsBuilder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ImageIcon cara = new ImageIcon(this.getClass().getResource("/imagens/cara.png"));
	private final ImageIcon coroa = new ImageIcon(this.getClass().getResource("/imagens/coroa.png"));
	private boolean isGirou = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaraCoroaWindowsBuilder frame = new CaraCoroaWindowsBuilder();
					frame.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/moeda.png")).getImage());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CaraCoroaWindowsBuilder() {
		setRootPaneCheckingEnabled(false);
		setAlwaysOnTop(true);
		setAutoRequestFocus(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 482);
		setTitle("Cara e Coroa");
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setBounds(71, 158, 211, 208);
		contentPane.add(lblImagem);
		
		JButton btnGirar = new JButton("GIRAR");
		
		btnGirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random ra = new Random();
				int x = ra.nextInt(2);
				if (!isGirou) {
					if (x == 0) {
						lblImagem.setIcon(cara);
					} else {
						lblImagem.setIcon(coroa);
					}
					btnGirar.setText("DE NOVO");
					lblImagem.setVisible(true);
					isGirou = true;
				} else {
					btnGirar.setText("GIRAR");
					lblImagem.setVisible(false);
					isGirou = false;
				}
			}
		});
		btnGirar.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnGirar.setBounds(80, 46, 179, 52);
		contentPane.add(btnGirar);		
		
	}
}
