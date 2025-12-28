#include <bits/stdc++.h>
using namespace std;
const int MAX = 2004;
int n, m, a, b, visited[MAX];
vector<int> v[MAX];
bool flag;
void go(int x, int depth) {
    visited[x] = 1;
    int d = depth + 1;
    if (d == 5) {
        flag = 1; return;
    }
    for (int nx : v[x]) {
        if(visited[nx]) continue;
        go(nx, d);
    }
    visited[x] = 0;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }

    for (int i = 0; i < n; i++) {
        go(i, 0);
    }

    if (flag) cout << 1 << "\n";
    else cout << 0 << "\n";
}