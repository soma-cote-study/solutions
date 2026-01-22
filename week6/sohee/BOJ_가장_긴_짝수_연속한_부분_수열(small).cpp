#include <bits/stdc++.h>
using namespace std;

int v[1000001];
int d[50001][101];
int s, k;

int dp(int x, int count, int length) {
	if (x <= 0 || count > k) return length;
	if (d[x][count] != 0) return d[x][count];

	int value = 0;
	if (v[x] % 2 == 0) value = dp(x - 1, count, length + 1);
	else if (count < k) value = dp(x - 1, count + 1, length);
	else if (count == k) return length;
	return d[x][count] = value;
}

int main() {
	ios::sync_with_stdio(false);
    cin.tie(nullptr);
	cin >> s >> k;

	for (int i = 1; i <= s; i++) {
		cin >> v[i];
	}

	int ans = 0;

	for (int i = s; i >= 1; i--) {
        for (int j = 0; j <= k; j++) {
			if (v[i] % 2 == 0) ans = max(ans, dp(i, j, 0));
		}
    }

	cout << ans;
}
