package utils

import java.util.Properties

object Constants {
    val url: String = "jdbc:mysql://192.168.1.127:3306/soukebao"
    //查找的表名
    val table: String = "soukebao.sk_log"
    //增加数据库的用户名(user)密码(password),指定test数据库的驱动(driver)
    val connectionProperties: Properties = new Properties
    connectionProperties.put("user", "root")
    connectionProperties.put("password", "")
    connectionProperties.put("driver", "com.mysql.jdbc.Driver")
}
