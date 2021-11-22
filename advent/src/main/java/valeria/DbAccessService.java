package valeria;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
@Getter
public class DbAccessService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcInsert jdbcInsert;

    @Autowired
    public void setJdbcInsert(DataSource dataSource){
        jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("day")
                .usingGeneratedKeyColumns("id");
    }
   // @Autowired
    //public void setJt(JdbcTemplate jdbcTemplate) {
    //    setJdbcTemplate(jdbcTemplate);
    //}

    //@Autowired
    //public void setDs(DataSource dataSource) {
    //    setDataSource(dataSource);
    //}

    //@Autowired
    //private SimpleJdbcInsert jdbcInsert;

    //@Autowired
    //public valeria.DbAccessService() {
    //    jdbcTemplate = new JdbcTemplate(dataSource);
    //    jdbcInsert = new SimpleJdbcInsert(dataSource)
    //            .withTableName("DAY")
    //            .usingGeneratedKeyColumns("ID");
    //}

    Day getDay(int date) {
        String query = "SELECT * FROM day WHERE date = ?";
        return getJdbcTemplate().queryForObject(query, new DayRowMapper(), date);
    }

    //public int insertDay(int date, ) {
    //    getJdbcTemplate().update("INSERT INTO day VALUES (?, ?, ?, ?)", )
    //    String query = ""
    //}

    int postDayActivity(int date, String activity) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("date", date);
        parameters.put("activity", activity);
        return (int) jdbcInsert.executeAndReturnKey(parameters);
    }
}
