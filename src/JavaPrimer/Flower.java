package Chapter1JavaPrimer;

public class Flower {
	
	private String flowerName;
	private int numberOfPetals;
	private float flowerPrice;
	
	public Flower(){		
		this.flowerName = "Lily";
		this.numberOfPetals = 12;
		this.flowerPrice = 50;
	}
	
	public String getFlowerName() {
		return flowerName;
	}

	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
	
	public int getNumberOfPetals(){
		return numberOfPetals;
	}
	
	public void setNumberOfPetals(int numberOfPetals){
		this.numberOfPetals = numberOfPetals;
	}
	
	public float getFlowerPrice(){
		return flowerPrice;
	}
	
	public void setFlowerPrice(float flowerPrice){
		this.flowerPrice = flowerPrice;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Flower flower = new Flower();
		String s = flower.getFlowerName();
		System.out.println("Flower name: "+s);
		int i = flower.getNumberOfPetals();
		System.out.println("Flower petals: " +i);
		float f = flower.getFlowerPrice();
		System.out.println("Flower price: " +f);
	}

}
