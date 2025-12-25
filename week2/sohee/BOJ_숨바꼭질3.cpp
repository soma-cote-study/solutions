#include <bits/stdc++.h>
using namespace std;

const int MAX = 100000;
const int INF = 1e9;

int n, m;
int dist[MAX + 1];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;

    fill(dist, dist + MAX + 1, INF);
    deque<int> dq;

    dist[n] = 0;
    dq.push_front(n);

    while (!dq.empty()) {
        int x = dq.front();
        dq.pop_front();

        if (x == m) break;

        if (x * 2 <= MAX && dist[x * 2] > dist[x]) {
            dist[x * 2] = dist[x];
            dq.push_front(x * 2);
        }

        if (x - 1 >= 0 && dist[x - 1] > dist[x] + 1) {
            dist[x - 1] = dist[x] + 1;
            dq.push_back(x - 1);
        }

        if (x + 1 <= MAX && dist[x + 1] > dist[x] + 1) {
            dist[x + 1] = dist[x] + 1;
            dq.push_back(x + 1);
        }
    }

    cout << dist[m] << '\n';
}