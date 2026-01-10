#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e15;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<vector<long long>> dist(n+1, vector<long long>(n+1, INF));

    // 같은 정점은 비용 0
    for(int i = 1; i <= n; i++) {
        dist[i][i] = 0;
    }

    // 버스 정보 입력 (같은 경로 여러 개 있을 수 있음 -> 최소값 저장)
    for(int i = 0; i < m; i++) {
        int a, b;
        long long c;
        cin >> a >> b >> c;
        dist[a][b] = min(dist[a][b], c);
    }

    // 플로이드-워셜
    for(int k = 1; k <= n; k++) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }

    // 출력: 갈 수 없으면 0
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
