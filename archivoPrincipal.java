import javax.swing.*;
 
/**
 * ESTA CLASE DEBE HEREDAR DE JFRAME PARA PODER
 * CREAR LA VENTANA DE NUESTRA INTERFAZ
 */
public class PintarVentana extends JFrame{
     
    /* Esta variable no es necesaria, pero si
     * muy recomendable, ya que nos evitar problemas
     * si hay futuras actualizaciones de la aplicacion*/
    private static final long serialVersionUID = 1L;
 
    public JPanel lamina = new JPanel(); 
     
 
    public PintarVentana() {
          
        this.setSize(450, 300);
         
        this.setTitle("Colorear ventanas");
          
        // Lo centramos en pantalla
        this.setLocationRelativeTo(null);
          
        /* Le decimos que no se puede redimensionar*/
        this.setResizable(false);
          
        // Le decimos que al cerrar la ventana, acabe el programa
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
       
        this.getContentPane().add(lamina);
    }
}
