
//FIXING LAZY CLASSES PROBLEM BY CREATING ENUM CLASS IN ORDER TO CLASSIFY THE VALUES OF CLOTHING MATERIAL 

package data;

public enum ClothesKind{
	
	SKIRT("Skirt"),
	COAT("Coat"),
	SHIRT("Shirt"),
	TROUSER("Trouser");

	private String value;
	
	ClothesKind(String value) {
		this.value = value;
	}
	
	
	public String getValue()
	{
		return value;
	}

}
