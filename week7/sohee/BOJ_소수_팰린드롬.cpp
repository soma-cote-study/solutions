#include <bits/stdc++.h>
using namespace std;

bool isPalindrome(int x) {
    string s = to_string(x);
    int l = 0, r = s.size() - 1;
    while (l < r) {
        if (s[l] != s[r]) return false;
        l++; r--;
    }
    return true;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    const int MAXN = 2000000;
    vector<bool> isPrime(MAXN + 1, true);
    isPrime[0] = isPrime[1] = false;

    for (int i = 2; i * i <= MAXN; i++) {
        if (!isPrime[i]) continue;
        for (int j = i * i; j <= MAXN; j += i) {
            isPrime[j] = false;
        }
    }

    for (int x = N; x <= MAXN; x++) {
        if (isPrime[x] && isPalindrome(x)) {
            cout << x << '\n';
            break;
        }
    }

    return 0;
}