package cl.awakelab.ensayo2.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.awakelab.ensayo2.dao.FacturaDAO;
import cl.awakelab.ensayo2.model.Factura;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class FacturaDAOTest {

    @Autowired
    FacturaDAO fd; 
    
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testBuscarFacturaPorId() {
        Factura f = fd.buscarFacturaPorId(1);
        assertEquals("Diego Abarca", f.getCliente());
        assertEquals("04-08-2020", f.getFecha());
    }

}
