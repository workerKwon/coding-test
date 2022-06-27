import java.util.*;
import java.util.stream.Collectors;

/**
 * 중복이 아닌 값들만 표시되도록
 */
public class CompanyFilteringTest {
    public static void main(String[] args) {
        Collection<Integer> a = Arrays.asList(1, 3, 2, 1);
        for (int b : isValid(a)) {
            System.out.println(b);
        }
    }

    public static Collection<Integer> isValid(Collection<Integer> c) {
//        return c.stream().filter(d -> Collections.frequency(c, d) == 1).collect(Collectors.toCollection(ArrayList::new));
        return new HashSet<>(c).stream().filter(d -> Collections.frequency(c, d) == 1).collect(Collectors.toCollection(ArrayList::new));
    }


}
