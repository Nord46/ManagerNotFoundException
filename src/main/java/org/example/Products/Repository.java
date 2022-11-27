package org.example.Products;
public class Repository {

    protected org.example.Products.Product[] products = new org.example.Products.Product[0];

    public void addProduct(org.example.Products.Product product) {
        org.example.Products.Product[] tmp = new org.example.Products.Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public org.example.Products.Product[] findAll() {

        return products;
    }

    public org.example.Products.Product findById(int id) {
        for (org.example.Products.Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Товарс ID" + id + "отсутствует");
        }

        org.example.Products.Product[] tmp = new org.example.Products.Product[products.length - 1];
        int copyToIndex = 0;
        for (org.example.Products.Product product : products){
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }
}