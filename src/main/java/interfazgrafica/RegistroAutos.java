package interfazgrafica;

import entidadesdenegocio.Auto;
import logicadenegocio.AutoBL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

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
    private JTextField txtModelo;
    private JTextField txtAnio;
    private JTextField txtColor;
    private JTextField txtPropietario;
    private JButton btnEditar;
    private JButton btnGuardar;
    private JRadioButton rbdId;
    private JRadioButton rdbMarca;
    private JRadioButton rdbColor;
    private JTextField txtMarca;
    private JTable tbAuto;
    private ButtonGroup criterioBusqueda;

    // instancias propias
    ArrayList<Auto> listAuto;
    Auto cars;
    AutoBL autoBL = new AutoBL();

    public static void main(String[] args) throws SQLException {
        new RegistroAutos();
    }


    public RegistroAutos() throws SQLException {
        inicializar();
        actualizarForm();

        //funcionalidad del boton nuevo
        btnAgregar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                txtPlaca.setEnabled((true));
                txtMarca.setEnabled((true));
                txtModelo.setEnabled((true));
                txtAnio.setEnabled((true));
                txtColor.setEnabled((true));
                txtPropietario.setEnabled((true));
                txtPlaca.grabFocus();
                btnGuardar.setEnabled(true);
                btnAgregar.setEnabled(false);
                btnCancelar.setEnabled(true);

            }
        });

        btnGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                cars = new Auto();
                cars.setPlaca(txtPlaca.getText());
                cars.setMarca(txtMarca.getText());
                cars.setModelo(txtModelo.getText());
                cars.setAnio(Integer.parseInt(txtAnio.getText()));
                cars.setColor(txtColor.getText());
                cars.setPropietario(txtPropietario.getText());

                try {
                    autoBL.guardar(cars);
                    JOptionPane.showMessageDialog(null, "¡SE GUARDO CORRECTAMENTE!");
                    actualizarForm();
                }
                catch (SQLException ex){
                    throw  new RuntimeException( ex);
                }

            }
        });


        btnSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });

        btnCancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try{
                    actualizarForm();
                } catch (SQLException ex ){
                    throw  new RuntimeException(ex);
                }

            }
        });


        tbAuto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int fila = tbAuto.getSelectedRow();
                txtId.setText(tbAuto.getValueAt(fila,0) .toString());
                txtPlaca.setText(tbAuto.getValueAt(fila, 1) .toString());
                txtMarca.setText(tbAuto.getValueAt(fila, 2) .toString());
                txtModelo.setText(tbAuto.getValueAt(fila, 3) .toString());
                txtAnio.setText(tbAuto.getValueAt(fila, 4) .toString());
                txtColor.setText(tbAuto.getValueAt(fila, 5) .toString());
                txtPropietario.setText(tbAuto.getValueAt(fila, 6) .toString());

                txtPlaca.setEnabled(true);
                txtMarca.setEnabled(true);
                txtModelo.setEnabled(true);
                txtAnio.setEnabled(true);
                txtColor.setEnabled(true);
                txtPropietario.setEnabled(true);
                txtPlaca.grabFocus();

                btnAgregar.setEnabled(false);
                btnEditar.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnCancelar.setEnabled(true);
            }
        });

        btnEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cars = new Auto();
                cars.setId(Integer.parseInt(txtId.getText()));
                cars.setPlaca(txtPlaca.getText());
                cars.setMarca(txtMarca.getText());
                cars.setModelo(txtModelo.getText());
                cars.setAnio(Integer.parseInt(txtAnio.getText()));
                cars.setColor(txtColor.getText());
                cars.setPropietario(txtPropietario.getText());

                try {
                    autoBL.modificar(cars);
                    JOptionPane.showMessageDialog(null, "¡SE EDITO EXITOSAMENTE!");
                    actualizarForm();
                }
                catch (SQLException ex){
                    throw  new RuntimeException( ex);
                }

            }
        });


        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cars = new Auto();
                cars.setId(Integer.parseInt(txtId.getText()));

                try{
                    autoBL.eliminar(cars);
                    JOptionPane.showMessageDialog(null,"¡SE ELIMINO CON EXITO!");
                   actualizarForm();
                } catch (SQLException ex){
                    throw  new RuntimeException(ex );
                }

            }
        });
        btnBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(txtBuscar.getText().equals("") || (!rbdId.isSelected() &&
                        !rdbMarca.isSelected() && !rdbColor.isSelected())){
                    JOptionPane.showMessageDialog(null,"SELECCIONÉ UN CRITERIO DE BÚSQUEDA");

                }

                cars = new Auto();
                if(rbdId.isSelected()){
                    cars.setId(Integer.parseInt(txtBuscar.getText()));
                    try{
                        llenarTabla(autoBL.obtenerDatosFiltrados(cars));
                    } catch (SQLException ex){
                        throw new RuntimeException(ex);
                    }
                }
                if(rdbMarca.isSelected()){
                    cars.setMarca(txtBuscar.getText());
                    try{
                        llenarTabla(autoBL.obtenerDatosFiltrados(cars));
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                if(rdbColor.isSelected()){
                    cars.setColor(txtBuscar.getText());
                    try{
                        llenarTabla(autoBL.obtenerDatosFiltrados(cars));
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }


            }
        });
    }
    void inicializar(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 700);
        setTitle("Control de Autos");
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        criterioBusqueda = new ButtonGroup();
        criterioBusqueda.add(rbdId);
        criterioBusqueda.add(rdbMarca);
        criterioBusqueda.add(rdbColor);


        setContentPane(jpPrincipal);
        setVisible(true);
    }

    void llenarTabla(ArrayList<Auto> autos){
        Object[] obj = new Object[7];
        listAuto = new ArrayList<>();
        String[] encabezado = {"Id","Placa","Marca","Modelo","Anio","Color","propietario"};
        DefaultTableModel tm = new DefaultTableModel(null, encabezado);
        listAuto.addAll(autos);
        for(Auto item : listAuto){
            obj[0] = item.getId();
            obj[1] = item.getPlaca();
            obj[2] = item.getMarca();
            obj[3] = item.getModelo();
            obj[4] = item.getAnio();
            obj[5] = item.getColor();
            obj[6] = item.getPropietario();

            tm.addRow(obj);
        }
        tbAuto.setModel(tm);
    }

    void actualizarForm() throws SQLException{
        txtId.setText("");
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtAnio.setText("");
        txtColor.setText("");
        txtPropietario.setText("");

        txtPlaca.setEnabled(false);
        txtMarca.setEnabled(false);
        txtModelo.setEnabled(false);
        txtAnio.setEnabled(false);
        txtColor.setEnabled(false);
        txtPropietario.setEnabled(false);


        btnAgregar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(false);

        criterioBusqueda.clearSelection();
        txtBuscar.setText("");

        llenarTabla(autoBL.obtenerTodos());
    };



}
