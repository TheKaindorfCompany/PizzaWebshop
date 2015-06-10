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
 * Created by Veronika on 23.04.2015.
 */
public class ProductListTest {
    private ProductList m_ProdList;

    @Before
    public void init() {
        this.m_ProdList = new ProductList();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIfAddProductNullThrowsError() {
        Product p = null;
        this.m_ProdList.addProductObject(p);
    }

    @Test
    public void testIfYouCanAddProducts() {
        Product p = this.createTestProduct();
        this.m_ProdList.addProductObject(p);
    }

    @Test
    public void testCountElements() {
        Product p1 = this.createTestProduct();
        Product p2 = this.createTestProduct();

        this.m_ProdList.addProductObject(p1);
        this.m_ProdList.addProductObject(p1);

        Assert.assertThat(this.m_ProdList.countElements(), equalTo(2));
    }

    @Test
    public void testDeleteProduct() {
        Product p1 = this.createTestProduct();
        Product p2 = this.createTestProduct();

        this.m_ProdList.addProductObject(p1);
        this.m_ProdList.addProductObject(p1);
        this.m_ProdList.deleteProduct(p1);
        Assert.assertThat(this.m_ProdList.countElements(), equalTo(1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIfDeleteProductThrowsErrorIfProductIsNull() {
        Product p1 = this.createTestProduct();
        Product p2 = this.createTestProduct();

        this.m_ProdList.addProductObject(p1);
        this.m_ProdList.addProductObject(p1);
        this.m_ProdList.deleteProduct(null);
    }

    @Test
    public void testIfRightProductIsReturned() {
        Product p1 = this.createTestProduct();
        Product p2 = this.createTestProduct();

        this.m_ProdList.addProductObject(p1);
        this.m_ProdList.addProductObject(p2);
        Assert.assertThat(this.m_ProdList.getCurrentProduct(0), equalTo(p1));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testIfIndexOutOfBoundsExceptionIsThrown() {
        Product p1 = this.createTestProduct();
        Product p2 = this.createTestProduct();

        this.m_ProdList.addProductObject(p1);
        this.m_ProdList.addProductObject(p2);
        Assert.assertThat(this.m_ProdList.getCurrentProduct(2), equalTo(p1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIfIllegalArgumentExceptionIsThrownIfIWantProductMinus1() {
        Product p1 = this.createTestProduct();
        Product p2 = this.createTestProduct();

        this.m_ProdList.addProductObject(p1);
        this.m_ProdList.addProductObject(p2);
        Assert.assertThat(this.m_ProdList.getCurrentProduct(-1), equalTo(p1));
    }
    @Test
    public void testGetInstance() throws Exception {

    }

    @Test
    public void testGetIngredients() throws Exception {

    }

    private Product createTestProduct() {
        Ingredient testIng = new Ingredient("Cola",1);
        Ingredient testIng1 = new Ingredient("Eiswürfel",0.2f);
        LinkedList<Ingredient> testData = new LinkedList<Ingredient>();
        testData.add(testIng);
        testData.add(testIng1);

        Product p = new Product(testData, "Cola Mit Eis", "Cola Mit Eis");
        return p;
    }
}