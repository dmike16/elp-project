#include <iostream>
#include "torriHanoi.hxx"

using namespace std;

void torriHanoi(int n, string fr, string sd, string th){
	if (n == 1){
		cout<< fr << "------>" <<th <<endl;
	} else {
		torriHanoi(n-1, fr, th, sd);
		cout <<fr<< "------->"<< th <<endl;
		torriHanoi(n-1, sd, fr, th);
	}
	return;
}
void torriHanoiP(int n, int k){
	for (int i = 1; i <= k-2; i++){
		torriHanoi((int)n/(k-2),to_string(0), to_string(k-1), to_string(i));
	}
	for (int i = k-2; i >=1; i--){
		torriHanoi((int)n/(k-2), to_string(i), to_string(0), to_string(k-1));
	}

	return;
}