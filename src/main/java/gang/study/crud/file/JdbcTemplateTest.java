package gang.study.crud.file;

import gang.study.crud.file.domain.entity.CooconData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateTest {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateTest(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Over
    public List<CooconData> selectAll() {
        return jdbcTemplate.query("select * from coocon_data");
    }
}
