#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const ll INF = 1e18;
const ll MAX_N = 104;

ll dist[MAX_N][MAX_N], n, m, u, v, w;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i == j) dist[i][j] = 0;
            else dist[i][j] = INF;
        }
    }

    for (int i = 0; i < m; i++) {
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

    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            if(dist[i][j] == INF) cout << 0;
            else cout << dist[i][j];
            if(j < n) cout << ' ';
        }
        cout << '\n';
    }

    return 0;
}