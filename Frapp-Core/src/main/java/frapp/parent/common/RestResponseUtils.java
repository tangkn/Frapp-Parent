package frapp.parent.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

public interface RestResponseUtils {
    ObjectMapper objectMapper = new ObjectMapper();

    public static <T> RestResponse<T> success(T data) {
        return new RestResponse<>(HttpStatus.OK.value(), "Success", data);
    }

    public static <T> RestResponse<T> error(HttpStatus status, String message) {
        return new RestResponse<>(status.value(), message, null);
    }




}
