#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, W;
    double M;
    cin >> N >> W >> M;

    vector<pair<int,int>> pos(N+1);
    for(int i = 1; i <= N; i++){
        cin >> pos[i].first >> pos[i].second;
    }

    // 인접리스트: {다음 정점, 비용}
    vector<vector<pair<int,double>>> adj(N+1);

    // 가능한 모든 간선 거리 계산
    for(int i = 1; i <= N; i++){
        for(int j = i+1; j <= N; j++){
            double dx = pos[i].first - pos[j].first;
            double dy = pos[i].second - pos[j].second;
            double dist = sqrt(dx*dx + dy*dy);
            if(dist <= M){
                adj[i].push_back({j, dist});
                adj[j].push_back({i, dist});
            }
        }
    }

    // 기존 연결되어 있는 전선 → 가중치 0 처리
    for(int i = 0; i < W; i++){
        int a, b;
        cin >> a >> b;
        adj[a].push_back({b, 0.0});
        adj[b].push_back({a, 0.0});
    }

    const double INF = 1e18;
    vector<double> dist(N+1, INF);
    dist[1] = 0.0;

    priority_queue<pair<double,int>, vector<pair<double,int>>, greater<pair<double,int>>> pq;

    pq.push({0.0, 1});

    while(!pq.empty()){
        auto [cd, cur] = pq.top();
        pq.pop();
        if(cd > dist[cur]) continue;
        if(cur == N) break;

        for(auto &edge : adj[cur]){
            int nxt = edge.first;
            double cost = edge.second;
            if(dist[nxt] > dist[cur] + cost){
                dist[nxt] = dist[cur] + cost;
                pq.push({dist[nxt], nxt});
            }
        }
    }

    long long answer = (long long)(dist[N] * 1000.0);
    cout << answer << "\n";

    return 0;
}
