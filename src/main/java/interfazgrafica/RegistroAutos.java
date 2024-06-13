package interfazgrafica;

import javax.swing.*;
import java.sql.SQLException;

public class RegistroAutos extends JFrame {
    private JPanel jpPrincipal;
    private JTextField txtId;
    private JButton btnSalir;
    private JButton btnAgregar;
    private JButton btnCancelar;
    private JButton btnEliminar;
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private JTextField txtPlaca;
    private JTextField txtNombre;
    private JTextField txtModelo;
    private JTextField txtAnio;
    private JTextField txtColor;
    private JTextField txtPropietario;
    private JButton btnEditar;
    private JButton btnGuardar;
    private JRadioButton rbdId;
    private JRadioButton rdbMarca;
    private JRadioButton rdbColor;

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
