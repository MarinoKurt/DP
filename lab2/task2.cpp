
#include <cstring>
#include <iostream>
#include <vector>
#include <set>

template<typename Iterator, typename Predicate>
Iterator mymax(
        Iterator cur, Iterator last, Predicate pred) {
    Iterator max = cur;
    while (cur != last) {
        if (pred(*cur, *max)) {
            max = cur;
        }
        cur++;
    }
    return max;
}



int gt_int(int a, int b) {
    return a - b > 0;
}

int gt_char(char a, char b) {
    return a - b > 0;
}

int gt_str(const char* a, const char* b) {
    int r = std::strcmp(a, b);
    r = r > 0 ? 1 : r;
    r = r < 0 ? 0 : r;
    return r;
}



int main() {
    int arr_int[] = {1, 3, 5, 7, 4, 6, 9, 2, 0};
    const int *maxint = mymax(&arr_int[0], &arr_int[sizeof(arr_int) / sizeof(*arr_int)], gt_str);
    std::cout << *maxint << "\n";

    std::vector<int> v(10);
    v.push_back(1);
    v.push_back(4);
    v.push_back(5);
    v.push_back(3);
    v.push_back(7);
    v.push_back(8);
    v.push_back(0);

    const int *maxv = mymax(&v.at(0), &v.at(v.size()-1), gt_int);
    std::cout << *maxv << "\n";

    int myints[]= {10,20,30,40,50};
    std::set<int> set (myints,myints+5);

    const int maxs = *mymax(set.begin(), set.end(), gt_int);
    std::cout << maxs << "\n";

    char arr_char[] = "Suncana strana ulice";
    const char* maxchar = mymax(&arr_char[0], &arr_char[sizeof(arr_char) / sizeof(*arr_char)], gt_char);
    std::cout << *maxchar << "\n";

    const char* arr_str[] = {
            "Gle", "malu", "vocku", "poslije", "kise",
            "Puna", "je", "kapi", "pa", "ih", "njise"
    };
    const char** maxstr = mymax(&arr_str[0], &arr_str[sizeof(arr_str) / sizeof(*arr_str)], gt_str);
    std::cout << *maxstr << "\n";

}