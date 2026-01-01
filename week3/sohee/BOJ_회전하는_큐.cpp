#include <bits/stdc++.h>
using namespace std;
int n, m, x, ans;
deque<int> dq;

void left() {
    int i = dq.front();
    dq.pop_front(); dq.push_back(i);
    ans++;
}

void right() {
    int i = dq.back();
    dq.pop_back(); dq.push_front(i);
    ans++;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n >> m;
    for (int i = 1; i <= n; i++) dq.push_back(i);
    while(m--){
        cin >> x;

        int idx = find(dq.begin(), dq.end(), x) - dq.begin();

        if (idx <= dq.size() - idx) {
            while(idx--) left();
        } else {
            int r = dq.size() - idx;
            while(r--) right();
        }

        dq.pop_front();
    }

    cout << ans << "\n";
}