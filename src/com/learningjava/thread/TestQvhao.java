package com.learningjava.thread;

public class TestQvhao {
    public static void main(String[] args){
        St  st = new St();
        Custm[] cus = new Custm[20];
        int[] ran = {1,1,1,0,1,0,1,1,1,0,1};
        //int[] ran = {1,0,1,1,0,1,0,1,0,1,1};
        for(int i=0;i<20;i++){
            int a = (int)(Math.random()*10);
            cus[i] = new Custm(i+1,ran[a]);
            st.add(cus[i]);

        }
        Worke wort = new Worke(st, "vip", true);//vip窗口，线程1
        Thread t1 = new Thread(wort);
        t1.start();

        Worke wort1 = new Worke(st, "1号" , false);//普通窗口，线程2，
        Thread t2 = new Thread(wort1);
        t2.start();

        Worke wort2 = new Worke(st, "2号" , false);//普通窗口，线程3，
        Thread t3 = new Thread(wort2);
        t3.start();
        Worke wort4 = new Worke(st, "3号" , false);//普通窗口，线程4，
        Thread t4 = new Thread(wort4);
        t4.start();


    }
}
class Custm{
    int key;
    int num;
    public Custm(int n, int k){
        num=n;
        key=k;
    }
}

class base {

}
class Worke implements Runnable{
    boolean isvip;
    St s;
    String ThreadName;
    public Worke(St ss,String n ,boolean vip){
        s=ss;
        ThreadName = n;
        isvip = vip;
    }
    boolean asd=true;
    public void run(){
        while(asd){
            if(s.isEmpty()==false){

                if(isvip){
                    //		synchronized(this){

                    Custm cu = s.dell().cus;
                    if(cu.key==0){

                        System.out.println("线程id" + Thread.currentThread().getId() +"\t"+ThreadName+"---窗口无人，请"+cu.num+"号【vip】顾客准备！");
                        System.out.println("线程id" + Thread.currentThread().getId() +"\t"+ThreadName+"---窗口"+cu.num+"号【vip】顾客就绪！");
                        System.out.println("线程id" + Thread.currentThread().getId() +"\t"+ThreadName+"---窗口"+cu.num+"号【vip】顾客正在办理！");
                        try {
                            Thread.sleep((int)(Math.random()*500));
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println("线程id" + Thread.currentThread().getId() +"\t"+ThreadName+"---窗口"+cu.num+"号【vip】顾客已离开-------！");

                        //	}else{

                        //		try {
                        //				Thread.sleep((int)(Math.random()*500));
                        //			} catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        //				e.printStackTrace();
                        //			}
                        //			}
                    }

                }else{
                    //		synchronized(this){

                    Custm cu = s.dell().cus;
                    if(cu.key==0){

                        System.out.println("线程id" + Thread.currentThread().getId() +"\t"+ThreadName+"---窗口无人，请"+cu.num+"号【vip】顾客准备！");
                        System.out.println("线程id" + Thread.currentThread().getId() +"\t"+ThreadName+"---窗口"+cu.num+"号【vip】顾客就绪！");
                        System.out.println("线程id" + Thread.currentThread().getId() +"\t"+ThreadName+"---窗口"+cu.num+"号【vip】顾客正在办理！");
                        try {
                            Thread.sleep((int)(Math.random()*500));
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println("线程id" + Thread.currentThread().getId() +"\t"+ThreadName+"---窗口"+cu.num+"号【vip】顾客已离开-------！");
                    }else{
                        System.out.println("线程id" + Thread.currentThread().getId() +"\t"+ThreadName+"---窗口无人，请"+cu.num+"号【普通】顾客准备！");
                        System.out.println("线程id" + Thread.currentThread().getId() +"\t"+ThreadName+"---窗口"+cu.num+"号【普通】顾客就绪！");
                        System.out.println("线程id" + Thread.currentThread().getId() +"\t"+ThreadName+"---窗口"+cu.num+"号【普通】顾客正在办理！");
                        try {
                            Thread.sleep((int)(Math.random()*500));
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println("线程id" + Thread.currentThread().getId() +"\t"+ThreadName+"---窗口"+cu.num+"号【普通】顾客已离开-------！");

                    }
                    //		}

                }
            }else{
                asd=false;
            }

        }
    }
}
class St{
    Node head;
    Node tail;
    public St(){
        tail=head=null;
    }
    public boolean isEmpty(){
        if(head==null){
            return true;
        }
        return false;
    }

    public void add(Custm c){
        Node node = new Node(c);
        if(isEmpty()){
            head=tail=node;
            head.front=null;
            tail.next=null;
        }else{
            tail.next=node;
            node.front=tail;
            tail=node;
            tail.next=null;
        }
    }
    public Node dell(){
        if(isEmpty()==false){
            if(head.next==null){
                Node nod=head;
                head=null;
                return nod;
            }else{
                Node nod=head;
                head=head.next;
                head.front=null;
                return nod;
            }
        }else{
            System.out.println("队列空了");
            return null;
        }
    }

    public Node  del(){
        if(isEmpty()==false){
            Node nod = findvip();
            if(nod==null){

                Node temp=head;
                if(head.next!=null){
                    Node node = head.next;
                    node.front=null;
                    head=node;
                }else{
                    head=null;
                }
                //head.front=null;
                temp.next=null;
                return temp;
            }else{
                if(nod==head){
                    nod=head;
                    head=null;
                    return nod;
                }else if(nod==tail){
                    Node tm = nod;
                    nod.front.next=null;
                    return tm;
                }else{
                    nod.front.next=nod.next;
                    nod.next.front=nod.front;
                    return nod;
                }
            }
        }else{
            System.out.println("队列空了");
            return null;
        }
    }

    public Node findvip(){
        if(isEmpty()==false){
            Node temp = head;
            while(temp!=null){
                if(temp.cus.key==0){
                    return temp;
                }
                temp = temp.next;
            }
        }
        return null;
    }


}
class Node{
    Custm cus;
    Node front;
    Node next;
    public Node(Custm c){
        cus =c;
        front = next = null;
    }
}