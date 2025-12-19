#include <bits/stdc++.h>
using namespace std;
int n, m, a[10];
void go(int depth) {
    if (depth == m) {
        for (int i = 0; i < m; i++) {
            cout << a[i] << " ";
        }
        cout << "\n";
        return;
    }
    for (int i = 1; i <= n; i++) {
        a[depth] = i;
        go(depth+1);
    }
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n >> m;
    go(0);
}
