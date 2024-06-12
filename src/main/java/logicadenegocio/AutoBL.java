package logicadenegocio;

import accesoadatos.AutoDAL;
import entidadesdenegocio.Auto;

import java.sql.SQLException;
import java.util.ArrayList;

public class AutoBL {
    //Metodo de la clase que devuelven la funcionabilidad de los métodos de la clase DAL
    public int guardar(Auto auto) throws SQLException{
        return AutoDAL.guardar(auto);
    }

    public int modificar(Auto auto) throws SQLException{
        return AutoDAL.modificar(auto);
    }

    public int eliminar(Auto auto) throws SQLException{
        return AutoDAL.eliminar(auto);
    }

    public ArrayList<Auto> obtenerTodos() throws SQLException{
        return AutoDAL.obtenerTodos();
    }

    public ArrayList<Auto> obtenerDatosFiltrados(Auto auto) throws SQLException{
        return AutoDAL.obtenerDatosFiltrados(auto);
    }
}
