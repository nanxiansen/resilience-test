package com.test.util.resilience.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.Optional;

/**
 * @author zhangnan
 * @date 2019/08/13 15:43
 */
public class JettyServer {

    private int port;

    public JettyServer(int port) {
        this.port = port;
    }

    private void run() {
        try {
            Server server = new Server(port);
            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");
            context.addServlet(new ServletHolder(new TestServlet()), "/test");
            server.setHandler(context);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = Optional.ofNullable(args)
                .filter(arguments -> arguments.length > 0)
                .map(arguments -> Integer.parseInt(arguments[0]))
                .orElse(9080);
        new JettyServer(port).run();
    }
}
