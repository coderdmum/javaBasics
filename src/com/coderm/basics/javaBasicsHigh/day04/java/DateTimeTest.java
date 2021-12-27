package com.coderm.basics.javaBasicsHigh.day04.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk 8֮ǰ������ʱ���API����
 * 1. System����currentTimeMillis();
 * 2. java.util.Date������java.sql.Date
 * 3. SimpleDateFormat
 * 4. Calendar
 *
 * @author shkstart
 * @create 2019 ���� 11:35
 */
public class DateTimeTest {
    /*
    SimpleDateFormat��ʹ�ã�SimpleDateFormat������Date��ĸ�ʽ���ͽ���

    1.����������
    1.1 ��ʽ�������� --->�ַ���
    1.2 ��������ʽ��������̣��ַ��� ---> ����

    2.SimpleDateFormat��ʵ����

     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //ʵ����SimpleDateFormat:ʹ��Ĭ�ϵĹ�����
        SimpleDateFormat sdf = new SimpleDateFormat();

        //��ʽ�������� --->�ַ���
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //��������ʽ��������̣��ַ��� ---> ����
        String str = "19-12-18 ����11:43";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //*************����ָ���ķ�ʽ��ʽ���ͽ��������ô��εĹ�����*****************
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //��ʽ��
        String format1 = sdf1.format(date);
        System.out.println(format1);//2019-02-18 11:48:27
        //����:Ҫ���ַ��������Ƿ���SimpleDateFormatʶ��ĸ�ʽ(ͨ����������������),
        //�������쳣
        Date date2 = sdf1.parse("2020-02-18 11:48:27");
        System.out.println(date2);
    }

    /*
    ��ϰһ���ַ���"2020-09-08"ת��Ϊjava.sql.Date

    ��ϰ����"�����������ɹ��"   1990-01-01  xxxx-xx-xx ���棿ɹ����

    ������2020-09-08 �� ������

    ������ % 5 == 1,2,3 : ����
    ������ % 5 == 4,0 : ɹ��

    �������ļ��㣿
    ��ʽһ��( date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1
    ��ʽ����1990-01-01  --> 2019-12-31  +  2020-01-01 -->2020-09-08
     */
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);
//        System.out.println(date);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }


    /*
    Calendar������(�����ࣩ��ʹ��

     */
    @Test
    public void testCalendar(){
        //1.ʵ����
        //��ʽһ�����������ࣨGregorianCalendar���Ķ���
        //��ʽ���������侲̬����getInstance()
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());

        //2.���÷���
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        //calendar�ɱ���
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():������---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date ---> ������
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }
}
