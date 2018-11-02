import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.net.URLDecoder;

@WebServlet("/servlet/register")
public class RegisterUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 此处拿到的是中文编码的内容，所以先设置请求的编码
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(URLDecoder.decode(username, "UTF-8"));

        // 此处返回页面的编码是ISO-8859-1，我们把它设置成utf-8，解决中文乱码
        resp.setContentType("text/html; charset=utf-8");
        Writer wt = resp.getWriter();
        System.out.println("我要显示:" + username);
        wt.append(String.format("<h1>注册成功！%s，差不多是这样咯</h1>", username));
        resp.sendRedirect("../login.jsp");
    }
}
