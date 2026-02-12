#include <bits/stdc++.h>
using namespace std;

long long rev(long long x) {
    long long r = 0;
    while (x > 0) {
        r = r * 10 + (x % 10);
        x /= 10;
    }
    return r;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    vector<long long> v(n);

    for (int i = 0; i < n; i++) {
        long long x;
        cin >> x;
        v[i] = rev(x);
    }

    sort(v.begin(), v.end());

    for (auto x : v) cout << x << "\n";
}