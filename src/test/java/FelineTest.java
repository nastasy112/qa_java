import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    // Готово. Сравнить списки.
    @Test
    public void getMeatReturnCorrectList() throws Exception {
        List<String> expectedListOfMeat = Arrays.asList("Животные", "Птицы", "Рыба");

        List<String> aclualListOfMeat = feline.eatMeat();

        Mockito.verify(feline).getFood("Хищник");
        Assert.assertEquals("Method getMeat return incorrect value.",expectedListOfMeat, aclualListOfMeat);
    }

    // Готово. Мок не нужен, тк нет зависимости от др. методов или классов
    @Test
    public void getFamilyReturnsCorrectValue(){
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";

        String actualFamily = feline.getFamily();

        Assert.assertEquals("Method getFamily return incorrect value.", expectedFamily, actualFamily );
    }

    // Готово. Есть зависимость от метода .getKittens(int kittensCount). Нужен мок на метод
    @Test
    public void getKittensReturnsCorrectValue(){
        int expectedKittens = 1;
        Mockito.when(feline.getKittens(1)).thenReturn(1);

        int actualKittens = feline.getKittens();

        Assert.assertEquals("Method getKittens return incorrect value.", expectedKittens, actualKittens );
    }

    // Готово. Мок не нужен, тк нет зависимости от др. методов или классов
    @Test
    public void getKittensWithParametersCall() {
        Feline feline = new Feline();
        int expectedKittens = 10;

        int actualKittens = feline.getKittens(10);

        Assert.assertEquals("Method getKittens with parameter return incorrect value.", expectedKittens, actualKittens);
    }
}
