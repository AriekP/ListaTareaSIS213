import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.time.*;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class VentanaOrganizador1 extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOrganizador1 frame = new VentanaOrganizador1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private Tarea tareas;
	private List<Tarea> listtareas;
    private DefaultListModel<String> listModel;
    private JTextField txtFecha;
    private JTextField txtInicio;
    private JTextField txtFin;
    private JTable tableReporte;
    private DefaultTableModel model;
    private JLabel lblMensaje;


   
	/**
	 * Create the frame.
	 */
	public VentanaOrganizador1() {
		 setTitle("Organizador de Tareas");
	        setSize(507, 350);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        JPanel panel = new JPanel();
	        panel.setBackground(new Color(255, 185, 151));
	        getContentPane().add(panel);
	        lblMensaje = new JLabel("");
	        lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
	        lblMensaje.setBounds(61, 272, 366, 19);
	        panel.add(lblMensaje);
	        
	        // Componentes del formulario
	        JLabel lblTarea = new JLabel("Nueva Tarea:");
	        lblTarea.setFont(new Font("Tahoma", Font.BOLD, 12));
	        lblTarea.setBounds(32, 11, 156, 19);
	        JTextField txtDescripcion = new JTextField(20);
	        txtDescripcion.setBounds(102, 59, 179, 19);
	        JLabel lblDescripcion = new JLabel("Descripcion:");
	        lblDescripcion.setBounds(32, 59, 71, 19);
	        panel.add(lblDescripcion);
	        
	        JLabel lblFecha = new JLabel("Fecha:");
	        lblFecha.setBounds(32, 39, 60, 19);
	        panel.add(lblFecha);
	        
	        txtFecha = new JTextField(20);
	        txtFecha.setBounds(102, 38, 70, 19);
	        txtFecha.setToolTipText("aaaa-mm-dd");
	        panel.add(txtFecha);
	        
	        JLabel lblFHInicio = new JLabel("Inicio:");
	        lblFHInicio.setBounds(182, 39, 36, 19);
	        panel.add(lblFHInicio);
	        
	        txtInicio = new JTextField(20);
	        txtInicio.setBounds(216, 38, 65, 19);
	        txtInicio.setToolTipText("HH:mm");
	        panel.add(txtInicio);
	        
	        JLabel lblFHFin = new JLabel("Fin:");
	        lblFHFin.setBounds(319, 39, 45, 19);
	        panel.add(lblFHFin);
	        
	        txtFin = new JTextField(20);
	        txtFin.setBounds(374, 38, 65, 19);
	        txtFin.setToolTipText("HH:mm");
	        panel.add(txtFin);
	        
	        
	        JButton btnAgregar = new JButton("Agregar");
	       
	        btnAgregar.setBounds(350, 59, 89, 21);
	        listtareas =new ArrayList<Tarea>();
	        btnAgregar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	LocalDate f=LocalDate.parse(txtFecha.getText());
	            	String des=txtDescripcion.getText();
	            	LocalTime hi=LocalTime.parse(txtInicio.getText()+":00");
	            	LocalTime hf=LocalTime.parse(txtFin.getText()+":00");
	            	listtareas.add(new Tarea(f,des, hi, hf));
	            	model.setRowCount(0);
	            	llenarTabla();
	               
	                txtDescripcion.setText(""); // Limpiar el campo de texto después de agregar una tarea
	            }
	        });
	        
	        listModel = new DefaultListModel<>();
	        panel.setLayout(null);
	        

	        // Agregar componentes al panel
	        panel.add(lblTarea);
	        panel.add(txtDescripcion);
	        panel.add(btnAgregar);
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(32, 89, 428, 130);
	        panel.add(scrollPane);
	        
	        tableReporte = new JTable();
	        model=new DefaultTableModel();
	        tableReporte.setModel(model);
	        model.addColumn("Fecha");
	        model.addColumn("Descripcion");
	        model.addColumn("Inicio");
	        model.addColumn("Fin");
	        model.addColumn("Estado");
	        
	        tableReporte.getColumnModel().getColumn(0).setPreferredWidth(65);
	        tableReporte.getColumnModel().getColumn(1).setPreferredWidth(150);
	        tableReporte.getColumnModel().getColumn(2).setPreferredWidth(56);
	        tableReporte.getColumnModel().getColumn(3).setPreferredWidth(55);
	        scrollPane.setViewportView(tableReporte);
	        


	        JButton btnEliminar = new JButton("Eliminar");
	        btnEliminar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	eliminarTarea();
	            }
	        });
	        btnEliminar.setBounds(339, 230, 100, 21);
	        panel.add(btnEliminar);
	        
	        JButton btnEnCurso = new JButton("En Curso");
	        btnEnCurso.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		marcarComoEnCurso();
	        	}
	        });
	        btnEnCurso.setBounds(193, 230, 99, 21);
	        panel.add(btnEnCurso);
	        
	        JButton btnCompletado = new JButton("Completado");
	        btnCompletado.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		marcarComoCompletada();
	        	}
	        });
	        btnCompletado.setBounds(32, 230, 112, 21);
	        panel.add(btnCompletado);
	        
	        JButton btnLimpiar = new JButton("Limpiar");
	        btnLimpiar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		txtDescripcion.setText("");
	        		txtFecha.setText("");
	        		txtFin.setText("");
	        		txtInicio.setText("");
	        	}
	        });
	        btnLimpiar.setBounds(350, 7, 89, 21);
	        panel.add(btnLimpiar);
	        
	      


	        // Manejar el evento de clic en el botón "Agregar"

	}
	 private void llenarTabla() {

		            for (Tarea tareas1 : listtareas) {
		                Object[] fila = new Object[5];
		                fila[0] = tareas1.getFecha();
		                fila[1] = tareas1.getDescripcion();
		                fila[2] = tareas1.gethInicio();
		                fila[3] = tareas1.gethFin();
		                fila[4] = tareas1.getEstado();
		                
		                model.addRow(fila);
		            }
	 }
	 private void marcarComoCompletada() {
		    int filaSeleccionada = tableReporte.getSelectedRow();
		    if (filaSeleccionada != -1) {
		        Tarea tarea = listtareas.get(filaSeleccionada);
		        tarea.marcarCompletada();
		        model.setValueAt("Completada", filaSeleccionada, 4);
		        lblMensaje.setText("Tarea marcada como completada correctamente.");
		    } else {
		        lblMensaje.setText("No se ha seleccionado ninguna fila.");
		    }
		}
	 private void marcarComoEnCurso() {
		    int filaSeleccionada = tableReporte.getSelectedRow();
		    if (filaSeleccionada != -1) {
		        Tarea tarea = listtareas.get(filaSeleccionada);
		        if (tarea.getEstado().equals("Completada")) {
		            lblMensaje.setText("No se puede cambiar una tarea completada a 'En Curso'.");
		        } else {
		            tarea.marcarEnCurso();
		            model.setValueAt("En Curso", filaSeleccionada, 4);
		            lblMensaje.setText("Tarea marcada como 'En curso' correctamente.");
		        }
		    } else {
		        lblMensaje.setText("No se ha seleccionado ninguna fila.");
		    }
		}
	 private void eliminarTarea() {
		    int filaSeleccionada = tableReporte.getSelectedRow();
		    if (filaSeleccionada != -1) {
		        Tarea tarea = listtareas.get(filaSeleccionada);
		        if (tarea.getEstado().equals("Nueva")) {
		            // Eliminar la tarea de la lista
		            listtareas.remove(filaSeleccionada);
		            
		            // Eliminar la fila de la tabla
		            model.removeRow(filaSeleccionada);

		            lblMensaje.setText("Tarea eliminada correctamente.");
		        } else {
		            lblMensaje.setText("La tarea está en curso o completada.");
		        }
		    } else {
		        lblMensaje.setText("No se ha seleccionado ninguna fila.");
		    }
		}
}
