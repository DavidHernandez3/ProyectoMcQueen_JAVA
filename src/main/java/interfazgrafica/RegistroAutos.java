package interfazgrafica;

import javax.swing.*;
import java.sql.SQLException;

public class RegistroAutos extends JFrame {
    private JPanel jpPrincipal;
    private JTextField txtId;
    private JButton salirButton;
    private JButton registrarAutoButton;
    private JButton cancelarButton;
    private JButton eliminarButton;
    private JTextField txtBuscar;
    private JRadioButton placaRadioButton;
    private JButton BUSCARButton;
    private JTextField txtPlaca;
    private JTextField txtNombre;
    private JTextField txtModelo;
    private JTextField txtAnio;
    private JTextField txtColor;
    private JTextField txtPropietario;
    private JButton EditarBtn;
    private JRadioButton NombreRadioButton;
    private JRadioButton ModeloRadioButton;
    private JRadioButton AnioRadioButton;
    private JRadioButton PropietarioRadioButton;

    public static void main(String[] args) throws SQLException {
        new RegistroAutos();
    }

    public RegistroAutos() throws SQLException {
        inicializar();
    }
    void inicializar(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 700);
        setTitle("Control de Estudiantes");
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);



        setContentPane(jpPrincipal);
        setVisible(true);
    }

}
