package Dish;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import Dish.Dish.Type;

public class DishCaseStudy {


	private static List<Dish> getAllDishes() {
		List<Dish> disheds = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT), 
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER), 
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER), 
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), 
				new Dish("salmon", false, 450, Dish.Type.FISH));
		return disheds;
	}

	public static void main(String[] args) {
		
		List<Dish> allDishList = getAllDishes();
		
		
		// return the names of dishes that are low in calories (<400) sorted by number of calories
		List<Dish> dishWithLowCalories =  allDishList.stream().filter(d->d.getCalories()<400).collect(Collectors.toList());
//		dishWithLowCalories.stream().forEach(System.out::println);
		
		
		
		// Getting all veg dishes
		List<Dish> allVegDishes = allDishList.stream().filter(d->d.isVegetarian()).collect(Collectors.toList());
//		allVegDishes.stream().forEach(System.out::println);
		
	
		
		// Get list of All Dishes only containing name and calValue
		List<DishSelectedField> allDishesWithNameAndCalories = allDishList.stream().map(d->d.getDishSelectedData()).collect(Collectors.toList());
//		allDishesWithNameAndCalories.stream().forEach(System.out::println);
		
		
		// create a List by selecting the first three dishes that have more than 300 calories
		List<Dish> moreThan300Calories = allDishList.stream().filter(d->d.getCalories()>300).limit(3).collect(Collectors.toList());
//		moreThan300Calories.stream().forEach(System.out::println);
		
		
		
		// find out whether the menu has a vegetarian option: anyMatch
		boolean anyVegetarian = allDishList.stream().anyMatch(d->d.isVegetarian());
//		System.out.println(anyVegetarian);
		
		
		
		// find out whether the menu is healthy :allMatch(ie. all dishes are below 1000 calories):
		boolean isMenuHealthy = allDishList.stream().allMatch(d->d.getCalories()<1000);
//		System.out.println(isMenuHealthy);
		
		
		
		// find out whether the menu is healthy :noneMatch: opposite of allMatch
		boolean isMenuHealty2 = allDishList.stream().noneMatch(d->d.getCalories()>=1000);
//		System.out.println(isMenuHealty2);
		
		
		
		// find if any food item is veg? findAny
		boolean anyItemVeg = allDishList.stream().anyMatch(d->d.isVegetarian());
//		System.out.println(anyItemVeg);
		

		
		// get all the cal values of all food items 
		List<Integer> allCallValues = allDishList.stream().map(d->d.getCalories()).collect(Collectors.toList());
//		allCallValues.stream().forEach(System.out::println);
		
		
		
		// using primitive stream
		IntStream allCalValuesPrimitive = allDishList.stream().mapToInt(d->d.getCalories());
//		allCalValuesPrimitive.forEach(System.out::println);
		
		
		
		// find max cal values for all dishes
		OptionalInt maxCalDish = allDishList.stream().mapToInt(d->d.getCalories()).max();
//		System.out.println(maxCalDish.orElse(-1));
		
		
		
		//Grouping 
		
		//1. Dishes grouped by type 
		Map<Type, List<Dish>> groupByType = allDishList.stream().collect(Collectors.groupingBy(Dish::getType));
//		for(Entry<Type,List<Dish>> e : groupByType.entrySet()) {
//			System.out.println(e.getKey() + " : " + e.getValue() );
//		}
		
		
		
		//2. Dishes grouped by caloric level 
		Map<CaloricLevel, List<Dish>> groupByCaloricLevel = allDishList.stream().collect(Collectors.groupingBy(d->{
			if (d.getCalories() <= 400)
				return CaloricLevel.DIET;
			else if (d.getCalories() <= 700)
				return CaloricLevel.NORMAL;
			else
				return CaloricLevel.FAT;
		}));
//		or
		Map<CaloricLevel, List<Dish>> groupByCaloricLevel2 = allDishList.stream().collect(Collectors.groupingBy(Dish::getCaloricLevel));
		
//		for(Entry<CaloricLevel, List<Dish>>  e : groupByCaloricLevel2.entrySet()) {
//			System.out.println(e.getKey() + " : " + e.getValue() );
//		}
		
		
		
		//3. Dishes grouped by type and then caloric level 
		Map<Type,Map<CaloricLevel, List<Dish>>> groupByTypeAndCaloriclevel = allDishList.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.groupingBy(Dish::getCaloricLevel)));
//		for(Entry<Type,Map<CaloricLevel, List<Dish>>> e : groupByTypeAndCaloriclevel.entrySet()) {
//			System.out.println(e.getKey());
//			for(Entry<CaloricLevel, List<Dish>> d : e.getValue().entrySet()) {
//				System.out.println(d.getKey() + " : " + d.getValue());
//			}
//			System.out.println();
//		}
		

		//4. Count dishes in each groups 
		Map<Type,Long> CountByType = allDishList.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.counting()));
//		for(Entry<Type,Long> e : CountByType.entrySet()) {
//			System.out.println(e.getKey() + " : " + e.getValue());
//		}
		
		
		
		//5. Most caloric dishes by type 
		Map<Type,Optional<Dish>> MostCaloricDishByType = allDishList.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparing(Dish::getCalories))));
//		for(Entry<Type,Optional<Dish>> e : MostCaloricDishByType.entrySet()) {
//			System.out.println(e.getKey() + " : " + e.getValue().orElse(new Dish()));
//		}
		
		
		
		// 6. Sum calories by type
		Map<Type,Integer> sumCaloriesByType = allDishList.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.summingInt(Dish::getCalories)));
		for(Entry<Type,Integer> e : sumCaloriesByType.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
		
		
	}

}
