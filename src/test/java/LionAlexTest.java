import com.example.Feline;
import com.example.LionAlex;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {

    @Mock
    private Feline feline;

    @Test
    public void getFriendsReturnCorrectValue() throws Exception {
        LionAlex lionAlex = spy(new LionAlex());
        List<String> expectedListOfFriends = List.of("Марти", "Глория", "Мелфан");

        List<String> actualListOfFriends = lionAlex.getFriends();

        Assert.assertEquals("Method getFriends return incorrect value.", expectedListOfFriends, actualListOfFriends);
    }

    @Test
    public void getPlaceOfLivingReturnCorrectValue() throws Exception {
        LionAlex lionAlex = spy(new LionAlex());
        String expectedPlaceOfLiving = "Нью-Йоркский зоопарк";

        String aclualPlaceOfLiving = lionAlex.getPlaceOfLiving();

        Assert.assertEquals("Method getPlaceOfLiving return incorrect value.", expectedPlaceOfLiving , aclualPlaceOfLiving);
    }

    @Test
    public void getKittensReturnZero(){
        LionAlex lionAlex = spy(new LionAlex(feline));
        int expectedKittens = 0;

        int actualKittnes = lionAlex.getKittens();

        Mockito.verify(feline).getKittens(0);
        Assert.assertEquals("Method getKittnes in LionAlex class return not zero", expectedKittens, actualKittnes);

    }

}
