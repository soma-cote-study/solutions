#include <bits/stdc++.h>
using namespace std;
int n, m, r, a[304][304], num;
vector<int> temp, level[154];
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n >> m >> r;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            cin >> a[i][j];
        }
    }
    num = min(n, m) / 2;
    for (int k = 1; k <= num; k++) {
        temp.clear();
        for (int y = k; y < n-k+1; y++) temp.push_back(a[y][k]);
        for (int x = k; x < m-k+1; x++) temp.push_back(a[n-k+1][x]);
        for (int y = n-k+1; y > k; y--) temp.push_back(a[y][m-k+1]);
        for (int x = m-k+1; x > k; x--) temp.push_back(a[k][x]);
        
        int len = temp.size();
        int idx = (len - (r % len)) % len;

        for (int y = k; y < n-k+1; y++) a[y][k] = temp[idx++ % len];
        for (int x = k; x < m-k+1; x++) a[n-k+1][x] = temp[idx++ % len];
        for (int y = n-k+1; y > k; y--) a[y][m-k+1] = temp[idx++ % len];
        for (int x = m-k+1; x > k; x--) a[k][x] = temp[idx++ % len];
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            cout << a[i][j] << ' ';
        }
        cout << '\n';
    }
}
