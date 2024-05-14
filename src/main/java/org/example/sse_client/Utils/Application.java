package org.example.sse_client.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final SSEClient sseClient;

    @Autowired
    public Application(SSEClient sseClient) {
        this.sseClient = sseClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Connect to SSE endpoint
        sseClient.connectToSSEEndpoint("http://localhost:8080/serverevents");
    }
}
