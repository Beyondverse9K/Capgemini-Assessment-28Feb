package multi_threading;

class demo implements Runnable{
	int count=0;
	synchronized public void show() { // synchronized to avoid race condition (random output)
		count++;
	}
	@Override
	public void run() {
		for(int i=1;i<=500;i++) {
			show();
		}
	}
}
public class Synchronization
{
	public static void main(String[] args) {
		demo d= new demo();
		Thread t1=new Thread(d);
		Thread t2=new Thread(d);
		t1.start();
		t2.start();
		//No output as the both thread is executed together
		System.out.println(d.count);
		try {
			t1.join();
			t2.join();
			//Stops our thread and execute main thread first
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(d.count);
	} 
}