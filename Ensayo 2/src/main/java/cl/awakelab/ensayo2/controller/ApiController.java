package cl.awakelab.ensayo2.controller;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.awakelab.ensayo2.dao.ProductoDAO;
import cl.awakelab.ensayo2.model.Producto;

@RestController
public class ApiController {
    
    @Autowired
    ProductoDAO pd;
    
    static Logger log = Logger.getLogger(ApiController.class);
    
    @RequestMapping(value = "/api/listap/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Producto> getProductos (@PathVariable int id) {
            try {
                
                List<Producto> lproductos = pd.listarProductosXCategoria(id);
                log.log(Level.INFO, "Carga exitosa productos por ID de categoría: " + id + " desde BD");  
                return lproductos;
                
            } catch (Exception e) {
                
                log.log(Level.ERROR, e);
                return null;
                
            }
            
            
    }

}
