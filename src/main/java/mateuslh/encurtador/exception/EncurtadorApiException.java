package mateuslh.encurtador.exception;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class EncurtadorApiException extends RuntimeException {

    private final HttpStatusCode status;

    public EncurtadorApiException(String message, HttpStatusCode status) {
        super(message);
        this.status = status;
    }

    public EncurtadorApiException(String message) {
        super(message);
        this.status = HttpStatusCode.valueOf(400);
    }
}
