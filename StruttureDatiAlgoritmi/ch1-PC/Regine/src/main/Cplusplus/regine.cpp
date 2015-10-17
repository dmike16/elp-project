#include <iostream>
#include <cmath>
#include "regine.hxx"

using namespace std;

namespace {
	void printSolution(){
		cout<< "There is a Solution"<<endl;
		return;
	};
}

void regine(int row){
	int col, left_diag, right_diag;
	for (col = queens-1, left_diag = row + col, right_diag = col-row + queens-1;
	col >= 0; col--,left_diag--,right_diag--){
		if (!columns[col] && !leftDiag[left_diag] && !rightDiag[right_diag]){
			columns[col] = 1;
			leftDiag[left_diag] = 1;
			rightDiag[right_diag] = 1;
			chessboard[row] = col;

			if (row < queens-1){
				regine(row + 1);
			}
			else {
				total++;
				printSolution();
			}
			columns[col] = 0;
			leftDiag[left_diag]= 0;
			rightDiag[right_diag]= 0;
		}
	}
}
 int* columns = 0;
 int* leftDiag = 0;
 int* rightDiag = 0;
 int* chessboard = 0;
 int total = 0;