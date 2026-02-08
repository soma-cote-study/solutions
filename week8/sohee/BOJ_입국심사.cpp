#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    long long m;
    cin >> n >> m;

    vector<long long> t(n);
    for (int i = 0; i < n; i++) cin >> t[i];

    long long lo = 1;
    long long hi = *min_element(t.begin(), t.end()) * m;
    long long ans = hi;

    while (lo <= hi) {
        long long mid = (lo + hi) / 2;
        long long cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += mid / t[i];
            if (cnt >= m) break; // 오버플로우 방지
        }
        if (cnt >= m) {
            ans = mid;
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }

    cout << ans << "\n";
    return 0;
}