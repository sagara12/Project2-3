import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {

        Socket socket = null;
        try {

            socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", 5001));



            byte[] bytes = null;
            byte[] bytes2 = null;
            byte[] bytes3 = null;

            String message = null;
            String message2 = null;
            String message3 = null;

            OutputStream os = socket.getOutputStream();
            DataOutputStream dous = new DataOutputStream(os);
            message = "Ping";
            System.out.println("Send(Client) : " + message);
            dous.writeUTF(message);
            dous.flush();

            InputStream is = socket.getInputStream();
            DataInputStream dins = new DataInputStream(is);
            String str = dins.readUTF();
            System.out.println("Received(Client) : " + str);



            os.close();
            is.close();

            socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", 5001));

            OutputStream os2 = socket.getOutputStream();
            DataOutputStream dous2 = new DataOutputStream(os2);
            message = "Ping";
            System.out.println("Send (Client): " + message);
            dous2.writeUTF(message);
            dous2.flush();

            InputStream is2 = socket.getInputStream();
            DataInputStream dins2 = new DataInputStream(is2);
            String str2 = dins2.readUTF();
            System.out.println("Received (Client) : " + str2);

            os2.close();
            is2.close();

            socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", 5001));


            OutputStream os3 = socket.getOutputStream();
            DataOutputStream dous3 = new DataOutputStream(os3);
            message = "foobar";
            System.out.println("Send (Client):" + message);
            dous3.writeUTF(message);
            dous3.flush();


            InputStream is3 = socket.getInputStream();
            DataInputStream dins3 = new DataInputStream(is3);
            String str3 = dins3.readUTF();
            System.out.println("Received (Client): " + str3);



            os3.close();
            is3.close();

            System.out.println("  ");
            System.out.println("  ");
            System.out.println("종료하려면 exit를 입력 하세요");
            Scanner input = new Scanner(System.in);
            String esc = String.valueOf(input.hasNextLine());




            if (esc.equals("exit")) {
                System.exit(0);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }//while

    }// 메인
        /*if (!socket.isClosed()) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
}
