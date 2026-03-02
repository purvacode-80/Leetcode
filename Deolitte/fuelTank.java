import java.util.*;

public class fuelTank {

    static class State {
        int city;
        int fuel;
        long cost;

        State(int city, int fuel, long cost) {
            this.city = city;
            this.fuel = fuel;
            this.cost = cost;
        }
    }

    static long minimumFuelCost(int N, int M, int S, int C,
                                int[][] roads,
                                int[][] stations,
                                int A, int B) {

        // Build graph
        List<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int fuel = roads[i][2];

            graph[u].add(new int[]{v, fuel});
            graph[v].add(new int[]{u, fuel});
        }

        // Fuel price array
        int[] price = new int[N + 1];
        Arrays.fill(price, Integer.MAX_VALUE);

        for (int i = 0; i < S; i++) {
            int city = stations[i][0];
            int p = stations[i][1];
            price[city] = p;
        }

        long[][] dist = new long[N + 1][C + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        PriorityQueue<State> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a.cost, b.cost)
        );

        dist[A][0] = 0;
        pq.add(new State(A, 0, 0));

        while (!pq.isEmpty()) {
            State curr = pq.poll();

            if (curr.city == B)
                return curr.cost;

            if (curr.cost > dist[curr.city][curr.fuel])
                continue;

            // Buy 1 litre fuel
            if (price[curr.city] != Integer.MAX_VALUE && curr.fuel < C) {
                long newCost = curr.cost + price[curr.city];
                if (newCost < dist[curr.city][curr.fuel + 1]) {
                    dist[curr.city][curr.fuel + 1] = newCost;
                    pq.add(new State(curr.city, curr.fuel + 1, newCost));
                }
            }

            // Travel to neighbours
            for (int[] edge : graph[curr.city]) {
                int nextCity = edge[0];
                int fuelNeeded = edge[1];

                if (curr.fuel >= fuelNeeded) {
                    int remainingFuel = curr.fuel - fuelNeeded;

                    if (curr.cost < dist[nextCity][remainingFuel]) {
                        dist[nextCity][remainingFuel] = curr.cost;
                        pq.add(new State(nextCity, remainingFuel, curr.cost));
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int S = sc.nextInt();

        int C = sc.nextInt();

        int[][] roads = new int[M][3];
        for (int i = 0; i < M; i++) {
            roads[i][0] = sc.nextInt();
            roads[i][1] = sc.nextInt();
            roads[i][2] = sc.nextInt();
        }

        int[][] stations = new int[S][2];
        for (int i = 0; i < S; i++) {
            stations[i][0] = sc.nextInt();
            stations[i][1] = sc.nextInt();
        }

        int A = sc.nextInt();
        int B = sc.nextInt();

        long result = minimumFuelCost(N, M, S, C, roads, stations, A, B);

        System.out.println(result);

        sc.close();
    }
}