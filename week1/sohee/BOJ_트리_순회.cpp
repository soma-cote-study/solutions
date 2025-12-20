#include <bits/stdc++.h>
using namespace std;
int n, a, b, c, last, cnt;
bool flag;
vector<pair<int, int>> tree;

void go(int cur) {
    if (tree[cur].first != -1) {
        cnt++;
        go(tree[cur].first);
        if(!flag) cnt++;
    }

    if (cur == last) {
        flag = true; return;
    }

    if (tree[cur].second != -1) {
        cnt++;
        go(tree[cur].second);
        if(!flag) cnt++;
    }
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;

    tree.resize(100004);
    while (n--) {
        cin >> a >> b >> c;
        tree[a] = {b, c};
    }
    
    int temp = 1;
    while (temp != -1) {
        last = temp;
        temp = tree[temp].second;
    }

    go(1);

    cout << cnt << "\n";
}
