#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
vector<ll> v;

void go(int cur, ll num) {
    v.push_back(num);

    for (int next = cur - 1; next >= 0; next--) {
        go(next, num * 10 + next);
    }
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
    int n;
	cin >> n;

    for (int i = 0; i <= 9; i++) {
        go(i, i);
    }

    sort(v.begin(), v.end());

    if (n > v.size()) cout << -1;
    else cout << v[n - 1];
}
