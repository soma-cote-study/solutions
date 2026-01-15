#include <bits/stdc++.h>
using namespace std;

const int INF = 1e9;
const int MAX_N = 404;

int dist[MAX_N][MAX_N];

int main() {
    int n, m;
    cin >> n >> m;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            dist[i][j] = INF;
        }
    }

    for (int i = 0; i < m; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        dist[u][v] = min(dist[u][v], w);
    }

    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][k] != INF && dist[k][j] != INF) {
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    int ans = INF;
    for(int i = 1; i <= n; i++) {
        ans = min(ans, dist[i][i]);
    }

    if(ans == INF) cout << -1 << "\n";
    else cout << ans << "\n";

    return 0;
}