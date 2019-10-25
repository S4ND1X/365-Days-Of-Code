#include<iostream>
using namespace std;
//*Se crea la estructura
struct Nodo
{
    int data;
    //?Definimos una referencia al nodo de la derecha y la izquierda
    struct Nodo* left, *right;
    //?El constrcutor recibe el dato e iniciliza los hijos en null;
    Nodo(int data){
        this->data = data;
        this->left = this->right = NULL;
    }
};

void printInOrder(struct Nodo* Nodo);
int main(){
    struct Nodo *root = new Nodo(1);
    root->left= new Nodo(2);
    root->right= new Nodo(3);
    root->left->left= new Nodo(4);
    root->left->right= new Nodo(5);

    printInOrder(root);
    return 0;
}
void printInOrder(struct Nodo* Nodo){
    //?Si current Nodo es null simplemente regresa
    if(Nodo == NULL) return;
    //?Si no, recorre hasta la izquierda
    printInOrder(Nodo->left);
    //?Una vez recorrido hasta la izquierda, regresa, y al ya haber visto que era null y que se fue a la derecha, se pasa a imprimir
    cout << Nodo->data << " -> ";
    //?Ya que imprimio ahora hace lo mismo pero se va hasta la derecha
    printInOrder(Nodo->right);
}