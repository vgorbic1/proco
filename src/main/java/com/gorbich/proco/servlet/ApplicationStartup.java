package com.gorbich.proco.servlet;

import com.gorbich.proco.application.Proco;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Properties;

/**
 * Application Startup Servlet.
 * The servlet performs initialization
 * for the Proco application
 * @author Vlad Gorbich
 */
public class ApplicationStartup extends HttpServlet {
    private Properties properties;

    /**
     * The method initializes the application loading Property file.
     * @throws ServletException
     */
    public void init() throws ServletException {
        loadProperties("/proco.properties");
        ServletContext context = getServletContext();
        Proco proco = new Proco(properties);
        context.setAttribute("proco", proco);
    }


    /**
     * The method loads properties from the properties file.
     * @param propertiesFilePath path to properties file.
     * @exception IOException
     * @exception Exception
     */
    public void loadProperties(String propertiesFilePath) {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch(IOException ioException) {
            ioException.printStackTrace();
        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}