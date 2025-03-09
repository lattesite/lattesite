package lattesite.staticwebserver.services;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import lattesite.common.services.LogService;
import lattesite.localization.locale.Locale;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;

/** A minimal local static file server backed by the built-in {@code com.sun.net.httpserver} API. */
public class StaticWebServerService {

    private final LogService logService;

    private HttpServer server;

    public StaticWebServerService(LogService logService) {
        this.logService = logService;
    }

    /**
     * Starts a local static file server serving from {@code public/} on the given port.
     *
     * @param port the TCP port to bind to
     */
    public void serve(int port) throws Exception {
        serve("", port);
    }

    /**
     * Starts a local static file server serving the locale's sub-folder.
     *
     * @param locale the locale whose output sub-folder is used as the document root
     * @param port   the TCP port to bind to
     */
    public void serve(Locale locale, int port) throws Exception {
        this.serve(locale.getOutputSubFolderName(), port);
    }

    /**
     * Starts a local static file server serving from {@code public/<subFolder>}.
     *
     * @param subFolder the sub-folder under {@code public/} to serve; use {@code ""} for the root
     * @param port      the TCP port to bind to
     */
    public void serve(String subFolder, int port) throws Exception {
        try {
            String root = "public/" + subFolder;
            if (!root.endsWith("/")) {
                root = root + "/";
            }

            this.server = HttpServer.create(new InetSocketAddress(port), 0);
            this.server.createContext("/", new StaticFileHandler(root));
            this.server.setExecutor(null); // creates a default executor
            this.server.start();

            this.logService.log("Static Server started on \"http://localhost:" + port + "/\" for root folder \"" + root + "\".");
        } catch (IOException exception) {
            throw new Exception(exception);
        }
    }

    static class StaticFileHandler implements HttpHandler {

        private final String root;

        public StaticFileHandler(String root) {
            this.root = root;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String requestPath = exchange.getRequestURI().getPath();
            if (requestPath.endsWith("/")) {
                requestPath += "/index.html"; // Serve index.html by default
            }

            File file = new File(root + requestPath).getCanonicalFile();

            // Prevent path traversal attacks
            if (!file.getPath().startsWith(new File(root).getCanonicalPath())) {
                send404(exchange);
                return;
            }

            if (file.exists() && file.isFile()) {
                String contentType = Files.probeContentType(file.toPath());
                if (contentType == null) {
                    contentType = "application/octet-stream";
                }

                exchange.getResponseHeaders().set("Content-Type", contentType);
                exchange.sendResponseHeaders(200, file.length());

                try (OutputStream os = exchange.getResponseBody(); FileInputStream fis = new FileInputStream(file)) {
                    byte[] buffer = new byte[8192];
                    int length;
                    while ((length = fis.read(buffer)) != -1) {
                        os.write(buffer, 0, length);
                    }
                }
            } else {
                send404(exchange);
            }
        }

        private void send404(HttpExchange exchange) throws IOException {
            String response = "404 Not Found";
            exchange.sendResponseHeaders(404, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }

}
