#include <bits/stdc++.h>
using namespace std;

int R, C, N;
vector<string> board;

const int dy[4] = {-1, 1, 0, 0};
const int dx[4] = {0, 0, -1, 1};

vector<string> explode(const vector<string>& b) {
    vector<string> res(R, string(C, 'O'));

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (b[i][j] == 'O') {
                res[i][j] = '.';
                for (int d = 0; d < 4; d++) {
                    int ny = i + dy[d];
                    int nx = j + dx[d];
                    if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
                    res[ny][nx] = '.';
                }
            }
        }
    }
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> R >> C >> N;
    board.resize(R);
    for (int i = 0; i < R; i++) {
        cin >> board[i];
    }

    if (N == 1) {
        for (auto& s : board) cout << s << "\n";
    }
    else if (N % 2 == 0) {
        for (int i = 0; i < R; i++) {
            cout << string(C, 'O') << "\n";
        }
    }
    else {
        vector<string> first = explode(board);
        vector<string> second = explode(first);

        if (N % 4 == 3) {
            for (auto& s : first) cout << s << "\n";
        } else { // N % 4 == 1
            for (auto& s : second) cout << s << "\n";
        }
    }
}
