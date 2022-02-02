package Dish;

public class DishSelectedField {
	
	private String name;
	private int calories;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	
	public DishSelectedField(String name, int calories) {
		this.name = name;
		this.calories = calories;
	}
	
	
	public DishSelectedField() {}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DishSelectedField [name=").append(name).append(", calories=").append(calories).append("]");
		return builder.toString();
	}
	
	
}
