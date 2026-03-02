// 399. Evaluate Division

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Division {
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size() ; i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
            } else if (start.equals(end)) {
                result[i] = 1.0;
            }
            else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(graph, start, end, 1.0, visited);
            }
        }
        return result;
    }

    public static double dfs(Map<String, Map<String, Double>> graph, String current, String target,double product, Set<String> visited) {
        if (current.equals(target)) {
            return product; 
        }

        visited.add(current);
        for (String neighbor : graph.get(current).keySet()) {
            if (!visited.contains(neighbor)) {
                double currProduct = graph.get(current).get(neighbor);
                double result = dfs(graph, neighbor, target, product * currProduct, visited);

                if (result != -1.0) return result;
            }
        }
        return -1.0;
    }

    public static Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for(int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, value);
            graph.get(b).put(a, 1/value);
        }
        return graph;
    }

    public static void main(String[] args) {
        // Test Case 1
        List<List<String>> equations = List.of(
            List.of("a", "b"),
            List.of("b", "c")
        );
        double[] values = {2.0, 3.0};
        List<List<String>> queries = List.of(
            List.of("a", "c"),
            List.of("b", "a"),
            List.of("a", "e"),
            List.of("a", "a"),
            List.of("x", "x")
        );
        double[] result = calcEquation(equations, values, queries);
        for (double res : result) {
            System.out.println(res);
        }

        // Test Case 2
        List<List<String>> equations2 = List.of(
            List.of("a", "b"),
            List.of("b", "c"),
            List.of("bc", "cd")
        );
        double[] values2 = {1.5, 2.5, 5.0};
        List<List<String>> queries2 = List.of(
            List.of("a", "c"),
            List.of("c", "b"),
            List.of("bc", "cd"),
            List.of("cd", "bc")
        );
        double[] result2 = calcEquation(equations2, values2, queries2);
        for (double res : result2) {
            System.out.println(res);
        }
    }
}