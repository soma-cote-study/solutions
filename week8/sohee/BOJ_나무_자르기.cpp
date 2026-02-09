#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    long long m;
    cin >> n >> m;

    vector<long long> tree(n);
    long long lo = 0, hi = 0;
    for (int i = 0; i < n; i++) {
        cin >> tree[i];
        hi = max(hi, tree[i]);
    }

    long long ans = 0;
    while (lo <= hi) {
        long long mid = (lo + hi) / 2;
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            if (tree[i] > mid)
                sum += tree[i] - mid;
        }
        if (sum >= m) {
            ans = mid;
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }

    cout << ans << "\n";
    return 0;
}