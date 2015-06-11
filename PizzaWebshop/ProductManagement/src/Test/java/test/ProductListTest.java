package test;

import bl.Ingredient;
import bl.Product;
import bl.ProductList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * ProductManagment
 * Tests for the ProductList class
 */
public class ProductListTest {
    private ProductList m_ProdList;

    @Before
    public void init() {
        //performs basic initiaslisations
        this.m_ProdList = new ProductList();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIfAddProductNullThrowsError() {
        //Tests if Error is returned when I would like a product which is null
        Product p = null;
        this.m_ProdList.addProductObject(p);
    }

    @Test
    public void testIfYouCanAddProducts() {
        //Tests if you can add products
        Product p = this.createTestProduct();
        this.m_ProdList.addProductObject(p);
        Assert.assertThat(this.m_ProdList.getCurrentProduct(0), equalTo(p));
    }

    @Test
    public void testCountElements() {
        //Tests if count Elements works
        Product p1 = this.createTestProduct();
        Product p2 = this.createTestProduct();

        this.m_ProdList.addProductObject(p1);
        this.m_ProdList.addProductObject(p1);

        Assert.assertThat(this.m_ProdList.countElements(), equalTo(2));
    }

    @Test
    public void testDeleteProduct() {
        //Tests if products are deleted
        Product p1 = this.createTestProduct();
        Product p2 = this.createTestProduct();

        this.m_ProdList.addProductObject(p1);
        this.m_ProdList.addProductObject(p1);
        this.m_ProdList.deleteProduct(p1);
        Assert.assertThat(this.m_ProdList.countElements(), equalTo(1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIfDeleteProductThrowsErrorIfProductIsNull() {
        //tests if delete product returns error when I wanted to delete a product which is null
        Product p1 = this.createTestProduct();
        Product p2 = this.createTestProduct();

        this.m_ProdList.addProductObject(p1);
        this.m_ProdList.addProductObject(p1);
        this.m_ProdList.deleteProduct(null);
    }

    @Test
    public void testIfRightProductIsReturned() {
        //tests if the correct product is returned
        Product p1 = this.createTestProduct();
        Product p2 = this.createTestProduct();

        this.m_ProdList.addProductObject(p1);
        this.m_ProdList.addProductObject(p2);
        Assert.assertThat(this.m_ProdList.getCurrentProduct(0), equalTo(p1));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testIfIndexOutOfBoundsExceptionIsThrown() {
        //Tests if index out of bounds exception is thrown
        Product p1 = this.createTestProduct();
        Product p2 = this.createTestProduct();

        this.m_ProdList.addProductObject(p1);
        this.m_ProdList.addProductObject(p2);
        Assert.assertThat(this.m_ProdList.getCurrentProduct(2), equalTo(p1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIfIllegalArgumentExceptionIsThrownIfIWantProductMinus1() {
        //test if illegal argument exception is thrown
        Product p1 = this.createTestProduct();
        Product p2 = this.createTestProduct();

        this.m_ProdList.addProductObject(p1);
        this.m_ProdList.addProductObject(p2);
        Assert.assertThat(this.m_ProdList.getCurrentProduct(-1), equalTo(p1));
    }

    @Test
    public void testIfGetProductsOfRestaurantReturnsTheRightProducts() {
        //tests if the get products from restaurant
        Product p1 = this.createTestProduct();
        Product p2 = this.createTestProduct();

        this.m_ProdList.addProductObject(p1);
        this.m_ProdList.addProductObject(p2);

        LinkedList<Product> products = this.m_ProdList.getProductsFromRestaurant("Luigis");
        Assert.assertThat(products.size(), equalTo(2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIfGetProductOfRestaurantReturnsError() {
        //tests if error is thrown
        Product p1 = this.createTestProduct();
        Product p2 = this.createTestProduct();

        this.m_ProdList.addProductObject(p1);
        this.m_ProdList.addProductObject(p2);

        LinkedList<Product> products = this.m_ProdList.getProductsFromRestaurant("");
    }

    //Creates test data for the product
    private Product createTestProduct() {
        Ingredient testIng = new Ingredient("Cola",1);
        Ingredient testIng1 = new Ingredient("Eiswürfel",0.2f);
        LinkedList<Ingredient> testData = new LinkedList<Ingredient>();
        testData.add(testIng);
        testData.add(testIng1);

        Product p = new Product(testData, "Cola Mit Eis", "Cola Mit Eis", "Luigis");
        return p;
    }
}