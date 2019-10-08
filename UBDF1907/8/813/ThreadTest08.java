package com.uek;

/**
 * 此类用于演示线程的死锁问题
 * 案例：绑匪绑了田雨
 *     张飞凡：你把田雨还给我，我把钱给你
 *     绑匪：你把钱给我，我把田雨还给你
 */
public class ThreadTest08 {
    public static void main(String[] args) {
    	
    	//线程类：
        DeadDemo d1 = new DeadDemo(true);  //张飞凡的线程
      //线程类：
        DeadDemo d2 = new DeadDemo(false);  //绑匪的线程
        
        d1.start();
        d2.start();
    }
}

class DeadDemo extends Thread{
    //共享资源：
    static ZhangFeiFan zhangFeiFan = new ZhangFeiFan();
    static BangFei bb = new BangFei();
    
    private boolean flag;
    public DeadDemo(boolean flag){
        this.flag = flag;
    }
    
    @Override
    public void run() {
    	
        if (flag) {   //张飞凡的线程
        	
            synchronized (bb) {
                zhangFeiFan.say();
                synchronized (zhangFeiFan) {
                    zhangFeiFan.get();
                }
            }
            
        } else {   //绑匪的线程
            synchronized (zhangFeiFan) {
                bb.say();
                synchronized (bb) {
                    bb.get();
                }
            }
        }
    }
}

//共享资源：
class BangFei{
    public void say(){
        System.out.println("绑匪说：你把钱给我，我把田雨还给你");
    }
    public void get(){
        System.out.println("绑匪终于拿到了想要的钱！");
    }
}

//共享资源：
class ZhangFeiFan{
    public void say(){
        System.out.println("张飞凡说：你把田雨还给我，我把钱给你");
    }
    public void get(){
        System.out.println("张飞凡终于救回了田雨");
    }
}

