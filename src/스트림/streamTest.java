package 스트림;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class streamTest {

    public streamTest(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(raoul, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
        System.out.println("1번");
        transactionList.stream()
                .filter(key -> key.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .forEach(System.out::println);

        // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
        System.out.println("2번");
        transactionList.stream()
                .map(key -> key.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        // 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
        System.out.println("3번");
        transactionList.stream()
                .map(key -> key.getTrader()) // map으로 먼저 trader부터 가져와서 진행하네 filter는 그 후에 사용하는게 효율적인듯
                .filter(key -> key.getCity().equals("Cambridge"))
                .sorted(comparing(Trader::getName))
                .forEach(System.out::println);

        // 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
        System.out.println("4번");
        System.out.println(transactionList.stream()
                .map(key -> key.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (a, b) -> a + b));

        // 5. 밀라노에 거래자가 있는가?
        System.out.println("5번");
        System.out.println(transactionList.stream().anyMatch(key -> key.getTrader().getCity().equals("Milan")));

        // 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
        System.out.println("6번");
        transactionList.stream()
                .filter(key -> key.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // 7. 전체 트랜잭션 중 최댓값은 얼마인가 ?
        System.out.println("7번");
        System.out.println(transactionList.stream().map(Transaction::getValue).reduce(Integer::max));

        // 8. 전체 트랜잭션 중 최솟값은 얼마인가 ?
        System.out.println("8번");
        System.out.println(transactionList.stream().map(key -> key.getValue()).reduce((a, b) -> a < b ? a : b));


    }

    class Transaction{
        private final Trader trader;
        private final int year;
        private final int value;

        Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public Trader getTrader() {
            return trader;
        }

        public int getYear() {
            return year;
        }

        public int getValue() {
            return value;
        }

        public String toString() {
            return "Transaction{" +
                    "trader=" + trader +
                    ", year=" + year +
                    ", value=" + value +
                    '}';
        }
    }

    class Trader {
        private final String name;
        private final String city;

        Trader(String name, String city) {
            this.name = name;
            this.city = city;
        }


        public String getName() {
            return name;
        }

        public String getCity() {
            return city;
        }

        public String toString() {
            return "Trader{" +
                    "name='" + name + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }
}
