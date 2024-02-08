class Sync{
    synchronized void printSync(int n){
        for(int i=1;i<=5;i++){
            System.out.println(n*i);
            try{

                Thread.sleep(400);
                }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}

class Sync1 extends Thread{
    Sync t;
    Sync1(Sync t)
    {
        this.t=t;
    }
    public void run(){
        t.printSync(10);
    }
}

class Sync2 extends Thread{
    Sync t;
    Sync2(Sync t)
    {
        this.t=t;
    }
    public void run(){
        t.printSync(200);
    }
}

public class TestSynchronization2{
    public static void main(String args[]){
        Sync obj=new Sync();
        Sync1 t1=new Sync1(obj);
        Sync2 t2=new Sync2(obj);
        t1.start();
        t2.start();
    }
}