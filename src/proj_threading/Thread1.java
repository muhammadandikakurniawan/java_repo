package proj_threading;

public class Thread1  implements Runnable{
	
	@Override
	 public void run(){  
		   for(Integer i = 0; i < 10; i++) {
			   System.out.println("task one --"+i);  
		   }
	}  
}
