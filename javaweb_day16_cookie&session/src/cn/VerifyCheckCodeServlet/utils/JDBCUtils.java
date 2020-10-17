package cn.VerifyCheckCodeServlet.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author wyl
 * @create 2020-10-16
 * @Description
 * @Version
 */
public class JDBCUtils {

    public static DataSource getDataSource() {
        return dataSource;
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private static DataSource dataSource;
    static {
        try {
            Properties properties  = new Properties();
            InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("cn\\VerifyCheckCodeServlet\\druid.properties"); //注意路径
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
