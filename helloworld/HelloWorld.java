


import mpi.*;

public class HelloWorld {

	public static void main(String args[]) throws Exception {
		MPI.Init(args);
		int me = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();
		String procName = MPI.Get_processor_name();
		
		System.out.println("I'm "+me+" of "+size+" and my processor is "+procName);
		if(me == 0){
			System.out.println("Hello, World!");
		}
		MPI.Finalize();
	}
} 