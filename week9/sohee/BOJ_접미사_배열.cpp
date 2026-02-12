#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;
    int n = s.size();
    vector<string> suf;

    for (int i = 0; i < n; i++) {
        suf.push_back(s.substr(i));
    }

    sort(suf.begin(), suf.end());

    for (auto& x : suf) cout << x << "\n";
}