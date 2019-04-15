#include <iostream>
#include <string>
#include <climits>
#include <sstream>
#include <functional>
#include <algorithm>

using namespace std;

void ltrim(string &s) {
	s.erase(s.begin(), find_if(s.begin(), s.end(),
		not1(ptr_fun<int, int>(isspace))));
}

int main()
{
	int max_val = INT_MIN;
	string line, key;
	string last_key = "";
	int value;

	stringstream ss;

	while (getline(cin, line))
	{
		ltrim(line);				// ltrim trims any preceeding white space of a string
		ss.str(line);               // stringstream extracts words from a string
		ss >> key; ss >> value;		// extracts 2 words into the key and value variables
		ss.clear();

		if (last_key != "" && last_key != key) {
			cout << last_key + "\t" << max_val << endl;
			last_key = key;
			max_val = value;
		}
		else {
			last_key = key;
			max_val = max(max_val, value);
		};
	}
	cout << last_key + "\t" << max_val << endl;

	return 0;
}
