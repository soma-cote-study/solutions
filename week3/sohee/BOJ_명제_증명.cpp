#include <bits/stdc++.h>
using namespace std;

const int INF = 1e9;
const int MAX = 52;

int dist[MAX][MAX];

int idx(char a) {
    if(a >= 'A' && a <= 'Z') return a - 'A';
    return a - 'a' + 26;
}

int main() {
    int n;
    cin >> n;

    for (int i = 0; i < MAX; i++) {
        for (int j = 0; j < MAX; j++) {
            dist[i][j] = (i == j ? 0 : INF);
        }
    }

    for (int i = 0; i < n; i++) {
        char a, b; string arrow;
        cin >> a >> arrow >> b;
        int u = idx(a), v = idx(b);
        dist[u][v] = 1;
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

    vector<pair<int,int>> ans;
    for (int i = 0; i < MAX; i++) {
        for (int j = 0; j < MAX; j++) {
            if (i == j) continue;
            if (dist[i][j] != INF)
                ans.emplace_back(i, j);
        }
    }

    cout << ans.size() << "\n";
    for (auto &p : ans) {
        int x = p.first, y = p.second;
        char cu = (x < 26 ? 'A' + x : 'a' + (x - 26));
        char cv = (y < 26 ? 'A' + y : 'a' + (y - 26));
        cout << cu << " => " << cv << "\n";
    }

    return 0;
}