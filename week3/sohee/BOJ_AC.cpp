#include <bits/stdc++.h>
using namespace std;
int t, n;
string p, x;
deque<int> dq;
bool flag, rev;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> t;
    while (t--) {
        dq.clear(); flag = 0; rev = 0;
        cin >> p; cin >> n; cin >> x;
        int num = 0;
        bool inNum = false;
        for (int i = 0; i < x.length(); i++) {
            if (isdigit(x[i])) {
                num = num * 10 + (x[i] - '0');
                inNum = true;
            } else {
                if (inNum) {
                    dq.push_back(num);
                    num = 0;
                    inNum = false;
                }
            }
        }
        for (int i = 0; i < p.length(); i++) {
            if (p[i] == 'R') rev = !rev;
            else {
                if(dq.empty()) {
                    cout << "error\n"; flag = 1; break;
                }
                if (!rev) dq.pop_front();
                else dq.pop_back();
            }
        }
        if (flag) continue;
        cout << "[";
        if (!dq.empty()) {
            if (!rev) {
                for (int i = 0; i < dq.size(); i++) {
                    if (i) cout << ",";
                    cout << dq[i];
                }
            } else {
                for (int i = dq.size() - 1; i >= 0; i--) {
                    if (i != dq.size() - 1) cout << ",";
                    cout << dq[i];
                }
            }
        }
        cout << "]\n";
    }
}
