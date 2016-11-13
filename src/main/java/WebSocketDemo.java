import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;

public class WebSocketDemo {
    public static void main(String[] args) {
        String uri = "ws://localhost:9550/echo/";
        System.out.println("Connecting to " + uri);
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        try {
            container.connectToServer(EchoClient.class, URI.create(uri));
        } catch (DeploymentException | IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}