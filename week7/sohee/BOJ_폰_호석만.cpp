#include <bits/stdc++.h>
using namespace std;

long long parse(const string& s, int base, long long limit) {
    long long val = 0;
    for (char c : s) {
        int d = (isdigit(c) ? c - '0' : c - 'a' + 10);
        if (d >= base) return -1;              // 해당 진법에서 불가능한 숫자
        if (val > limit / base) return -1;     // 오버플로우 방지
        val = val * base + d;
        if (val > limit) return -1;            // 상한 초과
    }
    return val;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string A, B;
    cin >> A >> B;

    long long X = -1;
    int baseA = -1, baseB = -1;

    // 가능한 진법 범위: 2 ~ 36
    for (int a = 2; a <= 36; a++) {
        long long valA = parse(A, a, LLONG_MAX);
        if (valA == -1) continue;

        for (int b = 2; b <= 36; b++) {
            long long valB = parse(B, b, LLONG_MAX);
            if (valB == -1) continue;

            if (valA == valB) {
                if (X != -1 && X != valA) {
                    cout << "Multiple\n";
                    return 0;
                }
                X = valA;
                baseA = a;
                baseB = b;
            }
        }
    }

    if (X == -1) {
        cout << "Impossible\n";
    } else {
        cout << X << ' ' << baseA << ' ' << baseB << '\n';
    }

    return 0;
}