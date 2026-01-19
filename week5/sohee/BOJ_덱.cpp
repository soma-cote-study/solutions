#include <bits/stdc++.h>
using namespace std;
int n, k;
string s;
deque<int> dq;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n;
    while (n--) {
        cin >> s;
        if (s == "push_back") {
            cin >> k;
            dq.push_back(k);
        } else if (s == "push_front") {
            cin >> k;
            dq.push_front(k);
        } else if (s == "pop_front") {
            if (dq.empty()) cout << -1 << "\n";
            else {
                k = dq.front(); dq.pop_front(); cout << k << "\n";
            }
        } else if (s == "pop_back") {
            if (dq.empty()) cout << -1 << "\n";
            else {
                k = dq.back(); dq.pop_back(); cout << k << "\n";
            }
        } else if (s == "size") {
            cout << dq.size() << "\n";
        } else if (s == "empty") {
            if (dq.empty()) cout << 1 << "\n";
            else cout << 0 << "\n";
        } else if (s == "front") {
            if (dq.empty()) cout << -1 << "\n";
            else {
                k = dq.front(); cout << k << "\n";
            }
        } else if (s == "back") {
            if (dq.empty()) cout << -1 << "\n";
            else {
                k = dq.back(); cout << k << "\n";
            }
        }
    }
}