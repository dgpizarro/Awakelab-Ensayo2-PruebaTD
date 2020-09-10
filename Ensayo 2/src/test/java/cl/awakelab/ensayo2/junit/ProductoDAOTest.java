package cl.awakelab.ensayo2.junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.awakelab.ensayo2.dao.ProductoDAO;
import cl.awakelab.ensayo2.model.Producto;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductoDAOTest {
    
    @Autowired
    ProductoDAO pd;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testListarProductosXCategoria() {
        List<Producto> productos = pd.listarProductosXCategoria(1);
        assertEquals("Ventilador sobremesa", productos.get(0).getNombre());
        assertEquals(25480, productos.get(1).getValor());       
    }

}
