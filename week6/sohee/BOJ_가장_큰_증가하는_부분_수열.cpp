#include <bits/stdc++.h>
using namespace std;
const int MAX = 1004;
int n, a[MAX], dp[MAX], ans;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> a[i];
    }

    for (int i = 1; i <= n; i++) {
        dp[i] = a[i];
        for (int j = i-1; j >= 1; j--) {
            if (a[i] > a[j]) {
                dp[i] = max(dp[i], dp[j]+a[i]);
            }
        }
        ans = max(ans, dp[i]);
    }

    cout << ans << "\n";
}
