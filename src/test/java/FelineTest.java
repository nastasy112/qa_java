import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Feline feline;

    @Test
    public void getMeatReturnCorrectList() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedListOfMeat = Arrays.asList("Животные", "Птицы", "Рыба");

        List<String> aclualListOfMeat = feline.eatMeat();

        Assert.assertEquals("Method getMeat return incorrect value.",expectedListOfMeat, aclualListOfMeat);
    }

    @Test
    public void getFamilyReturnsCorrectValue(){
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";

        String actualFamily = feline.getFamily();

        Assert.assertEquals("Method getFamily return incorrect value.", expectedFamily, actualFamily );
    }

    @Test
    public void getKittensReturnsCorrectValue(){
        int expectedKittens = 10;
        Mockito.when(feline.getKittens()).thenReturn(expectedKittens);

        int actualKittens = feline.getKittens();

        Assert.assertEquals("Method getKittens return incorrect value.", expectedKittens, actualKittens );
    }

    // параметризовать?
    @Test
    public void getKittensWithParametersCall() {
        feline.getKittens(10);

        Mockito.verify(feline).getKittens(Mockito.anyInt());
    }
}
