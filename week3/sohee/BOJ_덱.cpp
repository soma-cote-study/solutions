#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, i;
    cin >> n;
    string s;
    deque<int> dq;
    while(n--){
        cin >> s;
        if (s == "push_back") {
            cin >> i;
            dq.push_back(i);
        } else if (s == "push_front") {
            cin >> i;
            dq.push_front(i);
        } else if (s == "front") {
            if (dq.size()) cout << dq.front() << "\n";
            else cout << -1 << "\n";
        } else if (s == "back") {
            if (dq.size()) cout << dq.back() << "\n";
            else cout << -1 << "\n";
        } else if (s == "size") {
            cout << dq.size() << "\n";
        } else if (s == "empty") {
            cout << (dq.size() == 0 ? 1 : 0) << "\n";
        } else if (s == "pop_front") {
            if (dq.size()) {
                cout << dq.front() << "\n";
                dq.pop_front();
            } else {
                cout << -1 << "\n";
            }
        } else if (s == "pop_back") {
            if (dq.size()) {
                cout << dq.back() << "\n";
                dq.pop_back();
            } else {
                cout << -1 << "\n";
            }
        } 
    }
}