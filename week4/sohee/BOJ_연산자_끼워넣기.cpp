#include <bits/stdc++.h>
using namespace std;
int n, arr[12], op[4];
long long mn = 1e18, mx = -1e18;

void go(int idx, long long val) {
    if (idx == n) {
        mx = max(mx, val);
        mn = min(mn, val);
        return;
    }

    if (op[0] > 0) {
        op[0]--; go(idx+1, val+arr[idx]); op[0]++;
    }

    if (op[1] > 0) {
        op[1]--; go(idx+1, val-arr[idx]); op[1]++;
    }

    if (op[2] > 0) {
        op[2]--; go(idx+1, val*arr[idx]); op[2]++;
    }

    if (op[3] > 0) {
        op[3]--; go(idx+1, val/arr[idx]); op[3]++;
    }
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];
    for (int i = 0; i < 4; i++) cin >> op[i];

    go(1, arr[0]);
    
    cout << mx << "\n";
    cout << mn << "\n";
}
 