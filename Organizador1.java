import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Organizador1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Organizador1 frame = new Organizador1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Organizador1() {
		setTitle("Pantalla Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 331, 230);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(64, 82, 110));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                VentanaOrganizador1 ventana1 = new VentanaOrganizador1();
                ventana1.setVisible(true);
            }
        });
        btnIniciar.setBounds(116, 111, 85, 21);
        contentPane.add(btnIniciar);
        
        JButton btSalir = new JButton("Salir");
        btSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        btSalir.setBounds(116, 143, 85, 21);
        contentPane.add(btSalir);
        
        JLabel lblNewLabel = new JLabel("Aplicacion de Lista de Tareas");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(47, 35, 227, 49);
        contentPane.add(lblNewLabel);
	}

}
