#include <bits/stdc++.h>
using namespace std;
int n, m, a[10];
bool visited[10];
void go(int depth) {
    if (depth == m) {
        for (int i = 0; i < m; i++) {
            cout << a[i] << " ";
        }
        cout << "\n";
        return;
    }
    for (int i = 1; i <= n; i++) {
        if(visited[i]) continue;
        visited[i] = 1;
        a[depth] = i;
        go(depth + 1);
        visited[i] = 0;
    }
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n >> m;
    go(0);
}
