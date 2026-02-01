#include <bits/stdc++.h>
using namespace std;

string S, T;
bool possible = false;

void dfs(const string& cur) {
    if (cur.size() < S.size()) return;
    if (cur == S) {
        possible = true;
        return;
    }
    if (possible) return;

    // 1. 마지막 문자가 'A'인 경우: A 제거
    if (!cur.empty() && cur.back() == 'A') {
        string next = cur.substr(0, cur.size() - 1);
        dfs(next);
    }

    // 2. 첫 문자가 'B'인 경우: B 제거 후 뒤집기
    if (!cur.empty() && cur.front() == 'B') {
        string next = cur.substr(1);
        reverse(next.begin(), next.end());
        dfs(next);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> S >> T;

    dfs(T);

    cout << (possible ? 1 : 0) << '\n';
    return 0;
}