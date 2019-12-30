package v2;

import java.io.IOException;

public class LoginServlet extends v2.servlet.HttpServlet {
    @Override
    public void doGet(Request req,Response resp) throws IOException {
        String username=req.parameters.get("username");
        if(username==null){
            resp.setStatus("401 Unauthorized");
            resp.println("<h1>请登录</h1>");
            return;
        }
        resp.setHeader("set-Coookie","username="+username);
        resp.print("<h1>欢迎"+username+"光临<h2>");
    }
}
