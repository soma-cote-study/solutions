#include <bits/stdc++.h>
using namespace std;

int sumDigit(const string& s) {
    int sum = 0;
    for (char c : s) if (isdigit(c)) sum += c - '0';
    return sum;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    vector<string> v(n);
    for (int i = 0; i < n; i++) cin >> v[i];

    sort(v.begin(), v.end(), [](const string& a, const string& b) {
        if (a.size() != b.size()) return a.size() < b.size();
        int sa = sumDigit(a), sb = sumDigit(b);
        if (sa != sb) return sa < sb;
        return a < b;
    });

    for (auto& s : v) cout << s << "\n";
}