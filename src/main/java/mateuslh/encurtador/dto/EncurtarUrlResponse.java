package mateuslh.encurtador.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EncurtarUrlResponse {
    private String urlEncurtada;
    private String urlBase;
}
