#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; i++) cin >> arr[i];
    int m;
    cin >> m;

    int lo = 0, hi = *max_element(arr.begin(), arr.end());
    int ans = 0;

    while (lo <= hi) {
        int mid = (lo + hi) / 2;
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += min(arr[i], mid);
        }
        if (sum <= m) {
            ans = mid;
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }

    cout << ans << "\n";
    return 0;
}