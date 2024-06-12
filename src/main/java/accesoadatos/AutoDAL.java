package accesoadatos;

import entidadesdenegocio.Auto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutoDAL {
    // método que muestra todos los registros de la tabla
    public static ArrayList<Auto> obtenerTodos() throws SQLException {
        ArrayList<Auto> lista = new ArrayList<>();
        Auto autos;
        try{
            String sql = "SELECT Id, Placa, Marca, Modelo, Anio,Color, Propietario FROM Autos";
            Connection conexion = ComunDB.obtenerConexion();
            PreparedStatement ps = ComunDB.crearPreparedStatement(conexion, sql);
            ResultSet rs = ComunDB.obtenerResultSet(ps);
            while (rs.next()){
                autos = new Auto(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getInt(5),rs.getString(6),rs.getString(7));
                lista.add(autos);
            }
            conexion.close();
            ps.close();
            rs.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return lista;
    }
    // método que permite guardar un nuevo registro
    public static int guardar(Auto auto) throws SQLException{
        int result = 0;
        try {
            String sql = "INSERT INTO Autos( Placa, Marca, Modelo,Color, Anio, Propietario) VALUES(?, ?, ?, ?,?,?)";
            Connection conexion = ComunDB.obtenerConexion();
            PreparedStatement ps = ComunDB.crearPreparedStatement(conexion, sql);
            ps.setString(1, auto.getPlaca());
            ps.setString(2, auto.getMarca());
            ps.setString(3, auto.getModelo());
            ps.setString(4, auto.getColor());
            ps.setInt(5, auto.getAnio());
            ps.setString(6, auto.getPropietario());
            result = ps.executeUpdate();
            conexion.close();
            ps.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    // método que permite modificar un registro existente
    public static int modificar(Auto auto) throws SQLException {
        int result = 0;
        Connection conexion = null;
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE Autos SET Placa = ?, Marca = ?, Modelo = ?, anio = ?, Color = ?, Propietario = ? WHERE Id = ?";
            conexion = ComunDB.obtenerConexion();
            ps = ComunDB.crearPreparedStatement(conexion, sql);
            ps.setString(1, auto.getPlaca());
            ps.setString(2, auto.getMarca());
            ps.setString(3, auto.getModelo());
            ps.setInt(4, auto.getAnio());
            ps.setString(5, auto.getColor());
            ps.setString(6, auto.getPropietario());
            ps.setInt(7, auto.getId());

            result = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
        return result;
    }

    // método que permite eliminar un registro existente
    public static int eliminar(Auto auto) throws SQLException{
        int result = 0;
        try {
            String sql = "DELETE FROM Autos WHERE Id = ?";
            Connection conexion = ComunDB.obtenerConexion();
            PreparedStatement ps = ComunDB.crearPreparedStatement(conexion, sql);
            ps.setInt(1, auto.getId());
            result = ps.executeUpdate();
            conexion.close();
            ps.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    // método para consultar mediante criterios
    public static ArrayList<Auto> obtenerDatosFiltrados(Auto auto) throws SQLException{
        ArrayList<Auto> lista = new ArrayList<>();
        Auto est;
        try{
            String sql = "SELECT id, placa, marca, modelo, anio , color , propietario FROM Autos WHERE id = ? or marca like'%" + auto.getMarca() + "%' or color like'%" + auto.getColor() + "%'";
            Connection connection = ComunDB.obtenerConexion();
            PreparedStatement ps = ComunDB.crearPreparedStatement(connection, sql);
            ps.setInt(1, auto.getId());
            ResultSet rs = ComunDB.obtenerResultSet(ps);
            while (rs.next()){
                est = new Auto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
                lista.add(est);
            }
            connection.close();
            ps.close();
            rs.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

}
