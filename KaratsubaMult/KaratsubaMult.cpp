#include <iostream>
#include <cmath>
#include <cstdint>

using namespace std;

int length(const uint64_t x);
uint64_t karatsuba_multiply(const uint64_t x, const uint64_t y);

int main() {
	cout << karatsuba_multiply(3,3) << endl;
	cout << karatsuba_multiply(3,0) << endl;
	cout << karatsuba_multiply(0,3) << endl;
	cout << karatsuba_multiply(10,9) << endl;
	cout << karatsuba_multiply(10,10) << endl;
	cout << karatsuba_multiply(9,10) << endl;
	cout << karatsuba_multiply(0,100) << endl;
	cout << karatsuba_multiply(9,100) << endl;
	cout << karatsuba_multiply(99,100) << endl;
	cout << karatsuba_multiply(100,100) << endl;
	cout << karatsuba_multiply(100,0) << endl;
	cout << karatsuba_multiply(100,9) << endl;
	cout << karatsuba_multiply(100,99) << endl;
	cout << karatsuba_multiply(100,100) << endl;
	return 0;
}

int length(const uint64_t x) {
	int n = 0;
	uint64_t xx = x;
	do {
		xx /= 10;
		n++;
	} while (xx > 0);
	return n;
}
uint64_t karatsuba_multiply(const uint64_t x, const uint64_t y) {
	int nx = length(x);
	int ny = length(y);
	int n = max(nx, ny);

	if (n == 1) {
		return x*y;
	}

	int n2 = (n+1) / 2;
	int factor = pow(10, n2);

	uint64_t a = x / factor;
	uint64_t b = x - factor*a;
	uint64_t c = y / factor;
	uint64_t d = y - factor*c;

	uint64_t ac = karatsuba_multiply(a, c);
	uint64_t bd = karatsuba_multiply(b, d);
	uint64_t abcd = karatsuba_multiply(a+b, c+d);

	return ac * factor * factor + (abcd - ac - bd) * factor + bd;
}
