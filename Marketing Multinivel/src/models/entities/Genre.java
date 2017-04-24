package models.entities;

public enum Genre {
	
    FEMALE("Fema"), MALE("Hombre"), UNSPECIFIED("Unsp");
    
	String nameGenre;
	
    private Genre(String name) {
    	this.nameGenre = name;
    }
    
	public String getNameGenre() {
		return nameGenre;
	}
	
	public void setNameGenre(String nameGenre) {
		this.nameGenre = nameGenre;
	}
    
    
    
}
