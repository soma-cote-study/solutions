#include <bits/stdc++.h>
using namespace std;
const int MAX = 104;
int n, a[MAX];
bool visited[MAX];
vector<int> ans;

void dfs(int cur, int start) {
    if(visited[cur]) {
        if (start == cur) ans.push_back(cur);
        return;
    }
    visited[cur] = true;
    dfs(a[cur], start);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n;
    for (int i = 1; i <= n; i++) cin >> a[i];

    for (int i = 1; i <= n; i++) {
        memset(visited, 0, sizeof(visited));
        dfs(i, i);
    }

    cout << ans.size() << "\n";
    for (int x : ans) cout << x << "\n";
}