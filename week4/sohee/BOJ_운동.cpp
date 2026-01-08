#include <bits/stdc++.h>
using namespace std;

const int INF = 1e8;
int distArr[401][401];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int V, E;
    cin >> V >> E;

    for(int i = 1; i <= V; i++) {
        for(int j = 1; j <= V; j++) {
            distArr[i][j] = INF;
        }
    }

    for(int i = 0; i < E; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        distArr[a][b] = c;
    }

    for(int k = 1; k <= V; k++) {
        for(int i = 1; i <= V; i++) {
            for(int j = 1; j <= V; j++) {
                if(distArr[i][k] + distArr[k][j] < distArr[i][j]) {
                    distArr[i][j] = distArr[i][k] + distArr[k][j];
                }
            }
        }
    }

    int ans = INF;
    for(int i = 1; i <= V; i++) {
        ans = min(ans, distArr[i][i]);
    }

    if(ans == INF) cout << -1;
    else cout << ans;

    return 0;
}
