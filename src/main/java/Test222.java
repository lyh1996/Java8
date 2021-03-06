/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-07-18 17:34
 */

/**
 * _       _
 * (_\     /_)
 * ))   ((
 * .-"""""""-.
 * /^\/  _.   _.  \/^\
 * \(   /__\ /__\   )/
 * \,  \o_/_\o_/  ,/
 * \    (_)    /
 * `-.'==='.-'
 * __) - (__
 * /  `~~~`  \
 * /  /     \  \
 * \ :       ; /
 * \|==(*)==|/
 * :       :
 * \  |  /
 * ___)=|=(___
 * jgs {____/ \____}
 */

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LYH
 * @date 2020/07/18 17:34
 */
public class Test222 {

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
       /* double lendRate = Optional.ofNullable(0.00).orElse(0d) * 100d ;
        //保留两位小数
        System.out.println(new DecimalFormat("#.00").format(lendRate));

        System.out.println(BigDecimal.valueOf(lendRate)+"%");

        int a = 40;
        BigDecimal num = BigDecimal.valueOf(40).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP);

        System.out.println(BigDecimal.valueOf(0.3).compareTo(num) > 0);

        AtomicInteger atomicInteger = new AtomicInteger(10);

        System.out.println(atomicInteger.decrementAndGet());*/

/*        System.out.println(String.format("%0" + 3 + "d", 10000));

        System.out.println(ThreadLocalRandom.current().nextLong(System.currentTimeMillis()));

        System.out.println(System.currentTimeMillis());*/
        //System.out.println(EmojiUtil.isEmoji("正常"));

        System.out.println("[\"//test.laidiantech.com/api/erp-file-center/file/MjAyMS8wMy8yMy85YjU1YjU3NDlm\"]".length());


        //Socket client = new Socket("127.0.0.1", 9999);

        System.out.println(LocalDate.now().plusMonths(0).withDayOfMonth(30));

        // {}里面的数字可以用来指定前后缀的长度
        String str = "123456789";
        System.out.println(handle(str));

    }

    public static String handle(String str) {
        String regex = "(\\w{4})(.*)(\\w{4})";
        Matcher m = Pattern.compile(regex).matcher(str);
        if (m.find()) {
            String rep = m.group(2);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < rep.length(); i++) {
                sb.append("*");
            }
            return str.replaceAll(rep, sb.toString());
        }
        return str;
    }
}