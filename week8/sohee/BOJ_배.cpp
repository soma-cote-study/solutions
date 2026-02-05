#include <bits/stdc++.h>
using namespace std;

int main() {
    int N, M;
    cin >> N;
    vector<int> crane(N);
    for (int i = 0; i < N; i++) cin >> crane[i];

    cin >> M;
    vector<int> box(M);
    for (int i = 0; i < M; i++) cin >> box[i];

    sort(crane.rbegin(), crane.rend());
    sort(box.rbegin(), box.rend());

    if (box[0] > crane[0]) {
        cout << -1;
        return 0;
    }

    int time = 0;
    while (!box.empty()) {
        time++;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < box.size(); j++) {
                if (crane[i] >= box[j]) {
                    box.erase(box.begin() + j);
                    break;
                }
            }
        }
    }

    cout << time;
}