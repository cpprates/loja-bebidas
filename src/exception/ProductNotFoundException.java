package exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("Product Error");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

}
