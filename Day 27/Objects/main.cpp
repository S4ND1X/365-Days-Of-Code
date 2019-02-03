#include <iostream>

using namespace std;

//This is how you create a class
class Student{
    public:
        string name;
        int age;
        // How to create a student
        Student(string aName, int aAge){
            name = aName;
            age = aAge;
        }
};
int main()
{

    Student student1("Jorge",18);
    cout << student1.age;

    return 0;
}
