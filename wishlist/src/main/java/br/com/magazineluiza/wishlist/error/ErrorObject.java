package br.com.magazineluiza.wishlist.error;

public class ErrorObject {

    private final String message;
    private final String field;
    private final Object parameter;

    public ErrorObject(String message, String field, Object parameter) {
        this.message = message;
        this.field = field;
        this.parameter = parameter;
    }

    public String getMessage() {
        return message;
    }

    public String getField() {
        return field;
    }

    public Object getParameter() {
        return parameter;
    }
}
