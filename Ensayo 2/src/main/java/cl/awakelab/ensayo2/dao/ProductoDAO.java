package cl.awakelab.ensayo2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.awakelab.ensayo2.model.Producto;

public class ProductoDAO {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public class ProductoMapper implements RowMapper<Producto> {
        public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
            Producto p = new Producto();
            p.setProductoid(rs.getInt(1));
            p.setNombre(rs.getString(2));
            p.setValor(rs.getInt(3));
            return p;
        }
    }

    public List<Producto> listarProductosXCategoria(int id) {
        String sql = "select productoid, p.nombre, valor from producto p inner join categoria c on"
                + " (p.categoriaid = c.categoriaid) where p.categoriaid = " + id;
        return template.query(sql, new ProductoMapper());
    }

}
