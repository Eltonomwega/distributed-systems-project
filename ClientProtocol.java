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
    

    public void startClient() throws Exception{  
        try (var socket = new Socket("localhost", 59898)) {
            
            ClientProtocol cP = new ClientProtocol();
            String studentNo = cP.sendStudentNumber();
            String name [] = cP.sendName();
            String detailArr [] = cP.suDetails();
            String thankYou = cP.thankYou();

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
            }
         
         }

        }

    
        public String sendStudentNumber() {
            System.out.println("Enter your student no.");
            Scanner sc= new Scanner(System.in);
            String str= sc.nextLine();
            return str;
        }
    
        
        public String [] sendName() {
            System.out.println("Enter your first name");
            Scanner sc= new Scanner(System.in);
            String firstName= sc.nextLine();
            System.out.println("Enter your last name");
            String lastName= sc.nextLine();
    
            String names[] = {firstName,lastName};
    
            return names;
        }
    
        
        public String[] suDetails() {
    
            System.out.println("Enter your faculty");
            Scanner sc= new Scanner(System.in);
            String faculty= sc.nextLine();
            System.out.println("Enter your course");
            String course= sc.nextLine();
            System.out.println("Enter your degree");
            String degree= sc.nextLine();
    
            String suDetails[] = {faculty,course,degree};
    
            return suDetails;
        }
    
        
        public String thankYou() {
            // TODO Auto-generated method stub
            System.out.println("Enter your thank you message");
            Scanner sc= new Scanner(System.in);
            String msg= sc.nextLine();
            Random rand = new Random();
            int e;
            int i;
            int g = 10;
            HashSet<Integer> randomNumbers = new HashSet<Integer>();
    
            for (i = 0; i < g; i++) {
                e = rand.nextInt(20);
                randomNumbers.add(e);
                if (randomNumbers.size() <= 10) {
                    if (randomNumbers.size() == 10) {
                        g = 10;
                    }
                    g++;
                    randomNumbers.add(e);
                }
            }
            String thankYou  = msg+" "+ randomNumbers;
            return thankYou;
        }

}
