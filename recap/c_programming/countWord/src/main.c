#include <stdio.h>
#include <ctype.h>
#include "key.h"

#define MAXWORD 100

int main(void)
{
	KEY *p;
	int n;
	char word[MAXWORD];
	while(getword(word,MAXWORD) != EOF){
		if(isalpha(word[0]))
			if((p = bisearch(word,keytab,size())) != NULL)
					countplus(p);
	}
	show_result();
	return 0;			
}
