package api.bin;

public class Product {

    private String product_descr;
    private String product_name;
    private Integer product_qty;

    public Product(String product_descr, String product_name, Integer product_qty) {
        this.product_descr = product_descr;
        this.product_name = product_name;
        this.product_qty = product_qty;
    }

    public String getProduct_descr() {
        return product_descr;
    }

    public void setProduct_descr(String product_descr) {
        this.product_descr = product_descr;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getProduct_qty() {
        return product_qty;
    }

    public void setProduct_qty(Integer product_qty) {
        this.product_qty = product_qty;
    }
}
