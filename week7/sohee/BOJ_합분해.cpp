#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, K;
    cin >> N >> K;

    const int MOD = 1000000000;

    // dp[i][j] : 정수 i를 j개의 수로 표현하는 경우의 수
    vector<vector<int>> dp(N + 1, vector<int>(K + 1, 0));

    // 0을 만드는 방법은 어떤 개수의 수를 써도 항상 1가지
    for (int j = 1; j <= K; j++) {
        dp[0][j] = 1;
    }

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= K; j++) {
            dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
        }
    }

    cout << dp[N][K] << '\n';
    return 0;
}
