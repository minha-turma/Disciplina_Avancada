import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Random r = new Random();
	//	FileReader arquivo = new FileReader("src/IAfileMovies2.txt");
	//	FileReader arquivoUsers = new FileReader("src/IAfileUsers.txt");
		Kmeans var = new Kmeans();
	//	Scanner sc = new Scanner(arquivo).useDelimiter("\\n|,"); // lerá o arquivo com os filmes
	//	Scanner scan = new Scanner(arquivoUsers).useDelimiter("\\n|,"); //lerá os arquivos com os usuários e avaliações
	//	Scanner scanner = new Scanner(System.in);
		Point[] verifica = new Point[var.getK()];
		boolean loop = true;
		int j = 0;
		int contador = 0;
	
		while(contador< 100) {
			
			Point p = new Point("",0);
			p.addCaracteristica(r.nextInt(11));
			p.addCaracteristica(r.nextInt(11));
			var.addPoint(p);
			
			System.out.println(p);
			
			contador++;
			
		}
		contador = 0;
		
		System.out.print("\n\n");
		for(int i = 1;  i <= var.getK(); i++){
			
			Cluster c = new Cluster(i,var.getPontos(r.nextInt(10))); // instância de K Clusters
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
		
	}

}
