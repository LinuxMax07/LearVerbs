
package servlets;

import bd.ConexionMongo;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tree_Linux
 */
@WebServlet(name = "mostrar", urlPatterns = {"/mostrar"})
public class mostrar extends HttpServlet {

  

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         ConexionMongo conexion=new ConexionMongo();
            Gson gson=new Gson();
            String userJson=gson.toJson(conexion.mostrar());
            PrintWriter printWriter=response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            printWriter.write(userJson);
            System.out.println(userJson);
       
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
