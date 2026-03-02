package multi_threading;

class demo1 implements Runnable{
	int count=0;
	public void show() {
		count++;
	}
	@Override
	public void run() {
		show();
	}
}
public class NotSynchronization
{
	public static void main(String[] args) {
		demo1 d= new demo1();
		Thread t1=new Thread(d);
		t1.start();//No output as the both thread is executed together
		System.out.println(d.count);
		try {
			t1.join();//Stops our thread and execute main thread first
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(d.count);
	} 
}