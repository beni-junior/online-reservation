package ir.hatami.onlinereservation.management;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class JdbcConnection implements InitializingBean {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(">>>> selecting\n\n\n\n");
        jdbcTemplate.query(con -> con.prepareStatement("select * from tb_appointment"),
                rs -> {
                    while (rs.next()) {
                        int createdAt = rs.findColumn("id");
                        byte[] object = rs.getBytes("id");
                        System.out.println("object = " +  toUUID(object));
                    }
                }
        );
//        PreparedStatement execute = (PreparedStatement) jdbcTemplate.execute("select * from tb_appointment", new PreparedStatementCallback<Object>() {
//            @Override
//            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
//               return ps;
//            }
//        });
//        ResultSet resultSet = execute.executeQuery();
//        while (resultSet.next()) {
//        }
    }

    static UUID toUUID(byte[] bytes) {
        if (bytes.length != 16) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        long msl = 0;
        for (; i < 8; i++) {
            msl = (msl << 8) | (bytes[i] & 0xFF);
        }
        long lsl = 0;
        for (; i < 16; i++) {
            lsl = (lsl << 8) | (bytes[i] & 0xFF);
        }
        return new UUID(msl, lsl);
    }
}
