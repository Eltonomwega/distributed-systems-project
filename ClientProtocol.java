import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class ClientProtocol {
    

    private String InputLine;


    public void startClient(String name [],String studentNo,String detailArr [],String thankYou) throws Exception{  
        try (var socket = new Socket("localhost", 59898)) {
            
      

             Message obj = new Message(name,studentNo,detailArr,thankYou);
             ObjectOutputStream oStream = new ObjectOutputStream(socket.getOutputStream());
             oStream.writeObject(obj);

             oStream.flush();

            BufferedReader bis = new BufferedReader(new 
            InputStreamReader(socket.getInputStream()));
            String inputLine;
            while ((inputLine = bis.readLine()) != null)
            {
                System.out.println(inputLine);
                setServerResponse(inputLine);   
            }
         
         }

        }

 
        

    
        public void setServerResponse(String InputLine){
            this.InputLine = InputLine;
        }

        public String getInputLine() {
            return InputLine;
        }

        
 
        
       
}
