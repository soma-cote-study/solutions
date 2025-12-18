#include <bits/stdc++.h>
using namespace std;
typedef pair<int, int> pii;
int n, s, e, level, diff[370], f, l, garo, sero, ans;
bool block, flag;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> s >> e;
        diff[s]++;
        diff[e+1]--;
    }
    for (int i = 1; i <= 365; i++) {
        level += diff[i];
        if (level == 0) {
            if (block) {
                garo = l - f + 1;
                ans += (garo * sero);
                garo = 0; sero = 0; block = 0;
            }
            continue;
        } 
        if (!block) f = i;
        sero = max(sero, level);
        l = i; block = 1;  
    }

    if (block) {
        garo = l - f + 1;
        ans += (garo * sero);
    }
    cout << ans << "\n";
}