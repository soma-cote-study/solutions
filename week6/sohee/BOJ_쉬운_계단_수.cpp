#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9;
int n, dp[104][10];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n;
    for (int i = 1; i <= 9; i++) {
        dp[1][i] = 1;
    }

        for (int i = 1; i < n; i++) { // i = 길이
        dp[i+1][0] = dp[i][1];
        dp[i+1][9] = dp[i][8];
        for (int j = 1; j < 9; j++) { // j = 마지막 수
            dp[i+1][j] = (dp[i][j+1] + dp[i][j-1]) % MOD;
        }
    }
    
    long long ans = 0;
    for (int i = 0; i <= 9; i++) {
        ans = (ans + dp[n][i]) % MOD;
    }

    cout << ans << "\n";
}
