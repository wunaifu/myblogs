package com.coderpwh.stream;

import com.beust.jcommander.internal.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by coderpwh on 2017/12/26.
 */
public class Stream5 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("d2","a2","b1","b3","c");

        List<String> strings2 = Lists.newArrayList("b1","b2","b3","a2","d2","c");
//        test1(strings);
//        test2(strings);
//        test3(strings);
//          test4(strings);
//          test5(strings);
          test6(strings);
        System.out.println("= = = = = = = = =");
         test6(strings2);
//             test7(strings);
//             test8(strings);
    }


    private static void test1(List<String> stringCollection){
        stringCollection
                .stream()
                .filter(s->{
                    System.out.println("filter: "+s);
                    return true;
                }).forEach(s-> System.out.println("forEach:"+s));
    }

    private static void test2(List<String> stringCollection){

        stringCollection
                .stream()
                .map(s->{
                    System.out.println("map："+s);
                    return s.toUpperCase();
                })
                .filter(s->{
                    System.out.println("filter: "+s);
                    return s.startsWith("A");
                }).forEach(s-> System.out.println("forEach："+s));

    }

    private static void  test3(List<String> stringCollection){
        stringCollection
                .stream()
                .filter(s->{
                    System.out.println("filter: "+s);
                    return s.startsWith("a");
                })
                .map(s->{
                    System.out.println("map： "+s);
                    return s.toUpperCase();
                }).forEach(s-> System.out.println("forEach:"+s));
    }

    private  static void test4(List<String> stringCollection){
        stringCollection
                .stream()
                .sorted((s1,s2)->{
                    System.out.printf("sort:   %s;%s\n",s1,s2);
                    return s1.compareTo(s2);
                })
                .filter(s->{
                    System.out.println("filter： "+s);
                    return s.toLowerCase().startsWith("a");
                }).map(s->{
            System.out.println("map：   "+s);
            return  s.toUpperCase();
        }).forEach(s-> System.out.println("forEach:"+s));
    }

    private static void test5(List<String> stringCollection){

        stringCollection
                .stream()
                .filter(s->{
                    System.out.println("filter:  "+s);
                    return s.toLowerCase().startsWith("a");
                }).sorted((s1,s2)->{
            System.out.printf("sort:  %s;%s\n",s1,s2);
            return s1.compareTo(s2);
        }).map(s->{
            System.out.println("map：   "+s);
            return s.toUpperCase();
        }).forEach(s-> System.out.println("forEach: "+s));

    }

    private static void test6(List<String> stringCollection){
        stringCollection
                .stream()
                .map(s->{
                    System.out.println("map:      "+s);
                    return  s.toUpperCase();
                }).anyMatch(s->{
            System.out.println("anyMatch:"+s);
            return  s.startsWith("A");
        });
    }

    private static void test7(List<String>stringCollection){
        Stream<String> stream = stringCollection
                .stream()
                .filter(s->s.startsWith("a"));

        stream.anyMatch( s -> true);

        // 此处异常 stream 流关闭
        stream.noneMatch(s -> true);

    }

    private static void test8(List<String> stringCollection){

        Supplier<Stream<String>> streamSupplier = () -> stringCollection
                .stream()
                .filter(s->s.startsWith("a"));

        streamSupplier.get().anyMatch(s->true);
        // true
        System.out.println( streamSupplier.get().anyMatch(s->true));

        streamSupplier.get().noneMatch(s->true);
         // false
        System.out.println(streamSupplier.get().noneMatch(s->true));

    }



}
