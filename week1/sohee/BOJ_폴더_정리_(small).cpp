#include <bits/stdc++.h>
using namespace std;

unordered_map<string, vector<pair<int, string>>> graph;
unordered_map<string, int> visited;
int file, type;

void go(string node) {
    for (auto it : graph[node]) {
        if (it.first == 0) {
            if(!visited[it.second]) {
                visited[it.second] = 1;
                type++;
            }
            file++;
        } else {
            go(it.second);
        }
    }
}

vector<string> parsing(string s) {
    vector<string> v;
    istringstream ss(s);
    string buffer;
    
    while(getline(ss, buffer, '/')) {
        v.push_back(buffer);
    }

    return v;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

    int n, m, z;
    string x, y;
    vector<pair<int, string>> v;

	cin >> n >> m;
    for (int i = 0; i < n+m; i++) {
        cin >> x >> y >> z;
        graph[x].push_back({z, y});
    }
    int q; string s;
    cin >> q;
    while(q--) {
        cin >> s;
        vector<string> v = parsing(s);
        go(v.back());
        cout << type << " " << file << "\n";
        file = 0; type = 0;
        visited.clear();
    }
}
