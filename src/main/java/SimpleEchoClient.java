import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.net.URI;

public class SimpleEchoClient
{
    public static void main(String[] args)
    {
        String destUri = "ws://127.0.0.1:9550/echo";
        if (args.length > 0)
        {
            destUri = args[0];
        }

        WebSocketClient client = new WebSocketClient();
        SimpleEchoSocket socket = new SimpleEchoSocket();
        try
        {
            client.start();

            URI echoUri = new URI(destUri);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            client.connect(socket,echoUri,request);
            System.out.printf("Connecting to : %s%n",echoUri);

            // wait for closed socket connection.
            //socket.awaitClose(5, TimeUnit.SECONDS);
            System.out.println("Connection closed!");
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
        finally
        {
            try
            {
                //client.stop();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}