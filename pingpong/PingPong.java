


import mpi.*;

public class PingPong {

	static final int PROC_A = 0;
	static final int PROC_B = 1;
	
	static final int PING = 42;
	static final int PONG = 23;

	static int bufferSize = 10000;
	static int  inBuffer[] = new int[bufferSize];
	static int outBuffer[] = new int[bufferSize];

	public static void main(String args[]) throws Exception {
		MPI.Init(args);
		int me = MPI.COMM_WORLD.Rank();
		
		if(me == 0){
			MPI.COMM_WORLD.Send(outBuffer, 0, length, MPI.INT, PROC_B, PING);
			MPI.COMM_WORLD.Recv( inBuffer, 0, length, MPI.INT, PROC_B, PONG);
		} else {
			MPI.COMM_WORLD.Recv(outBuffer, 0, length, MPI.INT, PROC_B, PONG);
			MPI.COMM_WORLD.Send( inBuffer, 0, length, MPI.INT, PROC_B, PING);
		}

		
		MPI.Finalize();
	}
}