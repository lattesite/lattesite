package lattesite.services;

public interface StaticWebServerServiceInterface {

    void serve(int port) throws Exception;

    void serve(String subFolder, int port) throws Exception;

}