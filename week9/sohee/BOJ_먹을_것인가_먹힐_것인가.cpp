#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;
    while (T--) {
        int n, m;
        cin >> n >> m;
        vector<int> A(n), B(m);

        for (int i = 0; i < n; i++) cin >> A[i];
        for (int i = 0; i < m; i++) cin >> B[i];

        sort(B.begin(), B.end());

        long long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += lower_bound(B.begin(), B.end(), A[i]) - B.begin();
        }

        cout << ans << "\n";
    }
}