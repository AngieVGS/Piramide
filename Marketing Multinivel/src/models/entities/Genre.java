package models.entities;

public enum Genre {
	
    FEMALE("Fema"), MALE("Male"), UNSPECIFIED("Unsp");
    
	String nameGenre;
    private Genre(String name) {
    	this.nameGenre = name;
    }
    
    
}
