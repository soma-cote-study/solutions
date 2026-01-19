#include <bits/stdc++.h>
using namespace std;
int n;
string s;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;
    while(n--){
        cin >> s;
        sort(s.begin(), s.end());
        do {
            cout << s << "\n";
        } while(next_permutation(s.begin(), s.end()));
    }
    return 0;
}
