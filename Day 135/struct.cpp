#include <iostream>

using namespace std;

struct trabajo{
    char vocacion[20];
    int salario;
};
struct Persona{
    char nombre[20];
    int edad;
    struct trabajo trabajoPer;
    
}per[3];

int main(){

    for(int i = 0; i<3; i++){
    cin >> per[i].nombre >> per[i].edad;    
    cin >> per[i].trabajoPer.salario;
    cin >> per[i].trabajoPer.vocacion;
    }
    printf("Tu nombre es %s y tu edad es %d\n",per[0].nombre,per[0].edad);
    
    printf("Tu nombre vocacion es %s y tu sueldo es de %d$",per[0].trabajoPer.vocacion,per[0].trabajoPer.salario);

    return 0;
}