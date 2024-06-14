import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ChatbotSQL {

    private static final String API_URL = "https://api.ollama.ai/v1/query";
    private static final String API_KEY = "sua_chave_api";

    private HttpClient client;

    public ChatbotSQL() {
        this.client = HttpClient.newHttpClient();
    }

    public String queryAI(String prompt) throws Exception {

        String requestBody = String.format("{\"prompt\": \"%s\"}", prompt);


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .timeout(Duration.ofSeconds(30)) // Ajuste conforme necessário
                .build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


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
