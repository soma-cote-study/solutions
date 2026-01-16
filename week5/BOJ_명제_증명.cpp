#include <bits/stdc++.h>
using namespace std;

const int INF = 1e9;
const int MAX = 52;

int dist[MAX][MAX];
vector<pair<int, int>> ans;

int idx(char a) {
    if(a >= 'A' && a <= 'Z') return a - 'A';
    return a - 'a' + 26;
}

int main() {
    int n;
    cin >> n;

    for (int i = 0; i < MAX; i++) {
        for (int j = 0; j < MAX; j++) {
            if (i == j) dist[i][j] = 0;
            else dist[i][j] = INF;
        }
    }

    for (int i = 0; i < n; i++) {
        char u, v; string a;
        cin >> u >> a >> v;
        int iu = idx(u); int iv = idx(v);
        dist[iu][iv] = 1;
    }

    for (int k = 0; k < MAX; k++) {
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (dist[i][k] != INF && dist[k][j] != INF) {
                    dist[i][j] = 1;
                }
            }
        }
    }

    for (int i = 0; i < MAX; i++) {
        for (int j = 0; j < MAX; j++) {
            if (i == j) continue;
            if (dist[i][j] != INF)
                ans.push_back({i, j});
        }
    }

    cout << ans.size() << "\n";
    for (auto &[u, v] : ans) {
        char cu = (u < 26 ? 'A' + u : 'a' + (u - 26));
        char cv = (v < 26 ? 'A' + v : 'a' + (v - 26));
        cout << cu << " => " << cv << "\n";
    }

    return 0;
}