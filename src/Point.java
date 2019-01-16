
import java.util.ArrayList;
import java.util.Arrays;

public class Point {
	
	private String categoria; 
	private int id;
	private ArrayList<Double> arrayCaracteristicas;
	

	public Point(String categoria, int id) {
		
		this.arrayCaracteristicas = new ArrayList<Double>();
		this.categoria = categoria;
		this.id = id;
	}

	
	public ArrayList<Double> getCaracteristicas() {
		return arrayCaracteristicas;
	}
	
	public void setCaracteristicas(ArrayList<Double> arraylist) {
		arrayCaracteristicas = arraylist;
	}


	public int getId(){
		return id;
	}
	
	public void addCaracteristica(double caracteristica) {
		
		this.arrayCaracteristicas.add(caracteristica);
		
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
		
		String s = "(";
		
		for(double d : this.arrayCaracteristicas ) {
			s = s.concat(d + " ");
		}
		s = s.concat(")");
		
		return s;
		
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
