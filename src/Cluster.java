import java.util.ArrayList;

public class Cluster {
	
	private int number ; //identificador do cluster
	private Point centro;
	private ArrayList<Point> clusterPontos;
	
	public Cluster(int number, Point centro){
		
		this.number = number;
		this.centro = centro;
		this.clusterPontos = new ArrayList<Point>();
		
	}
	
	public int getNumber(){
		return number;
	}

	public Point getCentro() {
		return centro;
	}
	
	public void setCentro(Point p){
		
		this.centro = p;
	}
	
	public void addPontos(Point pontos){
		this.clusterPontos.add(pontos);
	}
	
	public ArrayList<Point> getPontos() {
		return clusterPontos;
	} 
	 

}
