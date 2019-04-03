package Views;

import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Carlos Contreras
 */
public class BajaView extends JDialog implements ActionListener {

    private JLabel lbCuenta;
    private JTextField txtCuenta;
    private JButton btnBuscar, btnBaja, btnCancelar;
    
    public BajaView() {
        setTitle("Baja");
        setSize(310, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
        
        lbCuenta = new JLabel("Cuenta");
        lbCuenta.setBounds(50, 30, 50, 20);
        add(lbCuenta);
        
        txtCuenta = new JTextField();
        txtCuenta.setBounds(110, 25, 150, 30);
        add(txtCuenta);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(15, 170, 90, 30);
        btnBuscar.addActionListener(this);
        add(btnBuscar);
        
        btnBaja = new JButton("Baja");
        btnBaja.setBounds(btnBuscar.getX() + btnBuscar.getWidth() + 5, 170, 90, 30);
        btnBaja.addActionListener(this);
        add(btnBaja);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(btnBaja.getX() + btnBaja.getWidth() + 5, 170, 90, 30);
        btnCancelar.addActionListener(this);
        add(btnCancelar);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if(btnBuscar == evt.getSource()) {
            // TODO: Buscar
            
            return;
        }
        if(btnBaja == evt.getSource()) {
            // TODO: Dar de baja
            
            // Mensaje que diga "La Cuenta se ha dado de baja correctamente" (? Fuera cambiar de JDialog a JFrame
            return;
        }
        if(btnCancelar == evt.getSource()) {
            this.dispose();
            return;
        }
    }

}
