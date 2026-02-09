#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    vector<long long> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];

    // dp[i] = 1번 돌에서 i번 돌까지 갈 때, 경로상 최대 힘의 최솟값
    vector<long long> dp(n, 1e18);
    dp[0] = 0;

    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            long long cost = (long long)(i - j) * (1 + abs(a[i] - a[j]));
            dp[i] = min(dp[i], max(dp[j], cost));
        }
    }

    cout << dp[n - 1] << "\n";
    return 0;
}