#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<int> a(N);
    for (int i = 0; i < N; i++) {
        cin >> a[i];
    }

    // dp[i][v] : i번째 수까지 사용했을 때 값 v를 만드는 경우의 수
    // i는 0 ~ N-2, v는 0 ~ 20
    long long dp[101][21] = {0};

    dp[0][a[0]] = 1;

    for (int i = 1; i <= N - 2; i++) {
        for (int v = 0; v <= 20; v++) {
            if (dp[i - 1][v] == 0) continue;

            if (v + a[i] <= 20) {
                dp[i][v + a[i]] += dp[i - 1][v];
            }
            if (v - a[i] >= 0) {
                dp[i][v - a[i]] += dp[i - 1][v];
            }
        }
    }

    cout << dp[N - 2][a[N - 1]] << '\n';
    return 0;
}
