#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    vector<long long> v(n);
    for (int i = 0; i < n; i++) cin >> v[i];

    sort(v.begin(), v.end());

    long long ans = v[0], cur = v[0];
    int bestCnt = 1, cnt = 1;

    for (int i = 1; i < n; i++) {
        if (v[i] == cur) cnt++;
        else {
            if (cnt > bestCnt) {
                bestCnt = cnt;
                ans = cur;
            }
            cur = v[i];
            cnt = 1;
        }
    }

    if (cnt > bestCnt) ans = cur;

    cout << ans;
}