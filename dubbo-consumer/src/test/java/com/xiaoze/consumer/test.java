package com.xiaoze.consumer;


import java.math.BigDecimal;
import java.util.*;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

public class test {
    public static void main(String[] args) {
        BigDecimal[] array = new BigDecimal[]{BigDecimal.valueOf(26000), BigDecimal.valueOf(26000), BigDecimal.valueOf(26000), BigDecimal.valueOf(26000),
                BigDecimal.valueOf(26000), BigDecimal.valueOf(26000), BigDecimal.valueOf(26000), BigDecimal.valueOf(26000),
                BigDecimal.valueOf(26000), BigDecimal.valueOf(26000), BigDecimal.valueOf(26000), BigDecimal.valueOf(26000)};
        BigDecimal miankouchu = BigDecimal.valueOf(5000);
        BigDecimal juanzee = BigDecimal.valueOf(300);
        BigDecimal zhuanxiang = BigDecimal.valueOf(2000);
        BigDecimal wxyj = new BigDecimal("638.77");
        BigDecimal total = new BigDecimal(0);
        //累计已交税；
        BigDecimal aways = BigDecimal.ZERO;
        for (int i = 1; i <= array.length; i++) {
            BigDecimal miankouchudb = miankouchu.multiply(new BigDecimal(i + ""));
            BigDecimal juanzeedb = i<5?juanzee.multiply(new BigDecimal( i+ "")):BigDecimal.valueOf(1200);
            BigDecimal zhuanxiangdb = zhuanxiang.multiply(new BigDecimal(i + ""));
            BigDecimal wxyjdb = wxyj.multiply(new BigDecimal(i + ""));
            total = total.add(array[i - 1]);
            BigDecimal bigDecimals = total.subtract(miankouchudb).subtract(juanzeedb).subtract(zhuanxiangdb).subtract(wxyjdb);
//            System.out.println(i + "月份的总收入:" + total);
//            System.out.println(i + "月份的纳税所得额:" + bigDecimals);
//            System.out.println(i + "月份的累计基础扣除" + miankouchudb);
//            System.out.println(i + "月份的累计其它扣除" + juanzeedb);
//            System.out.println(i + "月份的专项扣除" + zhuanxiangdb);

            System.out.print(i+"月工资:"+array[i-1]+"#");
            //应交税
            BigDecimal subed = desc(bigDecimals);
            System.out.print("五金总额:"+wxyjdb+"#");

//            System.out.println("应该交税:" + subed);
//            System.out.println("已经交税:" + aways);

            BigDecimal shijijiaosui = subed.subtract(aways);
            System.out.print("到手现:"+array[i-1].subtract(shijijiaosui).subtract(BigDecimal.valueOf(638.77))+"#");
            System.out.print("实际交税:" + shijijiaosui+"#");
            System.out.println("=====================================s");
            aways = subed;
        }
    }


    public static BigDecimal desc(BigDecimal decimal) {
        //应该缴纳税额;
        BigDecimal result = BigDecimal.ZERO;

        if (decimal.compareTo(BigDecimal.valueOf(36000)) == -1) {
            BigDecimal zd = decimal.multiply(BigDecimal.valueOf(0.03));
//            System.out.println("税率:0.03");
//            System.out.println("速算扣除:0");
            result=result.add(zd);
            return result;
        } else {
            BigDecimal zd = BigDecimal.valueOf(36000).multiply(BigDecimal.valueOf(0.03));
            result=result.add(zd);
        }


        if(decimal.compareTo(BigDecimal.valueOf(144000))==-1){
            BigDecimal temp= decimal.subtract(BigDecimal.valueOf(36000));
            BigDecimal zd = temp.multiply(BigDecimal.valueOf(0.1));
//            System.out.println("税率:0.1");
//            System.out.println("速算扣除:2520");
            result=result.add(zd);
            return result;
        }else{
            BigDecimal temp=BigDecimal.valueOf(144000).subtract(BigDecimal.valueOf(36000));
            BigDecimal zd = temp.multiply(BigDecimal.valueOf(0.1));
            result=result.add(zd);
        }



        if(decimal.compareTo(BigDecimal.valueOf(300000))==-1){
            BigDecimal temp= decimal.subtract(BigDecimal.valueOf(144000));
            BigDecimal zd = temp.multiply(BigDecimal.valueOf(0.2));
//            System.out.println("税率:0.20");
//            System.out.println("速算扣除:16920");
            result=result.add(zd);
            return result;
        }else{
            BigDecimal temp=BigDecimal.valueOf(420000).subtract(BigDecimal.valueOf(300000));
            BigDecimal zd = temp.multiply(BigDecimal.valueOf(0.2));
            result=result.add(zd);
        }

        return result;

    }

    /**
     * Returns a power of two size for the given target capacity.
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
