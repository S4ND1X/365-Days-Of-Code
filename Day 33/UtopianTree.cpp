int heightUTree(int n){
    int res = 1;
    for(int c=1; c<=n; c++){
        if (c%2 == 0) res++;
        else res *=2;
    }
    return res;
}

int main(){
    int t;
    cin >> t;
    for (int a = 0; a < t; a++){
        int n;
        cin >> n;
        cout << heightUTree(n)<< endl;;
    }
    return 0;
}
