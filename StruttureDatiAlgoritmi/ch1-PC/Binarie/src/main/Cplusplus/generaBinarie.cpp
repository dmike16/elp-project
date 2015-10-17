#include <iostream>
#include "generaBinarie.hxx"

using namespace std;

namespace{
 	void elabora(int* A, int dim){
		cout<< "{ ";
		for (int i = 0; i < dim ; i++){
			if (A[i] == 1){
				cout<<i<<" ";
			}
		}
		cout<<"}"<<endl;
	}
}

void generaBinarie(int* A, int b, int dim){
	if (b == 0){
		elabora(A,dim);
	} else {
		A[b-1] = 0;
		generaBinarie(A,b-1,dim);
		A[b-1] = 1;
		generaBinarie(A,b-1,dim);
	}
}
