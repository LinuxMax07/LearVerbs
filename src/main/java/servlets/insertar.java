
package servlets;

import bd.ConexionMongo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.verbo;

/**
 *
 * @author Tree_Linux
 */
@WebServlet(name = "insertar", urlPatterns = {"/insertar"})
public class insertar extends HttpServlet {




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try (PrintWriter out = response.getWriter()) {
             verbo verb=new verbo();
             ConexionMongo conexion=new ConexionMongo();
             verb.setInfinitive(request.getParameter("infinitive"));
             verb.setSimplePast(request.getParameter("simplePast"));
             verb.setPastParticiple(request.getParameter("pastParticiple"));
             verb.setSpanish(request.getParameter("spanish"));
         
             
            conexion.insertar(verb);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertarUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            System.out.println("Registro insertado correctamete");
            out.println("<h1>Datos Insertado Correctamente</h1>");
            out.println("</body>");
            out.println("</html>");
           
        
         }
  
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
