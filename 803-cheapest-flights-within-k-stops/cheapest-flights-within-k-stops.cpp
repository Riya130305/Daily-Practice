class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights,
                          int src, int dst, int k) {

        vector<vector<pair<int, int>>> adj(n);
        vector<int> dis(n, 1e9);

        for (auto edg : flights) {
            int u = edg[0];
            int v = edg[1];
            int wt = edg[2];

            adj[u].push_back({v, wt});
        }

        queue<pair<int, int>> q;

        dis[src] = 0;

        // {cost, node}
        q.push({0, src});

        int size = 0;

        while (!q.empty() && size <= k) {

            int qSize = q.size();

            while (qSize--) {

                auto [wt, node] = q.front();
                q.pop();

                for (auto nbr : adj[node]) {

                    int newNode = nbr.first;
                    int w = nbr.second;

                    if (dis[newNode] > wt + w) {

                        dis[newNode] = wt + w;

                        q.push({dis[newNode], newNode});
                    }
                }
            }

            size++;
        }

        return dis[dst] == 1e9 ? -1 : dis[dst];
    }
};