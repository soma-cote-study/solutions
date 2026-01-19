#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const int MAX_N = 104;
const ll INF = 1e18;
ll dist[MAX_N][MAX_N], ans, sum, n, m, r, t[MAX_N], a, b, l;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n >> m >> r;
    for (int i = 1; i <= n; i++) {
        cin >> t[i];
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i == j) dist[i][j] = 0;
            else dist[i][j] = INF;
        }
    }

    for (int i = 1; i <= r; i++) {
        cin >> a >> b >> l;
        dist[a][b] = min(dist[a][b], l);
        dist[b][a] = min(dist[b][a], l);
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

    for (int i = 1; i <= n; i++) {
        sum = 0;
        for (int j = 1; j <= n; j++) {
            if (dist[i][j] > m) continue;
            sum += t[j];
        }
        ans = max(ans, sum);
    }

    cout << ans << "\n";
}
