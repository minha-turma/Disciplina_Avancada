import java.lang.reflect.Array;
import java.util.ArrayList;

public class Kmeans {
	
	private int k = 14; // número de clusters
	private ArrayList<Point> pontos;
	private ArrayList<Cluster> clusters;
	
	
	public Kmeans(){
		this.pontos = new ArrayList<Point>();
		this.clusters = new ArrayList<Cluster>();
	}
	
	
	
	public int getK() {
		return k;
	}
	

	public ArrayList<Point> getPontos() {
		return pontos;
	}


	public void addPoint(Point p){
		
		this.pontos.add(p);
	}

	
	public Point getPontos(int num){
		
		return this.pontos.get(num);
	}
	
	
	public Cluster getClusters(int num){
		
		return this.clusters.get(num);
		
		
	}
	
	public void addCluster(Cluster c){
		
		this.clusters.add(c);
	}
	
	public void limpaCluster(){
		
		for(int i = 0; i< this.k;i++){
			this.getClusters(i).getPontos().clear();
		}
		
		
	}
	
	public void clustering(){
		
		double distancia;
		double minDistancia = 0;
		int clusterId = 0;
		
		for(Point p :  pontos){
			
			for(int i = 0; i< this.getK(); i++){
				Cluster c = clusters.get(i);
				distancia = Point.euclidianDistance(p, c.getCentro());
				
				if(i == 0){
					minDistancia = distancia;
					clusterId = i ;
				}
				else if(distancia < minDistancia){
					minDistancia = distancia;
					clusterId = i ;
				}
			}
			clusters.get(clusterId).addPontos(p);
			
		}
		
		
	}
	
	public void newCenter(){
		
		for(Cluster c : clusters){
			
			int counter = 0;
			ArrayList<Point> pontos = c.getPontos();
			ArrayList<Double> arrayCaracteristicas = new ArrayList<Double>();
			Point novoCentro = c.getCentro();
			double somas[] = new double[c.getCentro().getCaracteristicas().size()];
			
			for(Point p: pontos){
				counter ++;
				for(int i = 0; i<p.getCaracteristicas().size(); i++) {
					if(counter == 1) {
						somas[i] = p.getCaracteristicas().get(i);	
					}
					else {
						somas[i] = somas[i] + p.getCaracteristicas().get(i);
					}
				}
			}
			
			for(int i = 0; i< somas.length; i++) {
				arrayCaracteristicas.add(i, (somas[i]/counter));
			}
				
			
			Point centroide = new Point("Novo Centro");
			centroide.setCaracteristicas(arrayCaracteristicas);
			if(pontos.size() != 0){
				c.setCentro(centroide);
			}
		}	
	}
	
	
	public Point centroDados(){
		
		int counter = 0;
		double totalX = 0;
		double totalY = 0;
		ArrayList<Double> arrayCaracteristicas = new ArrayList<Double>();
		double somas[] = new double[this.getPontos(0).getCaracteristicas().size()];
		
		for(Point p: this.getPontos()){
			counter ++;
			for(int i = 0; i<p.getCaracteristicas().size(); i++) {
				if(counter == 1) {
					somas[i] = p.getCaracteristicas().get(i);	
				}
				else {
					somas[i] = somas[i] + p.getCaracteristicas().get(i);
				}
			}
			
		}
		
		for(int i = 0; i< somas.length; i++) {
			arrayCaracteristicas.add(i, (somas[i]/counter));
		}
			
		
		Point centroide = new Point("");
		centroide.setCaracteristicas(arrayCaracteristicas);
		
		return centroide;
	}
		
	
	public double wss(){
			
			double valor = 0;
			
			for(int i = 0; i< this.getK();i++){
				for(Point p: this.getClusters(i).getPontos()){
					valor = valor + Math.pow(Point.euclidianDistance(p, this.getClusters(i).getCentro()), 2);
				}
			}
			
			System.out.println("WSS"); //coesão
			System.out.printf("%.1f \n",valor);
			
			return valor;
		}
		
		
		public double bss(){
			
			double valor = 0;
			
			for(int i = 0; i< this.getK(); i++){
				
				valor = valor + this.getClusters(i).getPontos().size() * Math.pow(Point.euclidianDistance(this.getClusters(i).getCentro(), this.centroDados()), 2);
			}
			
			System.out.println("BSS");// separação
			System.out.printf("%.1f \n",valor);
			
			return valor;
		}
		
		
		public void sse(){
			
			double var = (this.bss() + this.wss());
			System.out.printf("Total: %.1f", var );
			
		}
}
