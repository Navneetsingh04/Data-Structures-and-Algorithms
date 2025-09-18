/*
L.C: 2353. Design a Food Rating System

Design a food rating system that can do the following:

Modify the rating of a food item listed in the system.
Return the highest-rated food item for a type of cuisine in the system.
Implement the FoodRatings class:

FoodRatings(String[] foods, String[] cuisines, int[] ratings) Initializes the system. The food items are described by foods, cuisines and ratings, all of which have a length of n.
foods[i] is the name of the ith food,
cuisines[i] is the type of cuisine of the ith food, and
ratings[i] is the initial rating of the ith food.
void changeRating(String food, int newRating) Changes the rating of the food item with the name food.
String highestRated(String cuisine) Returns the name of the food item that has the highest rating for the given type of cuisine. If there is a tie, return the item with the lexicographically smaller name.
Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.


Example 1:

Input
["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
[[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]]
Output
[null, "kimchi", "ramen", null, "sushi", null, "ramen"]

Explanation
FoodRatings foodRatings = new FoodRatings(["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]);
foodRatings.highestRated("korean"); // return "kimchi"
// "kimchi" is the highest rated korean food with a rating of 9.
foodRatings.highestRated("japanese"); // return "ramen"
// "ramen" is the highest rated japanese food with a rating of 14.
foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
foodRatings.highestRated("japanese"); // return "sushi"
// "sushi" is the highest rated japanese food with a rating of 16.
foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
foodRatings.highestRated("japanese"); // return "ramen"
// Both "sushi" and "ramen" have a rating of 16.
// However, "ramen" is lexicographically smaller than "sushi".
 
Constraints:

1 <= n <= 2 * 10^4
n == foods.length == cuisines.length == ratings.length
1 <= foods[i].length, cuisines[i].length <= 10
foods[i], cuisines[i] consist of lowercase English letters.
1 <= ratings[i] <= 10^8
All the strings in foods are distinct.
food will be the name of a food item in the system across all calls to changeRating.
cuisine will be a type of cuisine of at least one food item in the system across all calls to highestRated.
At most 2 * 10^4 calls in total will be made to changeRating and highestRated. 
*/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FoodRatingSystem{
    private Map<String,Integer> foodRating = new HashMap<>();
    private Map<String,String> foodCuisine = new HashMap<>();
    private Map<String,PriorityQueue<Pair>> cuisineFoods = new HashMap<>();

    private class Pair{
        String name;
        int rating;
        Pair(String name, int rating){
            this.name = name;
            this.rating = rating;
        }
    }

    public FoodRatingSystem(String[] foods,String[] cuisines,int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            foodRating.put(foods[i], ratings[i]);
            foodCuisine.put(foods[i], cuisines[i]);
            cuisineFoods.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>((a, b) -> b.rating != a.rating ? b.rating - a.rating : a.name.compareTo(b.name))).add(new Pair(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating){
        String cuisine = foodCuisine.get(food);
        foodRating.put(food, newRating);
        cuisineFoods.get(cuisine).add(new Pair(food, newRating));
    }

    public String highestRated(String cuisine){
        PriorityQueue<Pair> pq = cuisineFoods.get(cuisine);
        while (!pq.isEmpty() && foodRating.get(pq.peek().name) != pq.peek().rating){
            pq.poll();
        }
        return pq.peek().name;
    }
    public static void main(String[] args){
        String[] foods = {"kimchi","miso","sushi","moussaka","ramen","bulgogi"};
        String[] cuisines = {"korean","japanese","japanese","greek","japanese","korean"};
        int[] ratings = {9,12,8,15,14,7};

        FoodRatingSystem obj = new FoodRatingSystem(foods, cuisines, ratings);

        System.out.println(obj.highestRated("korean"));   
        System.out.println(obj.highestRated("japanese")); 
        obj.changeRating("sushi", 16);
        System.out.println(obj.highestRated("japanese")); 
        obj.changeRating("ramen", 16);
        System.out.println(obj.highestRated("japanese"));
    }
}
