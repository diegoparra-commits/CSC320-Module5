#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>
#include <iterator>

using namespace std;

void reverseFileContent(const string& inputFile, const string& outputFile) {
    ifstream inFile(inputFile);

    if (!inFile.is_open()) {
        cout << "Error: Unable to open " << inputFile << " for reading." << endl;
        return;
    }

    string content((istreambuf_iterator<char>(inFile)), istreambuf_iterator<char>());
    inFile.close();

    reverse(content.begin(), content.end());

    ofstream outFile(outputFile);
    if (!outFile.is_open()) {
        cout << "Error: Unable to open " << outputFile << " for writing." << endl;
        return;
    }

    outFile << content;
    outFile.close();

    cout << "Successfully reversed the content and saved to " << outputFile << endl;
}

int main() {
    string filename = "CSC450_CT5_mod5.txt";
    string reverseFilename = "CSC450-mod5-reverse.txt";
    string userInput;

    ofstream outFile(filename, ios::app);

    if (!outFile.is_open()) {
        cout << "Error: Unable to open " << filename << " for appending." << endl;
        return 1;
    }

    cout << "Enter text to append to the file: ";
    getline(cin, userInput);

    outFile << userInput << "\n";
    outFile.close();

    cout << "Input successfully appended to " << filename << endl;

    reverseFileContent(filename, reverseFilename);

    return 0;
}
