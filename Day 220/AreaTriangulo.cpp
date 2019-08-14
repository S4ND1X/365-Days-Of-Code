#include <iostream>
using namespace std;

float calcularArea(float, float);
int main()
{
    try
    {
        cout << "Ingrese una base y altura: ";
        float base,
            altura;
        cin >> base >> altura;
        if (base <= 0 || altura <= 0)
            throw 'a';
        cout << "El area del triangulo es " << calcularArea(base, altura) << endl;
    }
    catch (char e)
    {
        cout << "Dato inválido, cerrando programa " << endl;
    }

    return 0;
}

float calcularArea(float base, float altura)
{
    return base * altura / 2;
}