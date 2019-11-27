package proj_threading;

import proj_threading.*;

public class app {

	public static void main(String[] args) throws InterruptedException {
		//way 1
		Thread t1 = new Thread(new Thread1());
		Thread t2 = new Thread(new Thread2());
		
		//way 2
//		Thread t1 = new Thread(()->{
//			   for(Integer i = 0; i < 10; i++) {
//				   System.out.println("task one ---"+i);  
//				   if(i == 3) {
//					   try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				   }
//			   }
//		});
//		Thread t2 = new Thread(()->{
//			   for(Integer i = 0; i < 10; i++) {
//				   System.out.println("task two ---"+i);  
//			   }
//		});
		
		t1.start();
		t2.start();
	}

}
