import lesson7.Test3;
import lesson7.Tester;
import lesson7.Test1;
import lesson7.Test2;
import lesson7.Test3;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestMainTest {

    @ParameterizedTest
    @MethodSource("dataTestRun")
    public void testRun(Object o){
        Tester.start(o);
    }

    public static Stream<Arguments> dataTestRun(){
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new Test1()));
        out.add(Arguments.arguments(new Test2()));
        out.add(Arguments.arguments(new Test3()));
        return out.stream();
    }


}
