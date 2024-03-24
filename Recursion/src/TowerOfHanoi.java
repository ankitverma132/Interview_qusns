public class TowerOfHanoi {

	public static void main(String[] args) {

		int n = 3;
		char source = 'a';
		char aux = 'b';
		char dest = 'c';
		towerOfHanoi( n, source, aux, dest ) ;
	}
	
	//2^n-1 passes required
	public static void towerOfHanoi(int disks, char source,
						char auxiliary, char destination) {

        if( disks == 0 ){
            return;
        }
        if (disks == 1){ 
            System.out.println( source + " " + destination); 
            return; 
        } 
        towerOfHanoi( disks - 1, source, destination, auxiliary );
        
        System.out.println( source + " " + destination );
        
        towerOfHanoi( disks - 1, auxiliary, source , destination );
	}
}