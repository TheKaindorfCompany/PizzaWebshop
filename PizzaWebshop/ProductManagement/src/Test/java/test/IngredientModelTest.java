package test;
import bl.Ingredient;
import bl.IngredientModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Product Management
 * Testklasse f�r die IngredientModel Klasse
 */
public class IngredientModelTest {
    private IngredientModel m_Model;

    @Before
    public void init() {
        this.m_Model = new IngredientModel();
    }

    @Test
    public void testIfRightIndexIsReturned() {
        // Testet ob nach hinzuf�gen eines Ingredients, dieser auch in der Liste ist
        this.m_Model.addIngredient("", "Salami", 12, 1.4f);
        //It should return 0
        Assert.assertThat(this.m_Model.getIndexOfIngredientByName("Salami"), equalTo(0));
    }

    @Test
    public void testIfProductThatIsNotInListReturnsMinusOne() {
        // Testet ob wenn nach einem Produkt gesucht wird, welcher nicht vorhanden ist -1 zur�ckgegeben wird
        this.m_Model.addIngredient("", "Salami", 12, 1.4f);
        //It should return 0
        Assert.assertThat(this.m_Model.getIndexOfIngredientByName("sdf"), equalTo(-1));
    }

    @Test
         public void testIfCountElementsReturnsZeroIfIDontAddIngredients() {
        // Testet ob der Index 0 ist drinnen steht wenn nichts drin steht.
        //It should return 0
        Assert.assertThat(this.m_Model.countElements(), equalTo(0));
    }

    @Test
    public void testIfRightIngredientIsReturned() {
        //Testet ob beim Suchen nach einem Ingredient das richtige zur�ck gegeben wird
        Ingredient ing = new Ingredient("", "Salami",1.4f,12);
        this.m_Model.addIngredient("", "Salami", 12, 1.4f);
        //It should return 0
        Assert.assertThat(this.m_Model.getCurrentIngredient(0), equalTo(ing));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIfExceptionWhenIndexLessThanZero() {
        //Wenn nach einer Minus Zahl gesucht wird soll ein fehler kommen
        Ingredient ing = new Ingredient("", "Salami",1.4f,12);
        this.m_Model.addIngredient("", "Salami", 12, 1.4f);
        //It should return 0
        Assert.assertThat(this.m_Model.getCurrentIngredient(-1), equalTo(ing));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIfExceptionWhenAddAIngredientWhichIsZero() {
        // Testet ob ein Ingredient welches null ist nicht hinzugef�gt werden kann
        Ingredient ing = null;
        this.m_Model.addIngredientObject(ing);
    }

    @Test
    public void testIfICanAddIngredients() {
        // Testet ob  man Ingredients hinzugef�gt werden k�nnen.
        Ingredient ing = new Ingredient("", "Salami",1.4f,12);
        this.m_Model.addIngredientObject(ing);
        //It should return 0
        Assert.assertThat(this.m_Model.getCurrentIngredient(0), equalTo(ing));
    }
}
