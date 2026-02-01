#include <bits/stdc++.h>
using namespace std;

const int INF = 1e9;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    vector<vector<int>> dist(N + 1, vector<int>(N + 1, INF));
    for (int i = 1; i <= N; i++) dist[i][i] = 0;

    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        dist[a][b] = 1;
        dist[b][a] = 1;
    }

    // 플로이드-워셜
    for (int k = 1; k <= N; k++) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }

    int bestA = 1, bestB = 2;
    int bestSum = INF;

    for (int a = 1; a <= N; a++) {
        for (int b = a + 1; b <= N; b++) {
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                int d = min(dist[i][a], dist[i][b]);
                sum += d;
            }

            if (sum < bestSum) {
                bestSum = sum;
                bestA = a;
                bestB = b;
            }
        }
    }

    // 왕복 거리이므로 2를 곱한다
    cout << bestA << ' ' << bestB << ' ' << bestSum * 2 << '\n';
    return 0;
}