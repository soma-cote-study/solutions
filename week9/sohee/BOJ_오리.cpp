#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;

    vector<int> cnt(5, 0); // q u a c k
    int cur = 0, maxDuck = 0;

    for (char c : s) {
        int idx;
        if (c == 'q') idx = 0;
        else if (c == 'u') idx = 1;
        else if (c == 'a') idx = 2;
        else if (c == 'c') idx = 3;
        else if (c == 'k') idx = 4;
        else {
            cout << -1;
            return 0;
        }

        if (idx == 0) {
            cnt[0]++;
            maxDuck = max(maxDuck, cnt[0] - cnt[4]);
        } else {
            if (cnt[idx - 1] <= cnt[idx]) {
                cout << -1;
                return 0;
            }
            cnt[idx]++;
        }
    }

    if (cnt[0] == cnt[1] && cnt[1] == cnt[2] && cnt[2] == cnt[3] && cnt[3] == cnt[4])
        cout << maxDuck;
    else
        cout << -1;
}