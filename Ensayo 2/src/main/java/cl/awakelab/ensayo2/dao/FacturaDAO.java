package cl.awakelab.ensayo2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.awakelab.ensayo2.model.Factura;

public class FacturaDAO {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    
    static Logger log = Logger.getLogger(FacturaDAO.class);

    public class FacturaMapper implements RowMapper<Factura> {
        public Factura mapRow(ResultSet rs, int rowNum) throws SQLException {
            Factura f = new Factura();
            f.setFacturaid(rs.getInt(1));
            f.setCliente(rs.getString(2));
            f.setFecha(rs.getString(3));
            return f;
        }
    }

    public Factura buscarFacturaPorId(int id) {
        String sql = "select facturaid, cliente, fecha from factura where facturaid = ?";
        return template.queryForObject(sql, new Object[] { id }, new FacturaMapper());        
    }

}
