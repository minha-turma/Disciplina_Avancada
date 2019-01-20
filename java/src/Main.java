import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Random r = new Random();
		FileReader arquivo = new FileReader("../recomender/data/data/final_dataset.txt");
		Kmeans var = new Kmeans();
		Scanner sc = new Scanner(arquivo).useDelimiter("\\n|,"); 
		Scanner scanner = new Scanner(System.in);
		Point[] verifica = new Point[var.getK()];
		boolean loop = true;
		int j = 0;
		int contador = 0;
	
		while(sc.hasNext()) {
			
			Point p = new Point("");
			
			for(int i = 0; i< 566; i++) {
				
				p.addCaracteristica(Double.valueOf(sc.next()));
				
			}
			
			p.setLink(sc.next());
			var.addPoint(p);
			
			System.out.println(p);
			
		}
		
		
		System.out.print("\n\n");
		for(int i = 1;  i <= var.getK(); i++){
			
			//Cluster c = new Cluster(i,var.getPontos(r.nextInt(10))); // instância de K Clusters
			Cluster c = new Cluster(i, var.getPontos(i-1));
			var.addCluster(c);
			System.out.println(c.getCentro());
		}
		
		
		while(loop){  // Dentro desse laço serão realizadas as operações do K-Means
				
				var.limpaCluster(); // limpa os clusters antes de recomeçar os agrupamentos 
				j++;
				System.out.println("Interação " + j);
			
				for(int i = 0;  i < var.getK(); i++){					//Exibe os centros dos clusters
					System.out.println(var.getClusters(i).getCentro()); //a cada interação
					verifica[i] = var.getClusters(i).getCentro();
				} 
				
				System.out.println("\n");
			
				var.clustering();
			
				for(int i = 0; i< var.getK(); i++){                       //exibe os pontos presentes em cada cluster
					System.out.println("Cluster " + var.getClusters(i).getNumber() );
					System.out.println("Centro: " + var.getClusters(i).getCentro());
					for(Point p: var.getClusters(i).getPontos()){
						System.out.println(p);
					}
					System.out.println();
				
				}
			
				var.newCenter();
			
				for (int i = 0; i< var.getK();i++) {    
					if(verifica[i].equals(var.getClusters(i).getCentro())) 
							contador ++;
					if(contador == var.getK()){ 
						loop = false;
						break;
					}
			
				}
		
				contador = 0;
				
			}
		var.sse();
		
	}

}
