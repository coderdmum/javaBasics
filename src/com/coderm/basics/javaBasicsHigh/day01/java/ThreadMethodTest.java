package com.coderm.basics.javaBasicsHigh.day01.java;

/**
 * ����Thread�еĳ��÷�����
 * 1. start():������ǰ�̣߳����õ�ǰ�̵߳�run()
 * 2. run(): ͨ����Ҫ��дThread���еĴ˷��������������߳�Ҫִ�еĲ��������ڴ˷�����
 * 3. currentThread():��̬����������ִ�е�ǰ������߳�
 * 4. getName():��ȡ��ǰ�̵߳�����
 * 5. setName():���õ�ǰ�̵߳�����
 * 6. yield():�ͷŵ�ǰcpu��ִ��Ȩ
 * 7. join():���߳�a�е����߳�b��join(),��ʱ�߳�a�ͽ�������״̬��ֱ���߳�b��ȫִ�����Ժ��߳�a��
 *           ��������״̬��
 * 8. stop():�ѹ�ʱ����ִ�д˷���ʱ��ǿ�ƽ�����ǰ�̡߳�
 * 9. sleep(long millitime):�õ�ǰ�̡߳�˯�ߡ�ָ����millitime���롣��ָ����millitime����ʱ���ڣ���ǰ
 *                          �߳�������״̬��
 * 10. isAlive():�жϵ�ǰ�߳��Ƿ���
 *
 *
 * �̵߳����ȼ���
 * 1.
 * MAX_PRIORITY��10
 * MIN _PRIORITY��1
 * NORM_PRIORITY��5  -->Ĭ�����ȼ�
 * 2.��λ�ȡ�����õ�ǰ�̵߳����ȼ���
 *   getPriority():��ȡ�̵߳����ȼ�
 *   setPriority(int p):�����̵߳����ȼ�
 *
 *   ˵���������ȼ����߳�Ҫ��ռ�����ȼ��߳�cpu��ִ��Ȩ������ֻ�ǴӸ����Ͻ��������ȼ����̸߳߸��ʵ������
 *   ��ִ�С�������ζ��ֻ�е������ȼ����߳�ִ�����Ժ󣬵����ȼ����̲߳�ִ�С�
 *
 *
 * @author shkstart
 * @create 2019-02-13 ���� 2:26
 */
class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){

//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }

//            if(i % 20 == 0){
//                yield();
//            }

        }

    }

    public HelloThread(String name){
        super(name);
    }
}


public class ThreadMethodTest {
    public static void main(String[] args) {

        HelloThread h1 = new HelloThread("Thread��1");

//        h1.setName("�߳�һ");
        //���÷��̵߳����ȼ�
        h1.setPriority(Thread.MAX_PRIORITY);

        h1.start();

        //�����߳�����
        Thread.currentThread().setName("���߳�");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }

//            if(i == 20){
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

        }

//        System.out.println(h1.isAlive());

    }
}
