#include <bits/stdc++.h>
using namespace std;

const int dy[4] = {-1, 0, 1, 0}, dx[4] = {0, 1, 0, -1};
int n, a[30][30], visited[30][30];
string s;
vector<int> v;

int go(int y, int x) {
    visited[y][x] = 1;
    int cnt = 1;
    for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
        if (a[ny][nx] == 0 || visited[ny][nx]) continue;
        cnt += go(ny, nx);
    }
    return cnt;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> s;
        for (int j = 0; j < n; j++) {
            a[i][j] = s[j] - '0';
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (a[i][j] == 0 || visited[i][j]) continue;
            v.push_back(go(i, j));
        }
    }

    sort(v.begin(), v.end());

    cout << v.size() << "\n";
    for (int cur : v) {
        cout << cur << "\n";
    }
}