import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

public  class ServerProtocol implements Runnable{
    private Socket socket;
    
            ServerProtocol(Socket socket) {
                this.socket = socket;
            }
            @Override
            public void run() {
                System.out.println("Connected: " + socket);
                try {

                    ObjectInputStream oInputStream = new ObjectInputStream(socket.getInputStream());
                    Message obj = (Message) oInputStream.readObject();
                    
                    var out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(
                        "Thank You "+ obj.getName()[0] + " "+obj.getName()[1]
                    );

                } catch (Exception e) {
                    System.out.println("Error:" + socket);
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                    }
                    System.out.println("Closed: " + socket);
                }
            }
}
