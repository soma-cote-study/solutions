#include <bits/stdc++.h>
using namespace std;

int main() {
    string s;
    cin >> s;

    int sum = 0;
    string tmp = "";
    bool minus = false;

    for (int i = 0; i <= s.size(); i++) {
        if (i == s.size() || s[i] == '+' || s[i] == '-') {
            int num = stoi(tmp);
            if (minus) sum -= num;
            else sum += num;
            tmp = "";
            if (i < s.size() && s[i] == '-') minus = true;
        } else {
            tmp += s[i];
        }
    }

    cout << sum;
}
