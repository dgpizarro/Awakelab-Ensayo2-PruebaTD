package cl.awakelab.ensayo2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.awakelab.ensayo2.model.DetalleFactura;
import cl.awakelab.ensayo2.model.Producto;

public class DetalleFacturaDAO {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public class DetalleFacturaMapper implements RowMapper<DetalleFactura> {
        public DetalleFactura mapRow(ResultSet rs, int rowNum) throws SQLException {
            DetalleFactura df = new DetalleFactura();
            Producto p = new Producto();
            p.setNombre(rs.getString(1));
            p.setValor(rs.getInt(2));
            df.setCantidad(rs.getInt(3));
            df.setProducto(p);
            return df;
        }
    }

    public List<DetalleFactura> buscarDetallePorId(int id) {
        String sql = "select nombre, valor, cantidad from producto p inner join detallefactura d"
                + " on (p.productoid = d.productoid) where facturaid = " + id + " order by 1 asc";
        return template.query(sql, new DetalleFacturaMapper());
    }

}
