#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
#define MAX 100
int n;
int a[MAX][MAX];
ll dp[MAX][MAX];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> a[i][j];
        }
    }
    dp[0][0] = 1;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (dp[i][j] == 0 || (i == n - 1 && j == n - 1)) continue;

            int val = a[i][j];
            if (val == 0) continue;
            int down = val + i;
            int right = val + j;

            if (down < n) dp[down][j] = dp[down][j] + dp[i][j];
            if (right < n) dp[i][right] = dp[i][right] + dp[i][j];
        }
    }
    cout << dp[n - 1][n - 1] << "\n";

    return 0;
}
