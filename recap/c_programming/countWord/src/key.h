#ifndef KEY_H
#define KEY_H

struct key;
typedef struct key KEY;

KEY *
bisearch(char *, KEY *, int);
int getword(char*,int lim);
int size(void);
void countplus(KEY *);
int get_count(KEY *);
char* get_word(KEY *);
void show_result(void);

extern KEY *keytab;

#endif
