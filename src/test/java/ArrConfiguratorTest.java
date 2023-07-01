import com.sun.jdi.connect.Connector;
import org.Lesson6.ArrConfigurator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrConfiguratorTest {
    private ArrConfigurator arrConfigurator;

    @ParameterizedTest
    @MethodSource("dataForArrayReturner")
    public void testArrayReturner(int[] arr, int[] resoultArr) {
        arrConfigurator = new ArrConfigurator();
        Assertions.assertArrayEquals(resoultArr, arrConfigurator.arrayReturner(arr));
    }

    public static Stream<Arguments> dataForArrayReturner(){
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{2,2,2,2,2,2,2},new int[]{2,2,2}));
        out.add(Arguments.arguments(new int[]{2,3,2,3,2,3},new int[]{2,3}));
        out.add(Arguments.arguments(new int[]{3,45,45,645,56,76,67},new int[]{56,76,67}));
        out.add(Arguments.arguments(new int[]{1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7},new int[]{}));

        return out.stream();
    }
}
