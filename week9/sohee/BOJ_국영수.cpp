#include <bits/stdc++.h>
using namespace std;

struct Student {
    string name;
    int kor, eng, math;
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    vector<Student> v(n);

    for (int i = 0; i < n; i++) {
        cin >> v[i].name >> v[i].kor >> v[i].eng >> v[i].math;
    }

    sort(v.begin(), v.end(), [](const Student& a, const Student& b) {
        if (a.kor != b.kor) return a.kor > b.kor;
        if (a.eng != b.eng) return a.eng < b.eng;
        if (a.math != b.math) return a.math > b.math;
        return a.name < b.name;
    });

    for (auto& s : v) cout << s.name << "\n";
}