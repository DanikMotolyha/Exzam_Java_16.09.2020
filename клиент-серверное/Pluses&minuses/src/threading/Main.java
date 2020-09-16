package threading;

import java.io.*;
import java.net.*;
class Main {
    private static final int port = 6666;
    public static  int numberPlus = 0;
    public static  int numberMinus = 0;
    public static class MainServer extends Thread {
        private Socket socket;
        public MainServer() {
        }
        public void setSocket(Socket socket) {
            this.socket = socket;
            setDaemon(true);
            setPriority(NORM_PRIORITY);
            start();
        }
        public void run() {
            try {
                InputStream sin = socket.getInputStream();
                OutputStream sout = socket.getOutputStream();

                DataInputStream dis = new DataInputStream(sin);
                DataOutputStream dos = new DataOutputStream(sout);

                String line = null;
                while (true) {
                    // Ожидание сообщения от клиента
                    line = dis.readUTF();
                    if (line.endsWith("/plus")) {
                        numberPlus++;
                        dos.writeUTF("pluses");
                    } else if (line.endsWith("/minus")) {
                        numberMinus++;
                        dos.writeUTF("minuses");
                    } else if (line.endsWith("/equals")) {
                        dos.writeUTF("+ = " + numberPlus + "\n" +
                                "- = " + numberMinus);
                    }
                    else dos.writeUTF("try to in /help to get help");
                    // Завершаем передачу данных
                    dos.flush();
                    if (line.equalsIgnoreCase("q")) {
                        // завершаем соединение
                        socket.close();
                        System.out.println("Close connection");
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception : " + e);
            }
        }
        public static void main(String[] ar) {
            ServerSocket srvSocket = null;
            try {
                try {
                    // Подключение сокета к localhost
                    InetAddress ia;
                    ia = InetAddress.getByName("localhost");
                    srvSocket = new ServerSocket(port, 0, ia);
                    System.out.println("Server started\n\n");

                    while (true) {
                        // ожидание подключения
                        Socket socket = srvSocket.accept();
                        System.out.println("Client accepted");
                        // Стартуем обработку клиента
                        // в отдельном потоке
                        new MainServer().setSocket(socket);
                    }
                } catch (Exception e) {
                    System.out.println("Exception : " + e);
                }
            } finally {
                try {
                    if (srvSocket != null)
                        srvSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.exit(0);
        }
    }
}