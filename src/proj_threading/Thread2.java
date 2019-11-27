package proj_threading;

public class Thread2 implements Runnable{
	
	@Override
	public void run() {
		   for(Integer i = 0; i < 10; i++) {
			   System.out.println("task two -- "+i);  
		   }
	}
}
