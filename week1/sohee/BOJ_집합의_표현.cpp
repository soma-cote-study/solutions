#include <bits/stdc++.h>
using namespace std;

const int MAX = 1000004;
int p[MAX];
int uf_rank[MAX];

int find(int x) {
    if(p[x] == -1) {
        return x;
    }

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
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m, a, b, c;
    
    cin >> n >> m;

    memset(p, -1, sizeof(p));

    while(m--) {
        cin >> c >> a >> b;
        if (c == 0) {
            if (a == b) continue;
            merge(a, b);
        }
        else {
            if (a == b) {
                cout << "YES\n"; continue;
            }
            if (find(a) == find(b)) cout << "YES\n";
            else cout << "NO\n";
        }
    }
}
