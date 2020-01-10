package test.nowcode;

import java.util.*;

/**
 * Description:
 * <p>
 * 牛客网练习
 *
 * @author heyefu
 * Create in: 2020-01-10
 * Time: 10:23
 **/
public class Main {

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //long l = sc.nextLong();
        //System.out.println(getResult(l));
        sortString();
    }

    /**
     * Description:
     * <p>
     * 通过价值率?
     *
     * @author heyefu 16:06 2020/1/10
     **/
    public static void shoppingList() {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int num = sc.nextInt();
        Map<Integer, MainPart> parts = new HashMap<>();
        int i = 1;
        while (num > 0) {
            int price = sc.nextInt();
            int level = sc.nextInt();
            int parentId = sc.nextInt();
            if (parentId != 0) {
                parts.put(i, new Enclosure(i, level, price, parts.get(parentId)));
            } else {
                parts.put(i, new MainPart(i, level, price));
            }
            i++;
            num--;
        }
    }

    public static void sortString() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        sc.nextLine();
        while (n > 0) {
            System.out.println(n);
            list.add(sc.nextLine());
            n--;
        }
        Collections.sort(list);
        list.forEach(System.out::println);
    }

    public static void reverseString() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] array = s.split(" ");
        int len = array.length;
        for (int i = len - 1; i >= 0; i--) {
            System.out.printf(array[i] + " ");
        }
    }

    /**
     * Description:
     * <p>
     * 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
     * <p>
     * 输入描述:
     * 先输入键值对的个数
     * 然后输入成对的index和value值，以空格隔开
     * <p>
     * 输出描述:
     * 输出合并后的键值对（多行）
     * <p>
     * 示例： 输入
     * 4
     * 0 1
     * 0 2
     * 1 2
     * 3 4
     * <p>
     * 输出
     * <p>
     * 0 3
     * 1 2
     * 3 4
     *
     * @author heyefu 11:02 2020/1/10
     **/
    public static void mergeTables() {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        Map<String, Integer> map = new HashMap<>();
        while (number > 0) {
            String line = sc.nextLine();
            String[] s = line.split(" ");
            if (map.containsKey(s[0])) {
                map.put(s[0], map.get(s[0]) + Integer.parseInt(s[1]));
            } else {
                map.put(s[0], Integer.parseInt(s[1]));
            }
            number--;
        }
        List<String> key = new ArrayList<>(map.keySet());
        key.sort(Comparator.comparingInt(Integer::parseInt));
        for (String k : key) {
            System.out.println(k + " " + map.get(k));
        }
    }


    /**
     * Description:
     * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
     * <p>
     * 最后一个数后面也要有空格
     * <p>
     * 示例 输入
     * <p>
     * 180
     * <p>
     * 输出
     * <p>
     * 2 2 3 3 5
     * <p>
     * 2 * 2 * 3 * 3 * 5 = 180
     * <p>
     * <p>
     * 从2开始遍历，如果该数能被ulDataInput整除，且自身为质数，则为因子,继续
     *
     * @param ulDataInput 输入一个long型整数
     * @return java.lang.String
     * @author heyefu 10:24 2020/1/10
     **/
    public static String getResult(long ulDataInput) {
        StringBuilder s = new StringBuilder();
        long i = 2;
        while (i <= ulDataInput) {
            if (ulDataInput % i == 0 && isPrime(i)) {
                s.append(i).append(" ");
                ulDataInput = ulDataInput / i;
                i = 2;
            } else {
                i++;
            }
        }

        return s.toString();
    }

    public static boolean isPrime(long number) {
        if (number > 2 && number % 2 == 0) {
            return false;
        }
        for (int i = 3; i < number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class MainPart {
    int id;
    int level;
    int price;
    int total;

    public MainPart(int id, int level, int price) {
        this.id = id;
        this.level = level;
        this.price = price;
        this.total = this.level * this.price;
    }
}

class Enclosure extends MainPart {
    MainPart parent;

    public Enclosure(int id, int level, int price, MainPart parent) {
        super(id, level, price);
        this.parent = parent;
        this.total = this.level * this.price + parent.total;
    }
}
