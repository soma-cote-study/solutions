#include <bits/stdc++.h>
using namespace std;
int h, w, a[504], ans;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
    cin >> h >> w;
    for (int i = 0; i <= w; i++) cin >> a[i];
    
    for (int i = 1; i < w-1; i++) {
        int l = 0, r = 0;
        for (int j = 0; j < i; j++) l = max(l, a[j]);
        for (int j = w-1; j > i; j--) r = max(r, a[j]);
        ans += max(0, min(l, r) - a[i]);
    }
    
    cout << ans << "\n";
}