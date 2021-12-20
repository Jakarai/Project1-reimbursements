package models;

public class JsonResponse {
    Boolean isSuccessful;
    String message;
    Object data;

    public JsonResponse() {
    }

    public JsonResponse(Boolean isSuccessful, String message, Object data) {
        this.isSuccessful = isSuccessful;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccessful() {
        return this.isSuccessful;
    }

    public void setSuccessful(Boolean successful) {
        this.isSuccessful = successful;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toString() {
        return "JsonResponse{isSuccessful=" + this.isSuccessful + ", message='" + this.message + '\'' + ", data=" + this.data + '}';
    }
}

