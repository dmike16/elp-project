#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include "key.h"

 static struct key{
	char *word;
	int count;
} _keytab[] = {
	{"auto",0},
	{"break",0},
	{"case",0},
	{"char",0},
	{"const",0},
	{"continue",0},
	{"default",0},
	{"void",0},
	{"volatile",0},
	{"while",0}
};

KEY *
bisearch(char *word,KEY *tab,int n)
{
	int cond;
	KEY *low = &tab[0];
	KEY *high = &tab[n];
	KEY *mid;

	while(low < high){
		mid = low + (high-low)/2;
		if((cond = strcmp(word,mid->word)) < 0){
			high = mid;
		}else if(cond > 0){
			low = mid +1;
		}else{
			return mid;
		}
	}
	return NULL;
}

int getword(char *word,int lim)
{
	int c, getch(void);
	void ungetch(int);
	char *w = word;

	while(isspace(c = getch()));
	if(c != EOF){
		*w++ = c;
	}
	if(!isalpha(c)){
		*w = '\0';
		return c;
	}
	for(;--lim > 0; w++){
		if(!isalnum(*w = getch())){
			ungetch(*w);
			break;
		}
	}
	*w = '\0';
	return word[0];
}

int size(void)
{
	return sizeof _keytab / sizeof(KEY);
}

void countplus(KEY *p)
{
	p->count++;
	return;
}

int get_count(KEY *p)
{
	return p->count;
}

char *get_word(KEY *p)
{
	return p->word;
}

void show_result(void)
{
	int n;
	KEY *tmp;
	for(tmp = _keytab, n = size(); tmp < _keytab + n; tmp++)
		if(get_count(tmp) > 0)
			printf("%4d %s\n",get_count(tmp),get_word(tmp));
}
KEY *keytab = _keytab;
