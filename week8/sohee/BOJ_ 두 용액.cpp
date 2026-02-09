#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; i++) cin >> arr[i];

    sort(arr.begin(), arr.end());

    int lo = 0, hi = n - 1;
    int ansL = arr[0], ansR = arr[n - 1];
    long long best = abs((long long)arr[lo] + arr[hi]);

    while (lo < hi) {
        long long sum = (long long)arr[lo] + arr[hi];
        if (abs(sum) < best) {
            best = abs(sum);
            ansL = arr[lo];
            ansR = arr[hi];
        }
        if (sum < 0) {
            lo++;
        } else if (sum > 0) {
            hi--;
        } else {
            break;
        }
    }

    cout << ansL << " " << ansR << "\n";
    return 0;
}