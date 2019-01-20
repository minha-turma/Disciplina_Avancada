
import java.util.ArrayList;
import java.util.Arrays;

public class Point {
	
	private String link; 
	private ArrayList<Double> arrayCaracteristicas;
	

	public Point(String link) {
		
		this.arrayCaracteristicas = new ArrayList<Double>();
		this.link = link;
	}

	
	public ArrayList<Double> getCaracteristicas() {
		return arrayCaracteristicas;
	}
	
	public void setCaracteristicas(ArrayList<Double> arraylist) {
		arrayCaracteristicas = arraylist;
	}


	public String getLink(){
		return link;
	}
	
	public void addCaracteristica(double caracteristica) {
		
		this.arrayCaracteristicas.add(caracteristica);
		
	}



	public void setLink(String link) {
		this.link = link;
	}


	// distancia euclidiana
	public static double euclidianDistance(Point ponto, Point centro){
		
		double sum = 0;
		
		for(int i = 0; i < (ponto.arrayCaracteristicas).size(); i++) {
			sum = sum + Math.sqrt(Math.pow((ponto.getCaracteristicas().get(i) - centro.getCaracteristicas().get(i)), 2));
		}
		
		return sum;
		
	}
	
	public String toString() {
	
		return this.getLink();
		
	}
	
	public boolean equals(Point ponto) {
		
		
		 if(Arrays.equals(this.arrayCaracteristicas.toArray(),ponto.getCaracteristicas().toArray())) {
			 
			 return true;
		 }
		 else {
			 return false;
		 }
			
	
	}
		
	

}
