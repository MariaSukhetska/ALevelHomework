package ua.zhdanova.hw24;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final Integer THREADS_POOL = 10;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(THREADS_POOL);

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(ServerConfig.SERVER_PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                executorService.submit(() -> handleConnection(clientSocket));
            }
        }
    }

    private static void handleConnection(Socket clientSocket) {
        try (clientSocket;
             InputStream inputStream = clientSocket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
             OutputStream outputStream = clientSocket.getOutputStream();
             Writer writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {

            String clientMessage = reader.readLine();
            System.out.print(LocalDateTime.now().format(TIME_FORMATTER) + " ");
            System.out.println(clientMessage);
            String serverResponse = "Server replies: Hello, " + clientMessage;
            writer.write(serverResponse + "\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
