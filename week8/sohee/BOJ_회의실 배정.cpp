#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    cin >> N;
    vector<pair<int,int>> v(N);
    for (int i = 0; i < N; i++) cin >> v[i].first >> v[i].second;

    sort(v.begin(), v.end(), [](auto &a, auto &b) {
        if (a.second == b.second) return a.first < b.first;
        return a.second < b.second;
    });

    int cnt = 1;
    int endTime = v[0].second;

    for (int i = 1; i < N; i++) {
        if (v[i].first >= endTime) {
            cnt++;
            endTime = v[i].second;
        }
    }

    cout << cnt;
}
