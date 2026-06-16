import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


//        User user1 = new User("John", 25);
//        User user2 = new User("Jane", 30);
//        User user3 = new User("Abraham", 40);
//        User user4 = new User("Peter", 30);
//
//        ArrayList<User> users = new ArrayList<>();
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//        users.add(user4);
//
//        Comparator<User> userComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
//
//        Collections.sort(users, userComparator);
//
//        for(User user : users){
//            System.out.println(user.toString());
//        }

//        final double baseValue = 10;
//        Calculator add = (a, b) -> a + b + baseValue;
//        baseValue = 19;

        //Calculator add = Double::sum;
//        Calculator divide = (a, b) -> a / b;
//        Calculator multiply = (a, b) -> a * b;
//        Calculator sub = (a, b) -> a - b;
//        System.out.println(add.calculate(3, 4));
//        System.out.println(divide.calculate(4, 2));
//        System.out.println(multiply.calculate(4, 2));
//        System.out.println(sub.calculate(5, 2));


//        Supplier<User> user = new Supplier<User>() {
//            @Override
//            public User get() {
//                return new User("Adnrey", 13);
//            }
//        };
//       Supplier<User> user = ()  -> new User("Azer", 30);
//       Supplier<Integer> num = () -> 1;
//
//        System.out.println(num.get());
//
//        Random random = new Random();
//        Supplier<Integer> randomNumber = () -> random.nextInt(10);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(randomNumber.get());
//        }

//        Consumer<Integer> consumer = (Integer num) -> System.out.println(num);
//        consumer.accept(12345);
//
//        Consumer<String> consumer2 = (str) -> System.out.println(str);
//        consumer2.accept("Hello");

//        Predicate<Integer> ageValidator = age -> age >= 18;
//        System.out.println(ageValidator.test(17));
//        System.out.println(ageValidator.test(18));
//        System.out.println(ageValidator.test(19));

//        Predicate<Integer> checkBigOne = (Integer num) -> (num + 90) > 100;
//        System.out.println(checkBigOne.test(90));


//        Function<Integer,String>f=x ->"Eded: "+x;
//        System.out.println(f.apply(5));
//
//        Function<Integer,Boolean>f1=x-> true;
//        System.out.println(f1.apply(5));
//
//        Function<Boolean,Integer> f2 =x-> 1;
//        System.out.println(f2.apply(true));

//        BiFunction<Integer , Integer , Boolean> check = (x, y) -> x > y;
//        System.out.println(check.apply(1, 2));
//        System.out.println(check.apply(2, 1));

//        BiConsumer<Integer, String>  f1 = (x, y) -> System.out.println(x + y);
//        f1.accept(1, "a");
//
//        BiConsumer<Integer, Integer> f2 = (x, y) -> System.out.println(x + y);
//        f2.accept(1, 3);

//        BiPredicate<BigDecimal, BigDecimal> checkNum = (x, y) -> x.compareTo(y) == 0 ? true : false;
//        System.out.println(checkNum.test(new BigDecimal("1.1"), new BigDecimal("1.1")));
      //  System.out.println(checkNum.test(2.0F, 1.1F));

//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        };


//        BinaryOperator<Integer> add = new BinaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer o1, Integer o2) {
//                return o1 + o2;
//            }
//        };
//      System.out.println(add.apply(99, 20));

//        BinaryOperator<Integer> binaryOperator = BinaryOperator.maxBy(Comparator.naturalOrder());
//        System.out.println(binaryOperator.apply(1, 2));


//        UnaryOperator<Integer> sub = (num) -> num*2 + 100;
//       System.out.println(sub.apply(101));

        Map<String, Integer> map = wordFrequencies ("a a a a b b b c c c c d d d d d d d");
        List<String> strings = topThreeWords (map);
        System.out.println(strings);


    }
    public static Map<String, Integer> wordFrequencies (String text){

        HashMap<String, Integer> wordFrequencies = new HashMap<>();
        List<String> words = Arrays.asList(text.split(" "));

        for (String word : words){
            //wordFrequencies.put( word, wordFrequencies.getOrDefault(word, 0) + 1);
          //  wordFrequencies.merge(word , 1, (oldValue, newValue) -> oldValue + newValue);

            wordFrequencies.merge(word, 1 , Integer::sum);
        }
        return wordFrequencies;
    }

    public static List<String> topThreeWords (Map<String, Integer> wordFrequencies)
    {
            ArrayList<Map.Entry<String, Integer>> words = new ArrayList<>(wordFrequencies. entrySet()) ;
            Comparator<Map.Entry<String, Integer>> wordComparator = (o1, o2) -> o2.getValue() - o1.getValue();

            words.sort (wordComparator);
            ArrayList<String> topThreewords = new ArrayList<>();
            Integer length = Math.min(words.size(), 3); // words.size() > 3 ? 3 : words.size();
            for(int i = 0; i < length; i++) {
                topThreewords.add(words.get (i). getKey()) ;
            };
            return topThreewords;
    }
}