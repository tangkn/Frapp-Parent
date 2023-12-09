package frapp.parent.common;

public record RestResponse<T>(int status,String message, T payload) {

}
