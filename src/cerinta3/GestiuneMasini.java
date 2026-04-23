package cerinta3;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import java.time.Year; // Pentru calculul anului curent

public class GestiuneMasini {
    private JdbcTemplate jdbcTemplateObject;

    
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    // a. Adaugare masina in BD
    public void adaugaMasina(String nr, String marca, int an, String culoare, int km) {
        String SQL = "insert into masini (nr_inmatriculare, marca, an_fabricatie, culoare, nr_km) values (?, ?, ?, ?, ?)";
        jdbcTemplateObject.update(SQL, nr, marca, an, culoare, km);
        System.out.println("-> Succes: Masina a fost adaugata!");
    }

    // b. Stergere masina
    public void stergeMasina(String nrInmatriculare) {
        String SQL = "delete from masini where nr_inmatriculare = ?";
        jdbcTemplateObject.update(SQL, nrInmatriculare);
        System.out.println("-> Succes: Masina stearsa (daca a existat).");
    }

    // c. Cautare masina
    public Masina cautaMasina(String nrInmatriculare) {
        String SQL = "select * from masini where nr_inmatriculare = ?";
        try {
            return jdbcTemplateObject.queryForObject(SQL, new Object[]{nrInmatriculare}, new MasinaMapper());
        } catch (Exception e) {
            return null; // Returnam null daca nu gasim nimic
        }
    }

    // d. Afisare toate masinile
    public List<Masina> getToateMasinile() {
        String SQL = "select * from masini";
        return jdbcTemplateObject.query(SQL, new MasinaMapper());
    }

    // e. Numar masini de o anumita marca
    public int numarMasiniMarca(String marca) {
        String SQL = "select count(*) from masini where marca = ?";
        // queryForObject poate returna direct un Integer
        return jdbcTemplateObject.queryForObject(SQL, new Object[]{marca}, Integer.class);
    }

    // f. Numar masini sub 100.000 km
    public int numarMasiniSub100k() {
        String SQL = "select count(*) from masini where nr_km < 100000";
        return jdbcTemplateObject.queryForObject(SQL, Integer.class);
    }

    // g. Masini mai noi de 5 ani
    public List<Masina> getMasiniNoi() {
        // Calculam anul limita (Anul curent - 5)
        int anLimita = Year.now().getValue() - 5;
        String SQL = "select * from masini where an_fabricatie > ?";
        return jdbcTemplateObject.query(SQL, new Object[]{anLimita}, new MasinaMapper());
    }
}