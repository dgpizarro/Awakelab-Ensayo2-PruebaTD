package cl.awakelab.ensayo2.junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.awakelab.ensayo2.dao.DetalleFacturaDAO;
import cl.awakelab.ensayo2.model.DetalleFactura;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class DetalleFacturaDAOTest {
    
    @Autowired
    DetalleFacturaDAO dfd;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testBuscarDetallePorId() {
        List<DetalleFactura> detalle = dfd.buscarDetallePorId(1);
        assertEquals("Cama 1 plaza", detalle.get(0).getProducto().getNombre());
        assertEquals(12790, detalle.get(1).getProducto().getValor());
        assertEquals(3, detalle.get(2).getCantidad());
    }

}
