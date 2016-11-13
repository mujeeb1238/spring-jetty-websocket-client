import javax.websocket.*;
import java.io.IOException;

@ClientEndpoint
public class EchoClient {
    Session session;

    //request
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        System.out.println("Connected to endpoint: " + session.getBasicRemote());
        this.session = session;
        sendMessage("Welcome to WebSocket");
    }

    //response
    @OnMessage
    public void onMessage(String text) {
        System.out.println("Received response in client from server: " + text);
    }

    @OnError
    public void onError(Session session, Throwable t) {
        t.printStackTrace();
    }

    private void sendMessage(String message) {
        System.out.println("Sending message from client to server: " + message);
        System.out.println(session);
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}