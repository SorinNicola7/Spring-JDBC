package cerinta3;

import java.sql.ResultSet;
import java.sql.SQLException;
// IMPORTUL ASTA ESTE CRITIC:
import org.springframework.jdbc.core.RowMapper; 


public class MasinaMapper implements RowMapper<Masina> {
    
    @Override 
    public Masina mapRow(ResultSet rs, int rowNum) throws SQLException {
        Masina m = new Masina();
        m.setNrInmatriculare(rs.getString("nr_inmatriculare"));
        m.setMarca(rs.getString("marca"));
        m.setAnFabricatie(rs.getInt("an_fabricatie"));
        m.setCuloare(rs.getString("culoare"));
        m.setNrKm(rs.getInt("nr_km"));
        return m;
    }
}