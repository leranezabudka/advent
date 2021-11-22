package valeria;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DayRowMapper implements RowMapper<Day> {

    @Override
    public Day mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Day day = new Day();
        day.setId(resultSet.getInt("ID"));
        day.setDate(resultSet.getInt("DATE"));
        day.setActivity(resultSet.getString("ACTIVITY"));
        return day;
    }
}
