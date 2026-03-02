// Build adjacency list
List<int[]>[] graph = new ArrayList[N + 1];
for (int i = 1; i <= N; i++) {
    graph[i] = new ArrayList<>();
}

for (int i = 0; i < M; i++) {
    int u = road[i][0];
    int v = road[i][1];
    int fuelNeeded = road[i][2];

    graph[u].add(new int[]{v, fuelNeeded});
    graph[v].add(new int[]{u, fuelNeeded});
}

// Store fuel prices
int[] price = new int[N + 1];
Arrays.fill(price, Integer.MAX_VALUE);

for (int i = 0; i < S; i++) {
    price[fuel[i][0]] = fuel[i][1];
}

// Distance array
long[][] dist = new long[N + 1][C + 1];
for (int i = 0; i <= N; i++) {
    Arrays.fill(dist[i], Long.MAX_VALUE);
}

PriorityQueue<long[]> pq = new PriorityQueue<>(
        (a, b) -> Long.compare(a[2], b[2])
);

// {city, fuel, cost}
dist[A][0] = 0;
pq.add(new long[]{A, 0, 0});

while (!pq.isEmpty()) {

    long[] curr = pq.poll();
    int city = (int) curr[0];
    int currFuel = (int) curr[1];
    long cost = curr[2];

    if (city == B) {
        res = cost;
        return res;
    }

    if (cost > dist[city][currFuel])
        continue;

    // Option 1: Buy 1 litre fuel
    if (price[city] != Integer.MAX_VALUE && currFuel < C) {
        long newCost = cost + price[city];

        if (newCost < dist[city][currFuel + 1]) {
            dist[city][currFuel + 1] = newCost;
            pq.add(new long[]{city, currFuel + 1, newCost});
        }
    }

    // Option 2: Travel
    for (int[] edge : graph[city]) {
        int nextCity = edge[0];
        int fuelRequired = edge[1];

        if (currFuel >= fuelRequired) {
            int remainingFuel = currFuel - fuelRequired;

            if (cost < dist[nextCity][remainingFuel]) {
                dist[nextCity][remainingFuel] = cost;
                pq.add(new long[]{nextCity, remainingFuel, cost});
            }
        }
    }
}