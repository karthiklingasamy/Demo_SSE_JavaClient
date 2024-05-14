package org.example.sse_client.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class SSEClient {

    private final WebClient webClient;

    @Autowired
    public SSEClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public void connectToSSEEndpoint(String url) {
        Flux<String> eventStream = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToFlux(String.class);

        eventStream.subscribe(System.out::println); // Print received events
    }
}
