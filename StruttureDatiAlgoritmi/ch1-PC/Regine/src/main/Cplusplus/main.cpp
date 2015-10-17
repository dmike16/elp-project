#include <iostream>
#include "regine.hxx"

using namespace std;

int queens;

int main(){
	int c[QUEENMAX], cb[QUEENMAX],l[2*QUEENMAX], r[2*QUEENMAX];

	for (int i= 0; i < QUEENMAX; i++){
		c[i] = 0;
		cb[i] = 0;
	}
	for (int i = 0; i < 2*QUEENMAX; i++){
		l[i] = 0;
		r[i] = 0;
	}
	columns = c;
	rightDiag = r;
	leftDiag = l;
	chessboard = cb;
	cout<<"Insert the queens number Max=10\n";
	do{
		cin>>queens;
	} while(queens < 1 || queens > 10);

	regine(0);

	cout<<"Thera are "<<total<<" solutions"<<endl;
	
	return 0;
}