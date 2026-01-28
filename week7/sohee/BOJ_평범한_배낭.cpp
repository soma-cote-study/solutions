#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, K;
    cin >> N >> K;

    vector<int> W(N + 1), V(N + 1);
    for (int i = 1; i <= N; i++) {
        cin >> W[i] >> V[i];
    }

    // dp[i][j] : i번째 물건까지 고려했을 때, 무게 j로 얻을 수 있는 최대 가치
    vector<vector<int>> dp(N + 1, vector<int>(K + 1, 0));

    for (int i = 1; i <= N; i++) {
        for (int j = 0; j <= K; j++) {
            // i번째 물건을 선택하지 않는 경우
            dp[i][j] = dp[i - 1][j];

            // i번째 물건을 선택하는 경우
            if (j >= W[i]) {
                dp[i][j] = max(dp[i][j],
                               dp[i - 1][j - W[i]] + V[i]);
            }
        }
    }

    cout << dp[N][K] << '\n';
    return 0;
}
