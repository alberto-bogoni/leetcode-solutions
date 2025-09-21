import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FoodRatingSystem {

    static class Food {
        String name;
        String cuisine;
        int rating;
        boolean deprecated;

        public Food(String n, String c, int r) {
            this.name = n;
            this.cuisine = c;
            this.rating = r;
            this.deprecated = false;
        }

        // Getters and setters
    }

    Map<String, Food> foodMap = new HashMap<>();
    Map<String, PriorityQueue<Food>> cuisinesRatings = new HashMap<>();

    public FoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;

        for (int i = 0; i < n; i++) {
            Food f = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(f.name, f);
            cuisinesRatings
                    .computeIfAbsent(f.cuisine, k -> new PriorityQueue<Food>((a,b) -> {
                        if (b.rating != a.rating) {
                            return b.rating - a.rating;
                        }
                        return a.name.compareTo(b.name);
                    })).add(f);
        }
    }

    public void changeRating(String food, int newRating) {
        Food toUpdate = foodMap.get(food);
        toUpdate.deprecated = true;

        PriorityQueue<Food> ratings = cuisinesRatings.get(toUpdate.cuisine);
        Food newFood = new Food(toUpdate.name, toUpdate.cuisine, newRating);
        ratings.add(newFood);

        foodMap.put(food, newFood);
    }

    public String highestRated(String cuisine) {
        if (!cuisinesRatings.containsKey(cuisine)) return null;
        PriorityQueue<Food> ratings = cuisinesRatings.get(cuisine);

        while (!ratings.isEmpty() && ratings.peek().deprecated)
            ratings.poll();

        return ratings.peek().name;
    }
}
