package cn.itcast;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // 数据库连接相关配置，可以根据实际情况修改
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/keshe?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // 加载数据库驱动
            Class.forName(JDBC_DRIVER);

            // 打开数据库连接
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // 构造 SQL 语句，查询用户名和密码是否匹配
            String sql = "SELECT COUNT(*) AS count FROM users WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            // 处理查询结果
            if (rs.next() && rs.getInt("count") > 0) {
                // 用户名和密码匹配，登录成功
                request.getSession().setAttribute("username", username);
//                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                // 用户名和密码不匹配，登录失败
                request.setAttribute("message", "用户名或密码错误！");
//                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Server Error: " + e.getMessage());
        } finally {
            // 关闭数据库连接
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
