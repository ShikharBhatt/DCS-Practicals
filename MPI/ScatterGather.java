import mpi.MPI;

public class ScatterGather{
    public static void main(String args[]){
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        int root = 0;

        int sendbuf[]=null;
        int recvbuf[]=null;

        sendbuf = new int[size];
        recvbuf = new int[size];

        if(rank == root){
            sendbuf[0] = 10;
            sendbuf[1] = 20;
            sendbuf[2] = 30;
            sendbuf[3] = 40;

            System.out.print("Processor. "+rank+"has data: ");
            for(int i=0; i<size; i++){
                System.out.print(sendbuf[i]+" ");
            }
            System.out.println();   
        } 

    MPI.COMM_WORLD.Scatter(sendbuf,0,1,MPI.INT,recvbuf,0,1,MPI.INT,root);
    System.out.println("Processor " + rank + " has data: "+recvbuf[0]);
    System.out.println("Processor " + rank + " is doubling the data");

    recvbuf[0]=recvbuf[0]*2;

    MPI.COMM_WORLD.Gather(recvbuf,0,1,MPI.INT, sendbuf,0,1,MPI.INT,root);

    if(root==rank){
        System.out.println("Process 0 has data: ");
        for(int i=0; i<4; i++){
            System.out.print(sendbuf[i]+" ");
        }
        System.out.println();
    }
    MPI.Finalize();
    }

}