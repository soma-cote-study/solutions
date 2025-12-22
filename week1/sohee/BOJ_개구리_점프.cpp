#include <bits/stdc++.h>
using namespace std;

const int MAX = 100004;
int p[MAX];
int uf_rank[MAX];

struct Log {
    int l, r, idx;
};

Log logs[MAX];

bool compare (const Log &a, const Log &b) {
    return a.l < b.l;
}

int find(int x) {
    if (p[x] == -1) return x;
    return p[x] = find(p[x]);
}

void merge(int a, int b) {
    int rootA = find(a);
    int rootB = find(b);
    if (rootA == rootB) return;

    if (uf_rank[rootA] < uf_rank[rootB]) p[rootA] = rootB;
    else {
        p[rootB] = rootA;
        if (uf_rank[rootA] == uf_rank[rootB]) uf_rank[rootA]++;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n, q;
    cin >> n >> q;

    memset(p, -1, sizeof(p));

    int t;
    for (int i = 0; i < n; i++) {
        cin >> logs[i].l >> logs[i].r >> t;
        logs[i].idx = i + 1;
    }

    sort(logs, logs + n, compare);

    int curR = logs[0].r;
    int curIdx = logs[0].idx;

    for (int i = 1; i < n; i++) {
        if (logs[i].l <= curR) {
            merge(curIdx, logs[i].idx);
            curR = max(curR, logs[i].r);
        } else {
            curIdx = logs[i].idx;
            curR = logs[i].r;
        }
    }

    while (q--) {
        int x, y;
        cin >> x >> y;
        cout << (find(x) == find(y)) << '\n';
    }
}
