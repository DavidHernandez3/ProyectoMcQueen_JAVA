package interfazgrafica;

import javax.swing.*;

public class RegistroAutos {
    private JPanel jPanel;
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

    public static void main(String[] args) {
        new RegistroAutos();
    }
}
