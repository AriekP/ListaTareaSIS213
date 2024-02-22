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
import java.awt.Button;

public class VentanaOrganizador extends JFrame {


	 private List<String> tasks = new ArrayList<>();
	    private DefaultListModel<String> listModel;

	    public VentanaOrganizador() {
	        setTitle("Organizador de Tareas");
	        setSize(410, 329);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        JPanel panel = new JPanel();
	        getContentPane().add(panel);

	        // Componentes del formulario
	        JLabel lblTarea = new JLabel("Nueva Tarea:");
	        lblTarea.setBounds(5, 63, 62, 13);
	        JTextField txtTarea = new JTextField(20);
	        txtTarea.setBounds(72, 60, 166, 19);
	        JButton btnAgregar = new JButton("Agregar");
	        btnAgregar.setBounds(243, 59, 69, 21);
	        listModel = new DefaultListModel<>();
	        panel.setLayout(null);

	        // Agregar componentes al panel
	        panel.add(lblTarea);
	        panel.add(txtTarea);
	        panel.add(btnAgregar);
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(32, 89, 258, 130);
	        panel.add(scrollPane);
	        JList<String> lstTareas = new JList<>();
	        scrollPane.setViewportView(lstTareas);
	        lstTareas.setModel(listModel);
	        
	       
	        JButton btnNewButton_1 = new JButton("Eliminar");
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		 eliminarTarea(lstTareas.getSelectedIndex());
	        	}
	        });
	        btnNewButton_1.setBounds(103, 229, 85, 21);
	        panel.add(btnNewButton_1);

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

	    
	    private void eliminarTarea(int index) {
	        if (index >= 0 && index < tasks.size()) {
	            tasks.remove(index);
	            actualizarLista();
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
