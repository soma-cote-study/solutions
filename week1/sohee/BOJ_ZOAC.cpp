#include <bits/stdc++.h>
using namespace std;
string s;
vector<pair<int, char>> ans;

void go(int l, int r) {
    if (l > r) return;

    char mn = '{';
    int idx = -1;

    for (int i = l; i <= r; i++) {
        if (s[i] < mn) {
            mn = s[i]; idx = i;
        }
    }

    ans.push_back({idx, mn});
    sort(ans.begin(), ans.end());
    
    for (auto &a : ans) cout << a.second;
    cout << "\n";

    go(idx+1, r);
    go(l, idx-1);

}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> s;
    go(0, s.size()-1);
}
