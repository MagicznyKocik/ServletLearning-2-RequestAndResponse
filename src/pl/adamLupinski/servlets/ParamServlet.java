package pl.adamLupinski.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // request part

        // // use this with writing multiple parameters after url to this servlet exmaple: http://localhost:8080/ParamServlet?name=Adam&hobby=JavaProgramming&hobby=calishtenics&hobby=RPG Games

        // uncomment below lane if you want to push parameters with polish special signs
        // request.setCharacterEncoding("UTF-8");


        // define and get parameters from request (one key may have multiple values that's why Map<K, V> = Map<String, String[]>
        Map<String, String[]> parameterMap = request.getParameterMap();

        //print out on terminal all keys with their parameters
        for (String key: parameterMap.keySet()){
            System.out.println(key);
            for (String value: parameterMap.get(key)){
                System.out.println("    - " + value );
            }
        }

        // response part

        // set response content type and character encoding
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // define writer and get parameters from response
        PrintWriter writer = response.getWriter();

        // print response parameters on site ( same code as above but with html langage markups
        writer.println("<html>");
        for (String key: parameterMap.keySet()){
            writer.println("<div>");
            writer.println(key);
            writer.println("</div>");
            for (String value: parameterMap.get(key)){
                writer.println("<div>");
                writer.println("&nbsp&nbsp-" + value); // &nbsp is hardspaces on html
                writer.println("</div>");
            }
        }

    }


}
