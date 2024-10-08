package mateuslh.encurtador.controller;

import mateuslh.encurtador.dto.EncurtarUrlRequest;
import mateuslh.encurtador.dto.EncurtarUrlResponse;
import mateuslh.encurtador.dto.EstatisticasResponse;
import mateuslh.encurtador.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/encurtar")
    public ResponseEntity<EncurtarUrlResponse> encurtarUrl(@RequestBody EncurtarUrlRequest request) {
        EncurtarUrlResponse response = urlService.encurtarUrl(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/sobre")
    public ResponseEntity<Map<String, String>> sobre() {
        return ResponseEntity.ok(Map.of("estudante", "Mateus Leal Hemkemeier", "projeto", "Encurtador de Links"));
    }

    @GetMapping("/estatisticas")
    public ResponseEntity<EstatisticasResponse> estatisticas() {
        EstatisticasResponse stats = urlService.getEstatisticas();
        return ResponseEntity.ok(stats);
    }
}
