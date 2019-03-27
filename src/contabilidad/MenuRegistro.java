package contabilidad;

import javax.swing.*;
import java.awt.event.*;


/**
 *
 * @author Carlos Contreras
 */
public class MenuRegistro extends JDialog implements ActionListener {
    
    private JLabel lbCuenta, lbNombre, lbSaldo;
    private JTextField txtCuenta, txtNombre, txtSaldo;
    private JButton btnAñadir, btnCancelar;
    
    // TODO: Hacer que no se pueda cerrar

    public MenuRegistro() {
        setTitle("Registro");
        setSize(300, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
        
        lbCuenta = new JLabel("Cuenta");
        lbCuenta.setBounds(50, 30, 50, 20);
        add(lbCuenta);
        
        lbNombre = new JLabel("Nombre");
        lbNombre.setBounds(50, 70, 50, 20);
        add(lbNombre);
        
        lbSaldo = new JLabel("Saldo");
        lbSaldo.setBounds(50, 110, 50, 20);
        add(lbSaldo);
        
        txtCuenta = new JTextField();
        txtCuenta.setBounds(110, 25, 150, 30);
        add(txtCuenta);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(110, 65, 150, 30);
        add(txtNombre);
        
        txtSaldo = new JTextField();
        txtSaldo.setBounds(110, 105, 150, 30);
        add(txtSaldo);
        
        btnAñadir = new JButton("Añadir");
        btnAñadir.setBounds(50, 170, 100, 30);
        btnAñadir.addActionListener(this);
        add(btnAñadir);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(160, 170, 100, 30);
        btnCancelar.addActionListener(this);
        add(btnCancelar);
    
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if(btnAñadir == evt.getSource()) {
            // TODO: Método guardar
            return;
        }
        if(btnCancelar == evt.getSource()) {
            this.dispose();
            return;
        }
    }
    
    

}
