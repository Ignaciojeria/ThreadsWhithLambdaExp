
public class Main {
	
	private void metodothreads() {
		 while(true) { System.out.println("estoy corriendo en el hilo: "+Thread.currentThread().getName());
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}}
	}

	public void test() throws Exception {
		//Runnable thread=this::metodothreads;  nota: Hilo 1 podría perfectamente recibir la instancia thread
		//Forma A en hilo1
		Thread hilo1= new Thread(this::metodothreads);
		hilo1.start();
		
		//Forma B en hilo2
		Runnable hilo2=()->{ while(true) { System.out.println("estoy corriendo en el hilo: "+Thread.currentThread().getName());
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}}};
		
		new Thread(hilo2).start();
		
		hilo1.join(5000);
		
		System.out.println("me demoré un poco en pasar");		
	}
	public static void main(String[] args) throws Exception {
		new Main().test();
	}


}
