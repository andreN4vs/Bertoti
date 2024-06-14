package src;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ChatbotSQL {

    private static final String API_URL = "https://api.ollama.ai/v1/query"; // Exemplo de URL
    private static final String API_KEY = "sua_chave_api"; // Insira sua chave API aqui

    private HttpClient client;

    public ChatbotSQL() {
        this.client = HttpClient.newHttpClient();
    }

    public String queryAI(String prompt) throws Exception {
        // Crie o corpo da requisição
        String requestBody = String.format("{\"prompt\": \"%s\"}", prompt);

        // Crie a requisição HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .timeout(Duration.ofSeconds(30)) // Ajuste conforme necessário
                .build();

        // Envie a requisição e obtenha a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verifique o status da resposta
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new Exception("Erro na requisição: " + response.statusCode() + " " + response.body());
        }
    }

    public static void main(String[] args) {
        try {
            ChatbotSQL client = new ChatbotSQL();
            String response = client.queryAI("Olá, como você está?");
            System.out.println("Resposta da AI: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
