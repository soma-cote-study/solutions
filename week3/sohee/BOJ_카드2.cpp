#include <bits/stdc++.h>
using namespace std;
int n;
queue<int> q;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;
    for (int i = 1; i <= n; i++) {
        q.push(i);
    }
    while(true) {
        if (q.size() == 1) break;
        q.pop();
        int tmp = q.front();
        q.pop();
        q.push(tmp);
    }
    cout << q.front() << "\n";
}
