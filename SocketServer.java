import java.net.*;
import java.util.concurrent.Executors;
import java.io.*; 

public class SocketServer{
    

        public static void main(String[] args) throws Exception {
            

            try (var listener = new ServerSocket(59898)) {
                System.out.println("The server is running...");
                var pool = Executors.newFixedThreadPool(20);
                while (true) {
                    pool.execute(new ServerProtocol(listener.accept()));
                }
            }
        }

}
