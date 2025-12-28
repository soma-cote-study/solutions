#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MAX = 100004;
const int dx[2] = {1, -1};
ll n, k, cur, x, ans;
map<ll, ll> visited, dist;
queue<ll> q;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> k;
    
    for (int i = 0; i < n; i++) {
        cin >> cur;
        q.push(cur); visited[cur] = 1; dist[cur] = 0;
    }

    while(q.size()) {
        if (k <= 0) break;
        x = q.front(); q.pop();
        for (int i = 0; i < 2; i++) {
            if (k <= 0) break;
            ll nx = x + dx[i];
            if (visited[nx]) continue;
            visited[nx] = 1;
            k--; dist[nx] = dist[x] + 1; ans += dist[nx];
            q.push(nx);
        }
    }
    
    cout << ans << "\n";
}