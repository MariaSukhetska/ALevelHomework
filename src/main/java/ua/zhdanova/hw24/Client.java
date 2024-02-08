package ua.zhdanova.hw24;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = openConsoleReader()) {
            String message = readMessage(reader);
            while (!message.equals("q")) {
                String finalMessage = message;
                new Thread(() -> {
                    try (Socket socket = new Socket(ServerConfig.SERVER_HOST, ServerConfig.SERVER_PORT);
                         Writer writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

                        String clientMessage = "Client says: " + finalMessage;
                        writer.write(clientMessage);
                        writer.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).start();

                message = readMessage(reader);
            }
        }
    }

    public static BufferedReader openConsoleReader() {
        InputStreamReader consoleInputStream = new InputStreamReader(System.in);
        return new BufferedReader(consoleInputStream);
    }

    public static String readMessage(BufferedReader reader) throws IOException {
        System.out.print("Enter message (q to quit): ");
        return reader.readLine();
    }
}
