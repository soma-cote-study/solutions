#include <bits/stdc++.h>
using namespace std;
const int MAX = 10004;
int visited[MAX], dp[MAX];
vector<int> v[MAX];

int go(int x) {
    int cnt = 1;
    visited[x] = 1;
    for (int nx : v[x]) {
        if (visited[nx]) continue;
        cnt += go(nx);
    }
    return cnt;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int n, m;
    cin >> n >> m;

    int a, b;
    while(m--) {
        cin >> a >> b;
        v[b].push_back(a);
    }

    int mx = -1;
    for (int i = 1; i <= n; i++) {
        memset(visited, 0, sizeof(visited));
        dp[i] = go(i);
        mx = max(dp[i], mx);
    }

    for (int i = 1; i <= n; i++) {
        if (mx == dp[i]) cout << i << " ";
    }
}
