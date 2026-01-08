#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const ll INF = LLONG_MAX/4;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;
    int A, B, C;
    cin >> A >> B >> C;
    int M;
    cin >> M;

    vector<vector<pair<int,int>>> graph(N+1);
    for(int i = 0; i < M; i++){
        int u, v, w;
        cin >> u >> v >> w;
        graph[u].push_back({v, w});
        graph[v].push_back({u, w});
    }

    auto dijkstra = [&](int start){
        vector<ll> dist(N+1, INF);
        priority_queue<pair<ll,int>, vector<pair<ll,int>>, greater<pair<ll,int>>> pq;
        dist[start] = 0;
        pq.push({0, start});
        while(!pq.empty()){
            auto [cd, u] = pq.top();
            pq.pop();
            if(cd > dist[u]) continue;
            for(auto &edge: graph[u]){
                int v = edge.first;
                ll nd = cd + edge.second;
                if(nd < dist[v]){
                    dist[v] = nd;
                    pq.push({nd, v});
                }
            }
        }
        return dist;
    };

    vector<ll> dA = dijkstra(A);
    vector<ll> dB = dijkstra(B);
    vector<ll> dC = dijkstra(C);

    ll bestVal = -1;
    int bestIdx = 0;
    for(int i = 1; i <= N; i++){
        ll v = min(dA[i], min(dB[i], dC[i]));
        if(v == INF) continue;
        if(v > bestVal){
            bestVal = v;
            bestIdx = i;
        }
    }

    cout << bestIdx;
    return 0;
}
