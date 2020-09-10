package cl.awakelab.ensayo2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.awakelab.ensayo2.dao.DetalleFacturaDAO;
import cl.awakelab.ensayo2.dao.FacturaDAO;
import cl.awakelab.ensayo2.model.DetalleFactura;
import cl.awakelab.ensayo2.model.Factura;


@Controller
public class PrincipalController {
    
    static Logger log = Logger.getLogger(PrincipalController.class);

    @Autowired
    DetalleFacturaDAO dfd;

    @Autowired
    FacturaDAO fd;

    @RequestMapping({ "/index", "/" })
    public String irPortal(Model m) {
        log.log(Level.INFO, "Ingreso a index");
        return "DetalleFactura";
    }

    @RequestMapping(value = "/buscarFactura", method = RequestMethod.GET)
    public String registrarAyuda(RedirectAttributes r, HttpServletRequest request) {
        int id_factura;
        int subtotal = 0;
        int impuesto = 0;
        int total = 0;
        Factura factura;
        
        try {
            id_factura = Integer.parseInt(request.getParameter("idfact"));
        } catch (Exception e) {
            id_factura = 0;
        }
        
        r.addFlashAttribute("id", id_factura);
                
        try {
            
            factura = fd.buscarFacturaPorId(id_factura);
            r.addFlashAttribute("fact", factura);
            log.log(Level.INFO, "Busqueda de factura ID:" + id_factura);
            
            List<DetalleFactura> ldetalle = dfd.buscarDetallePorId(id_factura);
            log.log(Level.INFO, "Busqueda de detalle factura ID:" + id_factura);   
            
            for (DetalleFactura d : ldetalle) {
                subtotal += d.getProducto().getValor() * d.getCantidad();
            }
            log.log(Level.INFO, "Se calcula subtotal de factura ID " + id_factura + ", de: " + subtotal);
            
            impuesto = (int) (subtotal * (0.19));
            total = subtotal + impuesto;
            
            r.addFlashAttribute("productos", ldetalle);
            r.addFlashAttribute("sub", subtotal);
            r.addFlashAttribute("iva", impuesto);
            r.addFlashAttribute("tt", total);
            
        } catch (Exception e) {
            
            factura = null;
            log.log(Level.WARN, "No existe factura de ID: " + id_factura);
            log.log(Level.ERROR, e);
            
        }
                
        r.addFlashAttribute("mostrar", "ok");
        
        return "redirect:/index";
    }

}
