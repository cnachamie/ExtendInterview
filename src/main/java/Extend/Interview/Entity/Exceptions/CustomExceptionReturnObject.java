package Extend.Interview.Entity.Exceptions;

public class CustomExceptionReturnObject {
    String error;

    public CustomExceptionReturnObject(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
