#include <bits/stdc++.h>
using namespace std;

int main() {
    string s;
    cin >> s;

    string mx = "", mn = "";
    int cnt = 0;

    for (int i = 0; i <= s.size(); i++) {
        if (i < s.size() && s[i] == 'M') {
            cnt++;
        } else {
            if (cnt > 0) {
                mx += '5';
                mx.append(cnt, '0');

                mn += '1';
                mn.append(cnt - 1, '0');
                cnt = 0;
            }
            if (i < s.size() && s[i] == 'K') {
                mx += '5';
                mn += '5';
            }
        }
    }

    cout << mx << "\n" << mn;
}
