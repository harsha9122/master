#include <iostream>
#include <string>
#include <regex>
#include <functional>

using namespace std;

/*this ltrim method trims any preceeding white space
  of a string */
void ltrim(string &s) {
	s.erase(s.begin(), find_if(s.begin(), s.end(),
		not1(ptr_fun<int, int>(isspace))));
}

int main()
{
	string line;
	regex check("[01459]");

	while (getline(cin, line))
	{
		ltrim(line);	// trim any leading white space
		string year = line.substr(15, 4);
		string temp = line.substr(87, 5);
		string quality = line.substr(92, 1);

		if ((temp != "+9999") && (regex_match(quality, check))) {
			cout << year + "\t" + temp << endl;
		};
	}

	return 0;
}
