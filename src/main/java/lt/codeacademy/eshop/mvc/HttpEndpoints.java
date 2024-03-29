package lt.codeacademy.eshop.mvc;

public class HttpEndpoints {

    public static final String PRODUCTS = "/products";
    public static final String PRODUCTS_CREATE = PRODUCTS + "/create";
    public static final String PRODUCTS_UPDATE = PRODUCTS + "/{productId}/update";
    public static final String PRODUCTS_GET = PRODUCTS + "/{productId}/get";
    public static final String PRODUCTS_DELETE = PRODUCTS + "/{productId}/delete";
}
