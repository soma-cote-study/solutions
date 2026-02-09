#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    while (T--) {
        int M;
        cin >> M;

        // maxHeap: 중앙값 이하 (top = 중앙값)
        // minHeap: 중앙값 초과
        priority_queue<int> maxHeap;                            // 최대 힙
        priority_queue<int, vector<int>, greater<int>> minHeap; // 최소 힙

        int cnt = 0;
        cout << (M + 1) / 2 << "\n";

        for (int i = 1; i <= M; i++) {
            int x;
            cin >> x;

            // 항상 maxHeap.size() >= minHeap.size() 유지
            if (maxHeap.empty() || x <= maxHeap.top()) {
                maxHeap.push(x);
            } else {
                minHeap.push(x);
            }

            // 크기 균형 맞추기: maxHeap이 1개 더 많거나 같도록
            while (maxHeap.size() > minHeap.size() + 1) {
                minHeap.push(maxHeap.top());
                maxHeap.pop();
            }
            while (maxHeap.size() < minHeap.size()) {
                maxHeap.push(minHeap.top());
                minHeap.pop();
            }

            if (i % 2 == 1) {
                cnt++;
                cout << maxHeap.top();
                if (cnt % 10 == 0) cout << "\n";
                else if (i < M) cout << " ";
            }
        }
        if (cnt % 10 != 0) cout << "\n";
    }

    return 0;
}