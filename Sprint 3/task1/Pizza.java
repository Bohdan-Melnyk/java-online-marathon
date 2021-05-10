package task1;

public class Pizza {
	private String cheese;
	private String meat;
	private String seafood;
	private String vegtable;
	private String mushroom;
	
	private Pizza() {}
	
	public static PizzaBuilder base() {
		return new PizzaBuilder();
	}
	
	public static class  PizzaBuilder {
		private Pizza pizza;
		private PizzaBuilder() {}
		
		public PizzaBuilder addCheese(String cheese) {
			pizza.cheese = cheese;
			return this;
		}
		public PizzaBuilder addMeat(String meat) {
			pizza.meat = meat;
			return this;
		}
		public PizzaBuilder addSeaFood(String seafood) {
			pizza.seafood = seafood;
			return this;
		}
		public PizzaBuilder addVegetable(String vegetable) {
			pizza.vegtable = vegetable;
			return this;
		}
		public PizzaBuilder addMushroom(String mushroom) {
			pizza.mushroom = mushroom;
			return this;
		}
		public Pizza build() {
			return pizza;
		}
	}
}
class Oven {
	public static Pizza cook() {
        return Pizza.base().addCheese("some cheese").addMeat("chicken").build();
    }
}
