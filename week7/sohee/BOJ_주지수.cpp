#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    // 누적합 배열 (1-indexed)
    vector<vector<int>> ps(N + 1, vector<int>(M + 1, 0));

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            int x;
            cin >> x;
            ps[i][j] = x + ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1];
        }
    }

    int K;
    cin >> K;
    while (K--) {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;

        int ans = ps[x2][y2]
                - ps[x1 - 1][y2]
                - ps[x2][y1 - 1]
                + ps[x1 - 1][y1 - 1];

        cout << ans << '\n';
    }

    return 0;
}
