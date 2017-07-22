package edu.csula.cs3220.midterm;

public class Restaurant {
	
	public final int id;
	public final String name;
	public final String url;
	public final int[] designRatings;
	public final int[] tasteRatings;
	
	public Restaurant(int id, String name, String url, int[] designRatings, int[] tasteRatings) {
		
		this.id = id;
		this.name = name;
		this.url = url;
		this.designRatings = designRatings;
		this.tasteRatings = tasteRatings;
		
	}


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public int[] getDesignRatings() {
		return designRatings;
	}

	public int[] getTasteRatings() {
		return tasteRatings;
	}

}
