/**
 * 시작문자가 영문자여야하고 띄어쓰기가 없으며 _는 하나여야한다.
 */
public class CompanyRegexTest {
    public static void main(String[] args) {
        System.out.println(isValid("asfb_werv")); // true
        System.out.println(isValid("weruiu kqkelwqe")); //fale
        System.out.println(isValid("12vvv_qqq")); // false
        System.out.println(isValid("_werbf_jtrtkk")); // false
        System.out.println(isValid("asdr123_nwerk_")); // false
    }
    
    private static boolean isValid(String name) {
        if(name.length() < 4) return false;
        else if (!name.matches("^[a-zA-Z].*")){ // value의 모든 내용이 일치하도록 정규표현식을 만들어줘야 한다.
            System.out.println("aasr" + " : " + "aasr".matches("^[a-zA-Z]"));
            System.out.println("a" + " : " + "a".matches("^[a-zA-Z]"));
            return false;
        }
        else if (name.contains(" ")) return false;
        else if (name.matches(".*_$")) return false; // 마찬가지로 value의 모든 내용이 일치하도록 정규표현식을 만들어줘야 한다.
        return true;
    }
}
