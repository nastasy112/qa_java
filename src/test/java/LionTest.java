import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.spy;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean expectedHasMane;

    public LionTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] getTypeOfFoodForAmimal() {
        return new Object[][] {
                { "Самец", true},
                { "Самка", false},
        };
    }

    // Готово. Есть зависимость от метода doesHaveMane
    @Test
    public void lionConstructionCreateLion() throws Exception {
        Lion lion = spy(new Lion(sex));
        Mockito.when(lion.doesHaveMane()).thenReturn(expectedHasMane);

        boolean actualHasMane = lion.doesHaveMane();

        Assert.assertEquals("Construction doesn't create lion.", expectedHasMane, actualHasMane);
    }

    // Готово. Мок не нужен, тк нет зависимости от др. методов или классов
    @Test
    public void getLionConstructionException() {
        String expectedText = "Используйте допустимые значения пола животного - самей или самка";
        Exception exception = null;

        try {
            Lion lion = new Lion("Кобель");
        } catch (Exception ex){
            exception = ex;
        }

        Assert.assertNotNull(exception);
        Assert.assertEquals("Massage exception is incorrect.", expectedText, exception.getMessage());
    }

    // Готово. Есть зависимость от конструктора Lion(String sex)
    @Test
    public void doesHaveManeReturnCorrectValue() throws Exception {
        Lion lion = spy(new Lion(sex));

        boolean actualMane = lion.doesHaveMane();

        Mockito.verify(lion).doesHaveMane();
        Assert.assertEquals("Method doesHaveMane return incorrect value.", expectedHasMane, actualMane);
    }

    @Mock
    Feline feline;

    // Готово. Есть зависимость от конструктора от класса Feline и метода feline.getKittens())
    @Test
    public void getKittensReturnCorrectValue(){
        Lion lion = new Lion(feline);
        int expectedKittens = 1;
        Mockito.when(feline.getKittens()).thenReturn(1);

        int actualKittens = lion.getKittens();

        Mockito.verify(feline).getKittens();
        Assert.assertEquals("Method getKittens return incorrect value.", expectedKittens, actualKittens);
    }

    // Готово. Есть зависимость от класса Feline и метода feline.getFood
    @Test
    public void getFoodReturnCorrectValue() throws Exception {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedListOfMeat = List.of("Животные", "Птицы", "Рыба");

        List<String> aclualListOfMeat = lion.getFood();

        Mockito.verify(feline).getFood("Хищник");
        Assert.assertEquals("Method getFood return incorrect value.",expectedListOfMeat, aclualListOfMeat);
    }

}
