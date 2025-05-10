import java.util.*;

public class Solution {
    public List<String> findAllRecipesTopoSort(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> availableSupplies = new HashSet<>();
        for (String s : supplies) availableSupplies.add(s);
        Map<String, Integer> in = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        List<String> result = new LinkedList<>();

        for (int i = 0; i < recipes.length; i++) {
            String rec = recipes[i];
            in.put(rec, ingredients.get(i).size());

            for (String ing : ingredients.get(i)) {
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(rec);
            }
        }

        Queue<String> queue = new LinkedList<>(availableSupplies);
        while (!queue.isEmpty()) {
            String item = queue.poll();
            if (!graph.containsKey(item)) continue;

            for (String recipe : graph.get(item)) {
                in.put(recipe, in.get(recipe) - 1);
                if (in.get(recipe) == 0) {
                    result.add(recipe);
                    queue.add(recipe);
                }
            }
        }

        return result;
    }

    Map<String, Integer> recMap = new HashMap<>();
    Map<String, Boolean> memo = new HashMap<>();
    Set<String> suppliesSet;

    public List<String> findAllRecipesDFS(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        suppliesSet = new HashSet<>(Arrays.asList(supplies));
        for (int i = 0; i < recipes.length; i++) {
            recMap.put(recipes[i], i);
        }

        List<String> result = new ArrayList<>();
        for (String recipe : recipes) {
            if (canMake(ingredients, recipe, new HashSet<>())) {
                result.add(recipe);
            }
        }

        return result;
    }

    private boolean canMake(List<List<String>> ingredients, String recipe, Set<String> visiting) {
        if (suppliesSet.contains(recipe)) {
            return true;
        }
        if (memo.containsKey(recipe)) {
            return memo.get(recipe);
        }
        if (!recMap.containsKey(recipe)) {
            return false;
        }
        if (visiting.contains(recipe)) {
            memo.put(recipe, false);
            return false;
        }

        visiting.add(recipe);
        int index = recMap.get(recipe);
        for (String ingredient : ingredients.get(index)) {
            if (!canMake(ingredients, ingredient, visiting)) {
                memo.put(recipe, false);
                visiting.remove(recipe);
                return false;
            }
        }
        visiting.remove(recipe);
        suppliesSet.add(recipe);
        memo.put(recipe, true);
        return true;
    }
}