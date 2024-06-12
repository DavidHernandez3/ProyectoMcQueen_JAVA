import accesoadatos.AutoDAL;
import entidadesdenegocio.Auto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class AutoDALTest {
    @Test
    public void guardarTest() throws SQLException{
        Auto auto = new Auto();
        auto.setPlaca("ABC12345");
        auto.setMarca("Toyota");
        auto.setModelo("Camry");
        auto.setAnio(2020);
        auto.setColor("Rojo");
        auto.setPropietario("Dracula");

        int esperando = 1;
        int actual = AutoDAL.guardar(auto);
        Assertions.assertEquals(esperando, actual);
    }

    @Test
    public void obtenerTodosTest() throws  SQLException{
        int esperando = 4;
        int actual = AutoDAL.obtenerTodos().size();
        Assertions.assertEquals(esperando, actual);
    }
    @Test
    public void modificarTest() throws  SQLException{
        Auto auto = new Auto();
        auto.setId(4);
        auto.setPlaca("ABC1234");
        auto.setMarca("Toyota");
        auto.setModelo("Camry");
        auto.setAnio(2020);
        auto.setColor("Rojo");
        auto.setPropietario("Dracula PocaSangre");

        int esperando = 1;
        int actual = AutoDAL.modificar(auto);
        Assertions.assertEquals(esperando, actual);

    }
      @Test
    public void eliminarTest() throws  SQLException{
        Auto auto = new Auto();
        auto.setId(1);

        int esperando = 1;
        int actual = AutoDAL.eliminar(auto);
        Assertions.assertEquals(esperando, actual);
      }
     @Test
    public void obtenerDatosFiltradosTest() throws SQLException{
        Auto auto = new Auto();
        auto.setPlaca("ABC12345");
        auto.setId(0);
        auto.setColor("");

        int actual = AutoDAL.obtenerDatosFiltrados(auto).size();
        Assertions.assertNotEquals(0, actual);


     }
}
