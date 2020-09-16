import java.net.*;
import java.io.*;

public class Clients
{
    private static final int serverPort = 6666;
    private static final String localhost  = "127.0.0.1";

    public static void main(String[] ar)
    {
        Socket socket = null;
        try{
            try {
                InetAddress ipAddress;
                ipAddress = InetAddress.getByName(localhost);
                socket = new Socket(ipAddress, serverPort);

                // Получаем входной и выходной потоки
                // сокета для обмена сообщениями с сервером
                InputStream  sin  = socket.getInputStream();
                OutputStream sout = socket.getOutputStream();

                DataInputStream  in ;
                DataOutputStream out;
                in  = new DataInputStream (sin );
                out = new DataOutputStream(sout);

                // Создаем поток для чтения с клавиатуры.
                InputStreamReader isr;
                isr = new InputStreamReader(System.in);
                BufferedReader keyboard;
                keyboard = new BufferedReader(isr);
                String line = null;
                System.out.println(
                        "Type in something");
                System.out.println();
                while (true) {
                     line = keyboard.readLine();
                     out.writeUTF("");
                     out.flush();
                     // Ждем ответа от сервера
                     line = in.readUTF();
                     System.out.println(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}