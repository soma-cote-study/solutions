#include <bits/stdc++.h>
using namespace std;
int n, mn = 1e9, mx = -1;
int oddnum(string s) {
    int num = 0;
    for (int i = 0; i < s.size(); i++) {
        if ((s[i] - '0') % 2 == 1) num++;
    }
    return num;
}
void go(string s, int cnt) {
    int num = oddnum(s);

    if (s.size() == 1) {
        mn = min(mn, cnt + num);
        mx = max(mx, cnt + num);
    } else if (s.size() == 2) {
        string temp = to_string((s[0] - '0') + (s[1] - '0'));
        go(temp, cnt + num);
    } else {
        for (int i = 1; i <= s.size()-2; i++) {
            for (int j = 1; j <= s.size()-1-i; j++) {
                string temp = to_string(stoi(s.substr(0, i)) + stoi(s.substr(i, j)) + stoi(s.substr(i+j)));
                go(temp, cnt + num);
            }
        }
    }

    return;
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n;
    string s = to_string(n);
    go(s, 0);
    cout << mn << " " << mx << "\n";
}
