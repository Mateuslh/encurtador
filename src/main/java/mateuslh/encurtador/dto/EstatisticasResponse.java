package mateuslh.encurtador.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstatisticasResponse {
    private long quantidadeUrlsEncurtadas;
    private long tempoMedioRespostaMs;
}
