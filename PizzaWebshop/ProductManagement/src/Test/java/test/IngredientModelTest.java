package test;
import bl.Ingredient;
import bl.IngredientModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by dominik on 10.06.2015.
 */
public class IngredientModelTest {
    private IngredientModel m_Model;

    @Before
    public void init() {
        this.m_Model = new IngredientModel();
    }

    @Test
    public void testIfRightIndexIsReturned() {
        this.m_Model.addIngredient("", "Salami", 12, 1.4f);
        //It should return 0
        Assert.assertThat(this.m_Model.getIndexOfIngredientByName("Salami"), equalTo(0));
    }

    @Test
    public void testIfProductThatIsNotInListReturnsMinusOne() {
        this.m_Model.addIngredient("", "Salami", 12, 1.4f);
        //It should return 0
        Assert.assertThat(this.m_Model.getIndexOfIngredientByName("sdf"), equalTo(-1));
    }

    @Test
         public void testIfCountElementsReturnsZeroIfIDontAddIngredients() {
        //It should return 0
        Assert.assertThat(this.m_Model.countElements(), equalTo(0));
    }

    @Test
    public void testIfRightIngredientIsReturned() {
        Ingredient ing = new Ingredient("", "Salami",1.4f,12);
        this.m_Model.addIngredient("", "Salami", 12, 1.4f);
        //It should return 0
        Assert.assertThat(this.m_Model.getCurrentIngridient(0), equalTo(ing));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIfExceptionWhenIndexLessThanZero() {
        Ingredient ing = new Ingredient("", "Salami",1.4f,12);
        this.m_Model.addIngredient("", "Salami", 12, 1.4f);
        //It should return 0
        Assert.assertThat(this.m_Model.getCurrentIngridient(-1), equalTo(ing));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIfExceptionWhenAddAIngredientWhichIsZero() {
        Ingredient ing = null;
        this.m_Model.addIngredientObject(ing);
    }

    @Test
    public void testIfICanAddIngredients() {
        Ingredient ing = new Ingredient("", "Salami",1.4f,12);
        this.m_Model.addIngredientObject(ing);
        //It should return 0
        Assert.assertThat(this.m_Model.getCurrentIngridient(0), equalTo(ing));
    }
}
