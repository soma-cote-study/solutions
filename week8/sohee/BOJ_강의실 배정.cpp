#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    cin >> N;
    vector<pair<int,int>> v(N);
    for (int i = 0; i < N; i++) cin >> v[i].first >> v[i].second;

    sort(v.begin(), v.end());

    priority_queue<int, vector<int>, greater<>> pq;
    pq.push(v[0].second);

    for (int i = 1; i < N; i++) {
        if (pq.top() <= v[i].first) {
            pq.pop();
        }
        pq.push(v[i].second);
    }

    cout << pq.size();
}
