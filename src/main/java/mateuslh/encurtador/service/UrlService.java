package mateuslh.encurtador.service;

import mateuslh.encurtador.dto.EncurtarUrlRequest;
import mateuslh.encurtador.dto.EncurtarUrlResponse;
import mateuslh.encurtador.dto.EstatisticasResponse;
import mateuslh.encurtador.exception.EncurtadorApiException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class UrlService {

    private final RestTemplate restTemplate;
    private Long totalUrlsEncurtadas;
    private Long totalTempoResposta;

    public UrlService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.totalUrlsEncurtadas = 0L;
        this.totalTempoResposta = 0L;
    }

    public EncurtarUrlResponse encurtarUrl(EncurtarUrlRequest request) {
        long inicio = System.currentTimeMillis();

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            HttpEntity<EncurtarUrlRequest> entity = new HttpEntity<>(request, headers);

            ResponseEntity<EncurtarUrlResponse> response = restTemplate.exchange(
                    "https://api.encurtador.dev/encurtamentos",
                    HttpMethod.POST,
                    entity,
                    EncurtarUrlResponse.class
            );

            atualizarEstatisticas(inicio);

            return response.getBody();
        } catch (HttpClientErrorException e) {
            throw new EncurtadorApiException("Erro ao acessar API de encurtamento. Verifique a requisição.", e.getStatusCode());
        } catch (HttpServerErrorException e) {
            throw new EncurtadorApiException("Erro no servidor da API de encurtamento. Tente novamente mais tarde.", e.getStatusCode());
        } catch (Exception e) {
            throw new EncurtadorApiException("Erro inesperado ao acessar a API de encurtamento.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void atualizarEstatisticas(long inicio) {
        long tempoResposta = System.currentTimeMillis() - inicio;
        totalUrlsEncurtadas += 1;
        totalTempoResposta += tempoResposta;
    }

    public EstatisticasResponse getEstatisticas() {
        long quantidadeUrls = totalUrlsEncurtadas;
        long tempoMedio = quantidadeUrls > 0 ? totalTempoResposta / quantidadeUrls : 0;
        return new EstatisticasResponse(quantidadeUrls, tempoMedio);
    }
}
