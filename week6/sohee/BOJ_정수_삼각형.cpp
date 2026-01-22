#include <bits/stdc++.h>
using namespace std;
int n, temp, mx, dp[504][504];
vector<int> v[504];
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= i; j++) {
            cin >> temp;
            v[i].push_back(temp);
        }
    }

    dp[0][0] = v[0][0];
    // cout << dp[0][0] << "\n";

    for (int i = 1; i < n; i++) {
        for (int j = 0; j <= i; j++) {
            if (j == 0) {
                dp[i][0] = v[i][0] + dp[i-1][0];
                // cout << i << "단계 " << 0 << "번째 " << dp[i][0] << "\n";
            } else if (j == i) {
                dp[i][j] = v[i][j] + dp[i-1][j-1];
                // cout << i << "단계 " << j << "번째 " << dp[i][j] << "\n";
            } else {
                dp[i][j] = v[i][j] + max(dp[i-1][j], dp[i-1][j-1]);
                // cout << i << "단계 " << j << "번째 " << dp[i][j] << "\n";
            }
        }
    }

    // cout << "result\n";
    for (int i = 0; i < n; i++) {
        mx = max(mx, dp[n-1][i]);
    }

    cout << mx << "\n";
}
