import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class VentanaOrganizador extends JFrame {


	 private List<String> tasks = new ArrayList<>();
	    private DefaultListModel<String> listModel;

	    public VentanaOrganizador() {
	        setTitle("Organizador de Tareas");
	        setSize(400, 300);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        JPanel panel = new JPanel();
	        getContentPane().add(panel);

	        // Componentes del formulario
	        JLabel lblTarea = new JLabel("Nueva Tarea:");
	        JTextField txtTarea = new JTextField(20);
	        JButton btnAgregar = new JButton("Agregar");
	        JList<String> lstTareas = new JList<>();
	        listModel = new DefaultListModel<>();
	        lstTareas.setModel(listModel);

	        // Agregar componentes al panel
	        panel.add(lblTarea);
	        panel.add(txtTarea);
	        panel.add(btnAgregar);
	        panel.add(new JScrollPane(lstTareas));

	        // Manejar el evento de clic en el botón "Agregar"
	        btnAgregar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                agregarTarea(txtTarea.getText());
	                txtTarea.setText(""); // Limpiar el campo de texto después de agregar una tarea
	            }
	        });
	    }

	    private void agregarTarea(String tarea) {
	        tasks.add(tarea);
	        actualizarLista();
	    }

	    private void actualizarLista() {
	        listModel.removeAllElements();
	        for (String tarea : tasks) {
	            listModel.addElement(tarea);
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                new Organizador().setVisible(true);
	            }
	        });
	    }

}
